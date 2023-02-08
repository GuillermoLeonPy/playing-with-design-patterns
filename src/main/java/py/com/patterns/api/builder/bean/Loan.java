package py.com.patterns.api.builder.bean;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.slf4j.Logger;

import py.com.patterns.api.builder.bean.lifecycle.AuditLifeCycle;
import py.com.patterns.api.builder.bean.lifecycle.AuditLifeCycle.Status;

public class Loan implements AuditBehaviour {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	private final AuditRecord auditRecord;
	
	public Loan() {
		auditRecord = new AuditRecord();
	}

	@Override
	public AuditRecord proceedToNextStage() {
		// TODO Auto-generated method stub
		log.info("\n --------------------"
				+"\n Loan audit proceedToNextStage"
				+"\n --------------------");
		if(auditRecord.getStatus() == Status.REQUEST_DENIED || auditRecord.getStatus() == Status.REJECTED || auditRecord.getStatus() == Status.FINALIZED)
			throw new RuntimeException("auditRecord in status: " + auditRecord.getStatus() + "; can not be continued");
		auditRecord.setStatus(AuditLifeCycle.getStatusLifeCycle().getNextStatus(auditRecord.getStatus()));
		return auditRecord;
	}

	@Override
	public void audit() {
		// TODO Auto-generated method stub
		auditRecord.addData(
				AUDIT_RECORD_DATE.concat(
						"-"
						+ DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_mm_ss).format(LocalDateTime.now())
						) + "-" + UUID.randomUUID().toString().substring(0, 4), 
				"audit json or xml object loan specific");
	}
}
