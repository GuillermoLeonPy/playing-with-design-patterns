package py.com.patterns.api.observer;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author test-user
 *
 */
interface OperationManager {
	String getWorkArea();
	Map<String,Object> placeOrder(Map<String,Object> orderData);
	void registerDelegate(OperationDelegate operationDelegate);
	void unRegisterDelegate(OperationDelegate operationDelegate);
}
