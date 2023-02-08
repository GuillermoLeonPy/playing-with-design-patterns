package py.com.patterns.api.state;

import java.util.HashMap;
import java.util.Map;

import py.com.patterns.api.state.singleton.lifecycle.StatusLifeCycle.Status;
import py.com.patterns.api.state.status.RequestedStatus;
import py.com.patterns.api.state.status.StatusBehaviour;

public class Loan {

	private Map<String,Object> data;
	private StatusBehaviour status;
	
	public Loan() {
		super();
		data = new HashMap<String,Object>();	
		status = new RequestedStatus();
	}

	public void updateData(String dataName, Object dataContent) {
		data.put(dataName, dataContent);
	}

	public Map<String, Object> getData() {
		return data;
	}

	public StatusBehaviour getStatus() {
		return status;
	}

	public void setStatus(StatusBehaviour status) {
		this.status = status;
	}	
	
	public void advance() {
		this.status.advance(this);
	}
	
	public void reject() {
		this.status.reject(this);
	}
	
	public void deny() {
		this.status.deny(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n ==============");
		sb.append("\n data");
		sb.append("\n --------------");
		data.keySet().forEach(key -> {
			sb.append("\n " + key + ": " + data.get(key));
		});
		sb.append("\n --------------");
		sb.append("\n status: " + status.getStatus());
		sb.append("\n ==============");
		return sb.toString();
	}
	
	
}
