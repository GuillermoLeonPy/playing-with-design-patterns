package py.com.patterns.api.templatemethod;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;

/**
 * 
 * @author test-user
 *
 */
public abstract class LoadDataIntoIncomeAndExpensesReport {
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
	
		public LoadDataIntoIncomeAndExpensesReport() {
		super();
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n LoadDataIntoIncomeAndExpensesReport abstract class constructor"
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	enum BalanceElements{
		INCOME,
		EXPENSES,
		BALANCE
	}
	
	protected Map<String,BigDecimal> incomeRecords;
	protected Map<String,BigDecimal> expensesRecords;
	protected Map<String,BigDecimal> balanceRecords;

	/**
	 * 
	 */
	public abstract void loadIncomeRecords();
	/**
	 * 
	 */
	public abstract void loadExpensesRecords();
	/**
	 * 
	 */
	public void performeBalance() {	
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n LoadDataIntoIncomeAndExpensesReport abstract class performeBalance method"
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		balanceRecords = new HashMap<String,BigDecimal>();
		BigDecimal incomeSummation = getSummationFromRecords(incomeRecords);
		balanceRecords.put(BalanceElements.INCOME.toString(), incomeSummation);
		BigDecimal expensesSummation = getSummationFromRecords(expensesRecords);
		balanceRecords.put(BalanceElements.EXPENSES.toString(), expensesSummation);
		balanceRecords.put(BalanceElements.BALANCE.toString(), incomeSummation.subtract(expensesSummation));
	}
	
	BigDecimal getSummationFromRecords(Map<String,BigDecimal> records) {
		BigDecimal summation = BigDecimal.ZERO;		
		Iterator<String> incomeKeySetIterator = records.keySet().iterator();
		/*
		 * this implementation ignores the first element
		for(String key = incomeKeySetIterator.next(); incomeKeySetIterator.hasNext(); key = incomeKeySetIterator.next()) {
			summation = summation.add(records.get(key));
		}
		*/
		
		while(incomeKeySetIterator.hasNext()) {
			summation = summation.add(records.get(incomeKeySetIterator.next()));
		}
		
		return summation;
	}
	
}
