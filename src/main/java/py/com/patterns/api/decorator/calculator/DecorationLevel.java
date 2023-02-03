package py.com.patterns.api.decorator.calculator;

enum DecorationLevel {

	ONE(20),
	TWO(40),
	THREE(60);
	
	final Integer levelValue;

	private DecorationLevel(Integer levelValue) {
		this.levelValue = levelValue;
	}	
}
