package py.com.patterns.api.state.status;

import py.com.patterns.api.state.Loan;
import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;

public interface StatusBehaviour {
	
	public Status getStatus();
	public void advance(Loan loan);
	public void reject(Loan loan);
	public void deny(Loan loan);
}
