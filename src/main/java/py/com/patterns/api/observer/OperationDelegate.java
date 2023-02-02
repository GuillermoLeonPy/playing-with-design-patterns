package py.com.patterns.api.observer;

import java.util.Map;

/**
 * 
 * @author test-user
 *
 */
interface OperationDelegate {
	Map<String,Object> receiveOrder(Map<String,Object> orderDetails);
}
