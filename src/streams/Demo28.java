package streams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class Demo28 {
	public static Collector<String, ?, Map<String, Object>> deepMergingJson() {

		class Acc {
			final Map<String, Object> root = new LinkedHashMap<>();

			void add(String json) {
				Object parsed = new JsonParser(json).parse();
				if (!(parsed instanceof Map)) {
					throw new IllegalArgumentException("Root must be JSON object");
				}
				merge(root, (Map<String, Object>) parsed);
			}

			Acc mergeAcc(Acc other) {
				merge(root, other.root);
				return this;
			}
		}

		return Collector.of(Acc::new, Acc::add, Acc::mergeAcc, acc -> acc.root);
	}

	@SuppressWarnings("unchecked")
	private static void merge(Map<String, Object> target, Map<String, Object> source) {

		for (var e : source.entrySet()) {
			String key = e.getKey();
			Object value = e.getValue();

			if (!target.containsKey(key)) {
				target.put(key, value);
			} else {
				Object existing = target.get(key);

				if (existing instanceof Map && value instanceof Map) {
					merge((Map<String, Object>) existing, (Map<String, Object>) value);
				} else if (existing instanceof List && value instanceof List) {
					((List<Object>) existing).addAll((List<Object>) value);
				} else {
					target.put(key, value); // overwrite
				}
			}
		}
	}

	static class JsonParser {
		private final String s;
		private int i = 0;

		JsonParser(String s) {
			this.s = s.trim();
		}

		Object parse() {
			skip();
			Object v = value();
			skip();
			return v;
		}

		private Object value() {
			skip();
			char c = s.charAt(i);

			if (c == '{')
				return object();
			if (c == '[')
				return array();
			if (c == '"')
				return string();
			if (c == 't')
				return literal("true", true);
			if (c == 'f')
				return literal("false", false);
			if (c == 'n')
				return literal("null", null);
			return number();
		}

		private Map<String, Object> object() {
			expect('{');
			Map<String, Object> map = new LinkedHashMap<>();
			skip();
			if (peek('}')) {
				i++;
				return map;
			}

			while (true) {
				String key = string();
				skip();
				expect(':');
				Object val = value();
				map.put(key, val);
				skip();
				if (peek('}')) {
					i++;
					break;
				}
				expect(',');
			}
			return map;
		}

		private List<Object> array() {
			expect('[');
			List<Object> list = new ArrayList<>();
			skip();
			if (peek(']')) {
				i++;
				return list;
			}

			while (true) {
				list.add(value());
				skip();
				if (peek(']')) {
					i++;
					break;
				}
				expect(',');
			}
			return list;
		}

		private String string() {
			expect('"');
			StringBuilder sb = new StringBuilder();
			while (s.charAt(i) != '"') {
				sb.append(s.charAt(i++));
			}
			i++;
			return sb.toString();
		}

		private Object number() {
			int start = i;
			while (i < s.length() && "-0123456789.".indexOf(s.charAt(i)) >= 0)
				i++;
			String n = s.substring(start, i);
			return n.contains(".") ? Double.valueOf(n) : Long.valueOf(n);
		}

		private Object literal(String lit, Object val) {
			if (!s.startsWith(lit, i))
				throw new RuntimeException("Expected " + lit);
			i += lit.length();
			return val;
		}

		private void skip() {
			while (i < s.length() && Character.isWhitespace(s.charAt(i)))
				i++;
		}

		private void expect(char c) {
			if (s.charAt(i) != c)
				throw new RuntimeException("Expected " + c);
			i++;
		}

		private boolean peek(char c) {
			return s.charAt(i) == c;
		}
	}

	public static void main(String[] args) {

		Map<String, Object> result = List.of("{\"a\":1,\"b\":{\"x\":10}}", "{\"b\":{\"y\":20},\"c\":3}",
				"{\"b\":{\"x\":99},\"d\":[1,2]}", "{\"d\":[3,4]}").stream().collect(deepMergingJson());

		System.out.println(result);
	}
}
