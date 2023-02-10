package py.com.patterns.api.prototype;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

public class PrototypeApplication {

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
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n PrototypeApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		LoanRequestPreLoadedTemplate template1 = new LoanRequestPreLoadedTemplate();
		log.info("\n -------------------"
				+"\n template1 created"
				+"\n" + template1.toString()				
				+"\n -------------------");
		
		LoanRequestPreLoadedTemplate template2 = template1.clone();
		template2.data.put("TEMPLATE_2_DATA", "ABC");
		log.info("\n -------------------"
				+"\n template2 added data in map"
				+"\n template2: " + template2.toString()	
				+"\n template2 is a clone of template1, ¿is template1 a reflection of template2?"
				+"\n template1: " + template1.toString()
				+"\n -------------------");
		
	}

}
