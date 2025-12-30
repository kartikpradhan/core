package streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Record {
	String name;
	int value;

	Record(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Record [name=" + name + ", value=" + value + "]";
	}
	
	
}

class Key {
	String category;

	Key(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		return Objects.equals(category, other.category);
	}

	@Override
	public String toString() {
		return "Key [category=" + category + "]";
	}
}

public class Demo25 {
	public static void main(String[] args) {
		Stream<String> csvLines = Stream.of(
                "A,John,10",
                "B,Mary,20",
                "A,Steve,15",
                "B,Paul,25",
                "A,Linda,30"
        );

        Map<Key, List<Record>> map = csvLines
                .map(line -> line.split(",")) 
                .collect(Collectors.groupingBy(
                        tokens -> new Key(tokens[0]),              
                        LinkedHashMap::new,                        
                        Collectors.mapping(
                                tokens -> new Record(tokens[1], Integer.parseInt(tokens[2])),
                                Collectors.toList()                    
                        )
                ));

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

}
