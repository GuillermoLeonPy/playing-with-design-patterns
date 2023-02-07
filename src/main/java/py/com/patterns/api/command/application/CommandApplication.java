package py.com.patterns.api.command.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;

import py.com.patterns.api.command.AmadeusGetFlightDealsCommand;
import py.com.patterns.api.command.TravelPortGetFlightDealsCommand;
import py.com.patterns.api.command.invoker.GetFlightDealsInvoker;
import py.com.patterns.api.command.receiver.AmadeusApiClientReceiver;
import py.com.patterns.api.command.receiver.TravelPortApiClientReceiver;

class CommandApplication {
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
	
	public static void main(String[] args) {
		log.info("\n ==================="
				+"\n CommandApplication"
				+"\n ===================");
		/*
		 * This application can be enlarged with the Booking and UnBooking command
		 * emulating a do and unDo operations
		 * */
		Map<String,Object> operationDataCommandInput = getFlightDealsSearchCriteria();
		AmadeusGetFlightDealsCommand amadeusGetFlightDealsCommand = new AmadeusGetFlightDealsCommand(new AmadeusApiClientReceiver());		
		GetFlightDealsInvoker getFlightDealsInvoker = new GetFlightDealsInvoker(amadeusGetFlightDealsCommand);
		Map<String,Object> amadeusFlightDeals = getFlightDealsInvoker.executeCommand(operationDataCommandInput);

		TravelPortGetFlightDealsCommand travelPortGetFlightDealsCommand = new TravelPortGetFlightDealsCommand(new TravelPortApiClientReceiver());		
		getFlightDealsInvoker.setApiGetFlightDealsCommand(travelPortGetFlightDealsCommand);
		Map<String,Object> travelPortFlightDeals = getFlightDealsInvoker.executeCommand(operationDataCommandInput);
		
		log.info("\n ==================="
				+"\n CommandApplication search results"
				+"\n " + amadeusFlightDeals
				+"\n " + travelPortFlightDeals
				+"\n ===================");		
	}
	
	static Map<String,Object> getFlightDealsSearchCriteria(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("departureFromDateTime", "202302201800");
		map.put("departureUntilDateTime", "202302202200");
		map.put("departureAirport", UUID.randomUUID().toString());
		map.put("destinationAirport", UUID.randomUUID().toString());
		return map;
	}
}
