package py.com.patterns.api.state.status;

import py.com.patterns.api.state.Loan;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;

public class InProgressStatus extends StatusCommonBehaviour {

	public InProgressStatus() {
		super(Status.IN_PROGRESS);
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

}
