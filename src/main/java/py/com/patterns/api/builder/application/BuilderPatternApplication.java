package py.com.patterns.api.builder.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.builder.bean.AuditBehaviour;
import py.com.patterns.api.builder.bean.AuditRecord;
import py.com.patterns.api.builder.bean.Loan;

public class BuilderPatternApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n BuilderPatternApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		
		AuditBehaviour loan = new Loan();
		AuditRecord auditRecord;	
		for (int i = 0; i < 5; i++) {
			loan.audit();
			auditRecord = loan.proceedToNextStage();
			log.info("\n >>>>>>>>>>>>>>>>>>>"
					+"\n loan audit record: " 
					+"\n " + auditRecord.getData()
					+"\n >>>>>>>>>>>>>>>>>>>");
		}
		
	}

}
