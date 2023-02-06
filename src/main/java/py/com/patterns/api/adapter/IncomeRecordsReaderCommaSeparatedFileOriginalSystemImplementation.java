package py.com.patterns.api.adapter;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;

import org.slf4j.Logger;

class IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation {
		
	private static final Logger log = getLogger(lookup().lookupClass());
	
	IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation() {
		super();
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation class constructor"
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	File getIncomeRecords(String criteria) {
		log.info("\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+"\n IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation class getIncomeRecords method"
				+"\n >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return null;
	}
}
