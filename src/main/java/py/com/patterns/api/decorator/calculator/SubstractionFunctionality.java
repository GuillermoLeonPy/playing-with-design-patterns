package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

class SubstractionFunctionality extends CalculatorFunctionalityBodyStructure {
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
	
	protected SubstractionFunctionality(DecorationLevel decorationLevel) {
		super(decorationLevel);
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "-------------------------------------------"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "SubstractionFunctionality class constructor"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "-------------------------------------------");
	}

	@Override
	protected Map<CalculatorOperation, BigDecimal> doOperation(Map<String, BigDecimal> operationParameters) {
		Map<CalculatorOperation, BigDecimal> superDoOperationResult = super.doOperation(operationParameters);
		BigDecimal substraction = BigDecimal.ZERO;		
		Set<String> ks = operationParameters.keySet();
		StringBuilder sb = new StringBuilder();
		int index = 0;
		for(String key:ks) {
			if(index == 0) {
				substraction = operationParameters.get(key);
			}else {
				substraction = substraction.add(operationParameters.get(key).multiply(BigDecimal.ZERO.subtract(BigDecimal.ONE)));
				sb.append(operationParameters.get(key) + " - ");	
			}			
			index++;
		}
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "--------------------------------------------------"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "SubstractionFunctionality class doOperation method: " + sb.toString() + " = " + substraction
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "--------------------------------------------------");
		superDoOperationResult.put(CalculatorOperation.SUBSTRACTION, substraction);
		return superDoOperationResult;
	}

	
}
