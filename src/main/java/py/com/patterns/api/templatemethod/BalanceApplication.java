package py.com.patterns.api.templatemethod;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

class BalanceApplication {
	/*
	https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
	https://www.baeldung.com/java-access-modifiers
	The Java Tutorials have been written for JDK 8
	----------------------------------------------
	Modifier	Class	Package	Subclass	World
	public			Y		Y		Y			Y
	protected		Y		Y		Y			N
	no modifier		Y		Y		N			N
	known as the default access modifier also called package-private
	
	
	private			Y		N		N			N	
	 */
	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		FileSystemReaderIncomeAndExpensesReport fileSystemBalance = new FileSystemReaderIncomeAndExpensesReport();
		fileSystemBalance.loadIncomeRecords();
		fileSystemBalance.loadExpensesRecords();
		fileSystemBalance.performeBalance();
		log.info("\n =============================================================="
				+"\n BalanceApplication"
				+"\n " + fileSystemBalance.balanceRecords
				+"\n ==============================================================");
	}

}
