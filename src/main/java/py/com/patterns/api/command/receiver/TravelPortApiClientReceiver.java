package py.com.patterns.api.command.receiver;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;

public class TravelPortApiClientReceiver implements ApiClientReceiver {

	private static final Logger log = getLogger(lookup().lookupClass());

	public TravelPortApiClientReceiver() {
		super();
		log.info("\n ---------------------------------------------"
				+"\n TravelPortApiClientReceiver class constructor"
				+"\n ---------------------------------------------");
	}	
	
	@Override
	public Map<String, Object> call(ApiOperation apiOperation, Map<String, Object> operationData) {
		log.info("\n ---------------------------------------------"
				+"\n TravelPortApiClientReceiver class call method;"
				+"\n apiOperation: " + apiOperation
				+"\n operationData:" + operationData
				+"\n ---------------------------------------------");
		return getFlightDealsSearchResults();
	}

	private Map<String,Object> getFlightDealsSearchResults(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(UUID.randomUUID().toString(), "travelport-flight-deal-object");
		map.put(UUID.randomUUID().toString(), "travelport-flight-deal-object");
		map.put(UUID.randomUUID().toString(), "travelport-flight-deal-object");
		map.put(UUID.randomUUID().toString(), "travelport-flight-deal-object");
		map.put(UUID.randomUUID().toString(), "travelport-flight-deal-object");	
		return map;
	}
}
