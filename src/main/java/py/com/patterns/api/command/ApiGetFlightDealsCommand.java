package py.com.patterns.api.command;

import java.util.Map;

public interface ApiGetFlightDealsCommand {

	Map<String, Object> getFlightDeals(Map<String, Object> operationDataCommandInput);
	
}
