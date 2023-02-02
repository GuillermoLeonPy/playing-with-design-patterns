package py.com.patterns.api.observer;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
/**
 * 
 * @author test-user
 *
 */
class LogisticsDriver implements OperationDelegate {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	/**
	 * it represents the observer update method in the observer pattern
	 */
	@Override
	public Map<String, Object> receiveOrder(Map<String, Object> orderDetails) {
		log.info("\n LogisticsDriver receive order"
				+"\n ...some business logic..."
				+"\n ...then return execution result...");
		Map<String, Object> orderExecutionResult = new HashMap<String, Object>();
		orderDetails.keySet().forEach(key -> {
			orderExecutionResult.put(key, "some result...");
		});
		return orderExecutionResult;
	}

}
