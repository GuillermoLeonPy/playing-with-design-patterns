package py.com.patterns.api.builder.bean;

public interface AuditBehaviour {

	public final String AUDIT_RECORD_DATE = "AUDIT_RECORD_DATE";	
	public final String DD_MM_YYYY_HH_mm_ss = "yyyyMMDDHHmmss";
	public AuditRecord proceedToNextStage();
	public void audit();
}
