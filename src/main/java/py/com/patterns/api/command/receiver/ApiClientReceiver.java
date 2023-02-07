package py.com.patterns.api.command.receiver;

import java.util.Map;

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
public interface ApiClientReceiver {

	enum ApiOperation{
		GET_FLIGHT_DEALS,
		MAKE_BOOKING,
		CANCEL_BOOKING
	}
	
	Map<String,Object> call(ApiOperation apiOperation, Map<String,Object> operationData);
}
