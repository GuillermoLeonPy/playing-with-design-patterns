package py.com.patterns.api.state.status;

import py.com.patterns.api.state.Loan;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;

public class RequestApprovedStatus extends StatusCommonBehaviour {

	public RequestApprovedStatus() {
		super(Status.REQUEST_APPROVED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reject(Loan loan) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deny(Loan loan) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void advance(Loan loan) {
		// TODO Auto-generated method stub
		super.advance(loan);//performs commmon validation tasks concerning any state, set the next state
		/*business logic concerning the transition from this state to the next*/
		/*persistence layer operations*/
	}

}
