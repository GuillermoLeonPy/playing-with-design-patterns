package py.com.patterns.api.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * @author test-user
 *
 */
class ManagementApplication {
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
	}
	
	boolean performDelegations() {
		List<OperationManager> logisticsManagerList = getLogisticsAvailableManagers();
		logisticsManagerList.stream().forEach(logisticsManager -> {
			getLogisticsAvailableDelegates().stream().forEach(delegate -> {
				logisticsManager.registerDelegate(delegate);
			});
			logisticsManager.placeOrder(getLogisticsOperationsToDo(logisticsManager.getWorkArea()));
		});
		
		return true;
	}
	
	List<OperationManager> getLogisticsAvailableManagers(){
		//some business logic to find available managers
		List<OperationManager> logisticsManagerList = new ArrayList<>();
		logisticsManagerList.add(new LogisticsManager());
		return logisticsManagerList;
	}
	
	List<OperationDelegate> getLogisticsAvailableDelegates(){
		//some business logic to find available delegates
		List<OperationDelegate> logisticsDelegateList = new ArrayList<>();
		logisticsDelegateList.add(new LogisticsDriver());
		return logisticsDelegateList;
	}
	
	Map<String,Object> getLogisticsOperationsToDo(String criteriaOperationToFilter){
		Map<String,Object> operations = new HashMap<String,Object>();
		operations.put(UUID.randomUUID().toString(), "deliver merchandise");
		return operations;
	}
}
