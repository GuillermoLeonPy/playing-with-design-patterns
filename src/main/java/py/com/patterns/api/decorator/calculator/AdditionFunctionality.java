package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

class AdditionFunctionality extends CalculatorFunctionalityBodyStructure {
	/*
	https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
	https://www.baeldung.com/java-access-modifiers
	The Java Tutorials have been written for JDK 8
	----------------------------------------------
	Modifier	Class	Package	Subclass	World
	public			Y		Y		Y			Y
	protected		Y		Y		Y			N
	no modifier		Y		Y		N			N
	known as the default access modifier also called package-private
	
	
	private			Y		N		N			N	
	 */
	private static final Logger log = getLogger(lookup().lookupClass());
	
	AdditionFunctionality(DecorationLevel decorationLevel) {
		/**
		 * calls super class no access modifier declared constructor
		 * ¿it should be possible from a sub class?
		 * If the sub class is located in the same package
		 * If the sub class is located outside the super class package
		 * 
		 * it also can be invoked the no modifier declared setFunctionality method
		 * ¿it should be possible from a sub class?
		 * If the sub class is located in the same package
		 * If the sub class is located outside the super class package
		 * super.setFunctionality(functionality);
		 */
		super(decorationLevel);
		
		
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "+++++++++++++++++++++++++++++++++++++++"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "AdditionFunctionality class constructor"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "+++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	Map<CalculatorOperation, BigDecimal> doOperation(Map<String, BigDecimal> operationParameters) {
		Map<CalculatorOperation, BigDecimal> superDoOperationResult = super.doOperation(operationParameters);
		BigDecimal summation = BigDecimal.ZERO;				
		Set<String> ks = operationParameters.keySet();
		StringBuilder sb = new StringBuilder();
		for(String key:ks) {
			summation = summation.add(operationParameters.get(key));
			sb.append(operationParameters.get(key) + " + ");
		}		
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "++++++++++++++++++++++++++++++++++++++++++++++++"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "AdditionFunctionality class doOperation method: " + sb.toString() + " = " + summation
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "+++++++++++++++++++++++++++++++++++++++++++++++");
		superDoOperationResult.put(CalculatorOperation.ADDITION, summation);
		return superDoOperationResult;
	}
}
