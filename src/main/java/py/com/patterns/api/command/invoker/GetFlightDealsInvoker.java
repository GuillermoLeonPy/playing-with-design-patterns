package py.com.patterns.api.command.invoker;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.command.ApiGetFlightDealsCommand;

public class GetFlightDealsInvoker {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	private ApiGetFlightDealsCommand apiGetFlightDealsCommand;
	
	public GetFlightDealsInvoker(ApiGetFlightDealsCommand apiGetFlightDealsCommand) {
		super();
		this.apiGetFlightDealsCommand = apiGetFlightDealsCommand;
		log.info("\n :::::::::::::::::::::::::::::::::::::::"
				+"\n GetFlightDealsInvoker class constructor -> " + apiGetFlightDealsCommand.getClass()
				+"\n :::::::::::::::::::::::::::::::::::::::");
	}	
	
	public void setApiGetFlightDealsCommand(ApiGetFlightDealsCommand apiGetFlightDealsCommand) {
		this.apiGetFlightDealsCommand = apiGetFlightDealsCommand;
	}

	public Map<String,Object>  executeCommand(Map<String, Object> operationDataCommandInput) {
		log.info("\n :::::::::::::::::::::::::::::::::::::::"
				+"\n GetFlightDealsInvoker class executeCommand method"
				+"\n operationDataCommandInput: " + operationDataCommandInput
				+"\n :::::::::::::::::::::::::::::::::::::::");
		return apiGetFlightDealsCommand.getFlightDeals(operationDataCommandInput);
	}
}
