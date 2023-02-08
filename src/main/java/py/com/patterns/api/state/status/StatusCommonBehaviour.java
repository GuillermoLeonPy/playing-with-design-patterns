package py.com.patterns.api.state.status;

import py.com.patterns.api.state.Loan;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;

public abstract class StatusCommonBehaviour implements StatusBehaviour{

	private final Status status;	
	
	public StatusCommonBehaviour(Status status) {
		super();
		this.status = status;
	}

	public void advance(Loan loan) {
		if(loan.getStatus().getStatus() == Status.REQUEST_DENIED || loan.getStatus().getStatus() == Status.REJECTED || loan.getStatus().getStatus() == Status.FINALIZED)
			throw new RuntimeException("Loan in status: " + loan.getStatus() + "; can not be continued");
		loan.setStatus(StatusLifeCycle.getStatusLifeCycle().getNextStatus(loan.getStatus().getStatus()));
		/*persistence layer operations*/
	}

	public Status getStatus() {
		return status;
	}	
}
