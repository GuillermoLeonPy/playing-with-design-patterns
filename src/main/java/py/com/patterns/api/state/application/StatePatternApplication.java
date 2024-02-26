package py.com.patterns.api.state.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;

import org.slf4j.Logger;

import py.com.patterns.api.state.Loan;

public class StatePatternApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n StatePatternApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		//the context is loan
		Loan loan = new Loan();
		loan.updateData("CI", "123456789");
		loan.updateData("FULL_NAME", "JOHN CONNOR");
		loan.updateData("PRODUCT", "FIRST HOME AFD");
		loan.updateData("TERM", "YEARS_20");
		loan.updateData("AMMOUNT", BigDecimal.TEN);

		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n loan created: " + loan.toString()
				+"\n >>>>>>>>>>>>>>>>>>>");
		for (int i = 0; i < 5; i++) {
			loan.advance();
			log.info("\n >>>>>>>>>>>>>>>>>>>"
					+"\n loan advanced: " + loan.toString()
					+"\n >>>>>>>>>>>>>>>>>>>");
		}
	}

}
