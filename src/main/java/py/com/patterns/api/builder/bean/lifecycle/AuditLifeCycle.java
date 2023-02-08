package py.com.patterns.api.builder.bean.lifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * As a helper class; implements the singleton pattern
 * @author test-user
 *
 */
public class AuditLifeCycle {

	/**
	 * To prevent instantiation
	 */
	private AuditLifeCycle(){}
	
	public enum Status{
		REQUESTED,
		ACCEPTANCE_REVIEW,
		REQUEST_REVIEW,		
		REQUEST_APPROVED,
		IN_PROGRESS,
		FINALIZED,
		REQUEST_DENIED,
		REJECTED
	}
	
	private List<Status> lifeCycleStatusOrder;
	
	{
		lifeCycleStatusOrder = new ArrayList<Status>();
		lifeCycleStatusOrder.add(Status.REQUESTED);
		lifeCycleStatusOrder.add(Status.ACCEPTANCE_REVIEW);
		lifeCycleStatusOrder.add(Status.REQUEST_REVIEW);
		lifeCycleStatusOrder.add(Status.REQUEST_APPROVED);
		lifeCycleStatusOrder.add(Status.IN_PROGRESS);
		lifeCycleStatusOrder.add(Status.FINALIZED);
	}
	
	public List<Status> getLifeCycleStatusOrder(){
		return lifeCycleStatusOrder;
	}
	/**
	 * The Bill Pugh singleton pattern implementation
	 * @author test-user
	 *
	 */
	public static class StatusLifeCycleFactory{
		/**
		 * To prevent instantiation
		 */
		private StatusLifeCycleFactory() {}
		private static AuditLifeCycle statusLifeCycle = new AuditLifeCycle();
	}
	
	public static AuditLifeCycle getStatusLifeCycle() {
		return StatusLifeCycleFactory.statusLifeCycle;
	}
	
	public Status getNextStatus(Status actual) {
		if(actual == Status.REQUEST_DENIED || actual == Status.REJECTED || actual == Status.FINALIZED)
			throw new RuntimeException("Loan in status: " + actual + "; can not be continued");
		Status nextStatus = lifeCycleStatusOrder.get(lifeCycleStatusOrder.indexOf(actual) + 1);
		return nextStatus;		
	}
}
