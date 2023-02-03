package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import ch.qos.logback.core.util.StringCollectionUtil;

class CalculatorBaseFunctionality extends CalculatorBehaviour {
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
	final DecorationLevel decorationLevel;
	
	CalculatorBaseFunctionality(DecorationLevel decorationLevel) {
		super();
		this.decorationLevel = decorationLevel;
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "*********************************************"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "CalculatorBaseFunctionality class constructor"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "*********************************************");
	}



	@Override
	Map<CalculatorOperation, BigDecimal> doOperation(Map<String, BigDecimal> operationParameters) {
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "****************************************************"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "CalculatorBaseFunctionality class doOperation method"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "Contains some behaviour, apply some business logic"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "****************************************************");
		Map<CalculatorOperation, BigDecimal> baseFunctionalityResult = new HashMap<CalculatorOperation, BigDecimal>();
		baseFunctionalityResult.put(CalculatorOperation.BASE_FUNCTIONALITY, BigDecimal.ZERO);
		return baseFunctionalityResult;
	}

}
