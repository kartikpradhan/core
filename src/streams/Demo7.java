package streams;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo7 {
	public static void main(String[] args) {
		int[] input = { 2, 4, 1, 7, 5, 3, 9 };

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == 10) {
					System.out.println(input[i] + "," + input[j]);
				}
			}
		}
		
		
		List<Product> prodList = Arrays.asList(new Product("abc"),
				new Product("abc"),
				new Product("bca"),
				new Product("cba"));
		Set<String> set = new LinkedHashSet<>();

		List<Product> uniqueProdList = prodList.stream().filter(p->set.add(p.getName())).collect(Collectors.toList());
		System.out.println(uniqueProdList);
	}
	
}

class Product{
	private String name;
	
	public Product(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}