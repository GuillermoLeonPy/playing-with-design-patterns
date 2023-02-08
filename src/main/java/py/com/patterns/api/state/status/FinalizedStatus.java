package py.com.patterns.api.state.status;

import py.com.patterns.api.state.Loan;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;

public class FinalizedStatus extends StatusCommonBehaviour{

	public FinalizedStatus() {
		super(Status.FINALIZED);
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
