package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;

class CalculatorApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		log.info("\n $$$$$$$$$$$$$$$$$$$$$$$"
				+"\n initializing calculator"
				+"\n $$$$$$$$$$$$$$$$$$$$$$$");		
		CalculatorBaseFunctionality baseFunctionality = new CalculatorBaseFunctionality(DecorationLevel.ONE);
		log.info("\n $$$$$$$$$$$$$$$$$$$$$$$"
				+"\n calling baseFunctionality.doOperation \n" + baseFunctionality.doOperation(generateOperationParameters())
				+"\n $$$$$$$$$$$$$$$$$$$$$$$");
		AdditionFunctionality additionFunctionality = new AdditionFunctionality(DecorationLevel.TWO);
		/**
		 * calls super abstract class CalculatorFunctionalityBodyStructure setFunctionality method
		 * decorating the additionFunctionality with the baseFunctionality
		 */
		additionFunctionality.setFunctionality(baseFunctionality);
		log.info("\n $$$$$$$$$$$$$$$$$$$$$$$"
				+"\n additionFunctionality decorated with baseFunctionality"
				+"\n calling additionFunctionality.doOperation \n" + additionFunctionality.doOperation(generateOperationParameters())
				+"\n $$$$$$$$$$$$$$$$$$$$$$$");
		SubstractionFunctionality substractionFunctionality = new SubstractionFunctionality(DecorationLevel.THREE);
		/**
		 * calls super abstract class CalculatorFunctionalityBodyStructure setFunctionality method
		 * decorating the substractionFunctionality with the additionFunctionality
		 */
		substractionFunctionality.setFunctionality(additionFunctionality);
		log.info("\n $$$$$$$$$$$$$$$$$$$$$$$"
				+"\n substractionFunctionality decorated with additionFunctionality"
				+"\n calling substractionFunctionality.doOperation \n" + substractionFunctionality.doOperation(generateOperationParameters())
				+"\n $$$$$$$$$$$$$$$$$$$$$$$");
		
	}

	
	static Map<String, BigDecimal> generateOperationParameters(){
		long indexBeginFrom = 1;
		long leftLimit = 0L;
	    long rightLimit = 0L;
	    long generatedLong = 0L;
	    Map<String, BigDecimal> generatedNumbers = new HashMap<String, BigDecimal>();
		for (long index = indexBeginFrom; index < (indexBeginFrom + 5); index++) {
			leftLimit = index;
			rightLimit = index + 5;
			generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			generatedNumbers.put(UUID.randomUUID().toString(), new BigDecimal(generatedLong));
		}	    
        return generatedNumbers;
	}
}
