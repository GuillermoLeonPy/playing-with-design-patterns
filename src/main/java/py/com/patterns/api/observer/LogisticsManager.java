package py.com.patterns.api.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
/**
 * 
 * @author test-user
 *
 */
class LogisticsManager implements OperationManager {

	private static final Logger log = getLogger(lookup().lookupClass());
	private Map<String, Object> allOrdersData;
	private Map<String, Object> allOrdersResults;
	private List<LogisticsDriver> logisticsDriverList; 
	
	{
		/* Instance initializer block
		 * https://www.baeldung.com/java-static-instance-initializer-blocks#instance-initializer-block
		 * 
		 * The purpose of the instance initializer block is to initialize the instance data members.
		 * The instance block runs at the time of instance creation.
		 * The Java compiler copies initializer blocks into every constructor.
		 * Multiple constructors can use this approach to share a block of code.
		 * 
		 * 
		 */		
		allOrdersData = new HashMap<String, Object>();
		allOrdersResults = new HashMap<String, Object>();
		logisticsDriverList = new ArrayList<>();
	}
	
	/**
	 * observable notifies observers about the changes in its state
	 * https://www.baeldung.com/java-observer-pattern#observer-pattern
	 * 
	 * receiving orders is what change the state of a manager and it causes the drivers to get notified
	 */
	@Override
	public Map<String, Object> placeOrder(Map<String, Object> orderData) {
		allOrdersData.putAll(orderData);//when an order is delegated it is stored together with all orders
		log.info("\n LogisticsManager place order"
				+"\n ...some business logic..."
				+"\n ...then notify the delegates...");
		/*some order generations logic...*/
		Map<String, Object> operationDelegationResult = new HashMap<String, Object>();
		logisticsDriverList.stream().forEach(operationDelegate -> {
			//when an order is received by a delegate its result is stored together with all orders results
			//notifies the observers about it by calling their update() method, here represented by the receiveOrder method
			operationDelegationResult.putAll(operationDelegate.receiveOrder(orderData));
			allOrdersResults.putAll(operationDelegationResult);
		});
		return operationDelegationResult;
	}


	@Override
	public String getWorkArea() {
		//some persistence layer query
		return "logistics-pharmaceuical";
	}

	/**
	 * the observable object needs to keep references to the observers
	 * https://www.baeldung.com/java-observer-pattern#observer-pattern
	 */
	@Override
	public void registerDelegate(OperationDelegate operationDelegate) {
		if(operationDelegate instanceof LogisticsDriver)
			logisticsDriverList.add((LogisticsDriver)operationDelegate);
	}


	@Override
	public void unRegisterDelegate(OperationDelegate operationDelegate) {
		if(operationDelegate instanceof LogisticsDriver)
			logisticsDriverList.remove((LogisticsDriver)operationDelegate);
		
	}

}
