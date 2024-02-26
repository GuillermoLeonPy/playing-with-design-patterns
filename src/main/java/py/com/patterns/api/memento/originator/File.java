package py.com.patterns.api.memento.originator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.commons.lang3.SerializationUtils;

public class File implements Serializable{

	private static final long serialVersionUID = 1L;

	public enum Status{
		RECEIVED,
		IN_ENTRY_REVIEW,
		ENTRY_REFUSED,
		IN_PROGRESS,
		PAUSED,
		IN_APPROVAL_REVIEW,
		SIGNING,
		READY_FOR_DELIVER,
		DELIVERED
	}
	
	private Status status;
	private Object content;
	private final HashMap<String,String> properties;
	
	public File(Object content) {
		this.status = Status.RECEIVED;
		this.content = content;
		properties = new HashMap<>();
	}	
	
	public File(Status status, Object content, HashMap<String,String> properties) {
		super();
		this.status = status;
		this.content = content;
		this.properties = properties;
	}

	public File copyFile() {		
		return SerializationUtils.clone(this);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}
	
	public void addProperty(String key, String value) {
		properties.put(key, value);
	}

	@Override
	public String toString() {
		return "File [status=" + status + ", content=" + content + ", properties=" + properties + "]";
	}	
}
