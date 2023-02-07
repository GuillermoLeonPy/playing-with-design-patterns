package py.com.patterns.api.command;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.command.receiver.ApiClientReceiver;
import py.com.patterns.api.command.receiver.ApiClientReceiver.ApiOperation;

public class AmadeusGetFlightDealsCommand extends CommonApiGetFlightDealsCommand implements ApiGetFlightDealsCommand {

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
	
	public AmadeusGetFlightDealsCommand(ApiClientReceiver apiClientReceiver) {
		super(apiClientReceiver);
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n AmadeusGetFlightDealsCommand class constructor"
				+"\n apiClientReceiver: " + apiClientReceiver.getClass()
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}	
	
	@Override
	public Map<String, Object> getFlightDeals(Map<String, Object> operationDataCommandInput) {	
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n AmadeusGetFlightDealsCommand class getFlightDeals method; operationDataCommandInput: " + operationDataCommandInput
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return apiClientReceiver.call(ApiOperation.GET_FLIGHT_DEALS, operationDataCommandInput);
	}




}
