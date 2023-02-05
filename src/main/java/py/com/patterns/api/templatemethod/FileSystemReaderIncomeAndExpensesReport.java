package py.com.patterns.api.templatemethod;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

class FileSystemReaderIncomeAndExpensesReport extends LoadDataIntoIncomeAndExpensesReport {

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
	
	public FileSystemReaderIncomeAndExpensesReport() {
		super();
		log.info("\n *************************************************************"
				+"\n FileSystemReaderIncomeAndExpensesReport class constructor"
				+"\n *************************************************************");
	}	
	

	@Override
	void loadIncomeRecords() {
		incomeRecords = new HashMap<String,BigDecimal>();
		readRecordsFromFileSystem(this.incomeRecords, "income_records.txt");
		log.info("\n *************************************************************"
				+"\n FileSystemReaderIncomeAndExpensesReport class loadIncomeRecords method"
				+"\n " + this.incomeRecords
				+"\n *************************************************************");
	}

	@Override
	void loadExpensesRecords() {
		expensesRecords = new HashMap<String,BigDecimal>();
		readRecordsFromFileSystem(this.expensesRecords, "expenses_records.txt");
		log.info("\n *************************************************************"
				+"\n FileSystemReaderIncomeAndExpensesReport class loadExpensesRecords method"
				+"\n " + this.expensesRecords
				+"\n *************************************************************");
	}
	
    void readRecordsFromFileSystem(Map<String,BigDecimal> records, String fileName){
    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
    	/**  
    	 * records = new HashMap<String,BigDecimal>();
    	 * 
    	 * 
    	 * This is an example of transgress of the concept of pass by value of a copy of the reference of and object.
    	 * The assignment of records will not be reflected outside this method, so if records is null at the entry of the method. 
    	 * it will still be null on the next line after this method call.
    	 * 
    	 * 
    	 * Solution: 
    	 * 1) initialize the object before the method call.
    	 * 2) remove the equal sign initialization in this method.
    	 * 3) in this method operate the object updating its internal state by its api methods
    	 * 
    	 * https://forums.oracle.com/ords/apexds/post/pass-by-reference-or-pass-by-value-9836
    	 * 
    	 * */
    	
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        	String[] lineCommaSeparated;
        	for(String line = br.readLine(); line != null ; line = br.readLine()) {
				log.info("\n File " + fileName + " line readed: " + line);
				lineCommaSeparated = line.split(",");
				records.put(lineCommaSeparated[0], BigDecimal.valueOf(Double.valueOf(lineCommaSeparated[1])));
        	}    	
        }catch (IOException e) {
			log.error("\n Error reading from file system",e);
		}	
    }

}
