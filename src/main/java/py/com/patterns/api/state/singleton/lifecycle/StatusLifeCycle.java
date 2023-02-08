package py.com.patterns.api.state.singleton.lifecycle;

import java.util.ArrayList;
import java.util.List;

import py.com.patterns.api.state.status.AcceptanceReviewStatus;
import py.com.patterns.api.state.status.FinalizedStatus;
import py.com.patterns.api.state.status.InProgressStatus;
import py.com.patterns.api.state.status.RequestApprovedStatus;
import py.com.patterns.api.state.status.RequestReviewStatus;
import py.com.patterns.api.state.status.StatusBehaviour;

/**
 * As a helper class; implements the singleton pattern
 * @author test-user
 *
 */
public class StatusLifeCycle {

	/**
	 * To prevent instantiation
	 */
	private StatusLifeCycle(){}
	
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
		private static StatusLifeCycle statusLifeCycle = new StatusLifeCycle();
	}
	
	public static StatusLifeCycle getStatusLifeCycle() {
		return StatusLifeCycleFactory.statusLifeCycle;
	}
	
	public StatusBehaviour getNextStatus(Status actual) {
		if(actual == Status.REQUEST_DENIED || actual == Status.REJECTED || actual == Status.FINALIZED)
			throw new RuntimeException("Loan in status: " + actual + "; can not be continued");
		Status nextStatus = lifeCycleStatusOrder.get(lifeCycleStatusOrder.indexOf(actual) + 1);
		switch (nextStatus) {
			case REQUEST_REVIEW:
				return new RequestReviewStatus();
			case REQUEST_APPROVED:
				return new RequestApprovedStatus();
			case IN_PROGRESS:
				return new InProgressStatus();
			case FINALIZED:
				return new FinalizedStatus();
			default:
				return new AcceptanceReviewStatus();
		}
	}
}
