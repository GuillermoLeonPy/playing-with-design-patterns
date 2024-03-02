package py.com.patterns.api.decorator.math.operations.pipeline;

import java.util.function.Function;
import java.util.stream.Stream;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> operation = ((a) -> a + 1);
		Function<Integer, Integer> operation2 = ((a) -> a * 2);
		Function<Integer, Integer> operation3 = ((a) -> a * 3);
		
		print(1, operation, operation2, operation3);
	}
	
	private static void print(int number, Function<Integer, Integer> operation) {
		System.out.println(operation.apply(number));
	}
	
	private static void print(int number, Function<Integer, Integer> ...operations) {
		//Function::andThen
		//Returns a composed function that first applies this function to its input, and then applies the after function to the result
		int result = Stream.of(operations).reduce(Function.identity(),Function::andThen).apply(number);
		System.out.println(result);
	}

}


