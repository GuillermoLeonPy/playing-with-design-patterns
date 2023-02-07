package py.com.patterns.api.command;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.command.receiver.ApiClientReceiver;
import py.com.patterns.api.command.receiver.ApiClientReceiver.ApiOperation;

public class TravelPortGetFlightDealsCommand extends CommonApiGetFlightDealsCommand implements ApiGetFlightDealsCommand {

	private static final Logger log = getLogger(lookup().lookupClass());
	
			
	public TravelPortGetFlightDealsCommand(ApiClientReceiver apiClientReceiver) {
		super(apiClientReceiver);
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n TravelPortGetFlightDealsCommand class constructor"
				+"\n apiClientReceiver: " + apiClientReceiver.getClass()
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public Map<String, Object> getFlightDeals(Map<String, Object> operationDataCommandInput) {
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n TravelPortGetFlightDealsCommand class getFlightDeals method; operationDataCommandInput: " + operationDataCommandInput
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return apiClientReceiver.call(ApiOperation.GET_FLIGHT_DEALS, operationDataCommandInput);
	}
}
