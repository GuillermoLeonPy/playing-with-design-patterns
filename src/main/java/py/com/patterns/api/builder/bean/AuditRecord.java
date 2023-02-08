package py.com.patterns.api.builder.bean;

import java.util.HashMap;
import java.util.Map;

import py.com.patterns.api.builder.bean.lifecycle.AuditLifeCycle.Status;

public class AuditRecord {

	private Map<String, Object> data;
	private Status status;
	
	public AuditRecord() {
		// TODO Auto-generated constructor stub
		data = new HashMap<String, Object>();
		status = Status.REQUESTED;
	}
		
	public void addData(String dataName, Object dataVaule) {
		// TODO Auto-generated method stub
		data.put(dataName, dataVaule);
	}

	public String getData() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("\n ==============");
		sb.append("\n data");
		sb.append("\n --------------");
		data.keySet().forEach(key -> {
			sb.append("\n " + key + ": " + data.get(key));
		});
		sb.append("\n --------------");
		sb.append("\n status: " + status);
		sb.append("\n ==============");
		return sb.toString();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
