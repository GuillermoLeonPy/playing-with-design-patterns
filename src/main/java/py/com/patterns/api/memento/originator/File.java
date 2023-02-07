package py.com.patterns.api.memento.originator;

public class File {

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
	
	public File(Object content) {
		this.status = Status.RECEIVED;
		this.content = content;
	}	
	
	public File(Status status, Object content) {
		super();
		this.status = status;
		this.content = content;
	}

	public File copyFile() {
		return new File(this.getStatus(), this.getContent());
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

	@Override
	public String toString() {
		return "File [status=" + status + ", content=" + content + "]";
	}	
}
