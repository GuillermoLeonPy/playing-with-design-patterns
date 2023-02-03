package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

abstract class CalculatorFunctionalityBodyStructure extends CalculatorBehaviour {

	private static final Logger log = getLogger(lookup().lookupClass());
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
	
	CalculatorBehaviour functionality;	
	final DecorationLevel decorationLevel;
	
	/**
	 * Constructor declared with no modifier, ¿it can be invoked from a sub class ?
	 * If the sub class is located in the same package
	 * If the sub class is located outside the super class package
	 * 
	 * @param decorationLevel
	 */
	CalculatorFunctionalityBodyStructure(final DecorationLevel decorationLevel) {
		super();		
		this.decorationLevel = decorationLevel;
		log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "###############################################################"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "CalculatorFunctionalityBodyStructure abstract class constructor"
				+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "###############################################################");
	}	
	
	void setFunctionality(CalculatorBehaviour functionality) {
		this.functionality = functionality;
	}

	@Override
	Map<CalculatorOperation, BigDecimal> doOperation(Map<String, BigDecimal> operationParameters) {
		if(this.functionality != null) {			
			log.info("\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "###############################################################################"
					+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "CalculatorFunctionalityBodyStructure abstract class doOperation method. Class: " + functionality.getClass()
					+"\n " + StringUtils.leftPad("Level : " + this.decorationLevel, this.decorationLevel.levelValue) + "###############################################################################");
			return this.functionality.doOperation(operationParameters);
		}
		return new HashMap<CalculatorOperation, BigDecimal>();
	}

}
