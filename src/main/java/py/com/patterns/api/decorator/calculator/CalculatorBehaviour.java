package py.com.patterns.api.decorator.calculator;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.Map;

import org.slf4j.Logger;

abstract class CalculatorBehaviour {

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
	
	/**
	 * 
	 */
	CalculatorBehaviour() {
		super();
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n CalculatorBehaviour abstract class constructor"
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	abstract Map<CalculatorOperation,BigDecimal> doOperation(Map<String,BigDecimal> operationParameters);
}
