package streams;

public class CalculatorRunner {
	public static void main(String[] args) {

		Calculator calc = new Calculator();
		int equals = calc.add(10).multiply(10).subtract(10).equals();
		System.out.println(equals);
	}
}


class Calculator{
	int num=0;
	Calculator add(int number) {
		num +=number;
		return this;
	}
	Calculator subtract(int number) {
		num -=number;
		return this;
	}
	Calculator multiply(int number) {
		num *=number;
		return this;
	}
	int equals() {
		return num;
	}
	@Override
	public String toString() {
		return "Calculator [num=" + num + "]";
	}
	
}