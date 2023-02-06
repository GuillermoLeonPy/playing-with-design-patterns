package py.com.patterns.api.adapter;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.adapter.IncomeRecordsReaderFileAdapter.FileType;

class IncomeRecordsReaderApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) {
		IncomeRecordsReaderFileAdapter incomeRecordsReader = new IncomeRecordsReaderFileAdapterImpl(new IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation());
		incomeRecordsReader.getIncomeRecords("criteria", FileType.XLS);
		log.info("\n ==================================================================================="
				+"\n IncomeRecordsReaderApplication readed income records in .XLS file"
				+"\n ===================================================================================");
		incomeRecordsReader.getIncomeRecords("criteria", FileType.XLSX);
		log.info("\n ==================================================================================="
				+"\n IncomeRecordsReaderApplication readed income records in .XLSX file"
				+"\n ===================================================================================");
		incomeRecordsReader.getIncomeRecords("criteria", FileType.XML);
		log.info("\n ==================================================================================="
				+"\n IncomeRecordsReaderApplication readed income records in .XML file"
				+"\n ===================================================================================");
		incomeRecordsReader.getIncomeRecords("criteria", FileType.JSON);
		log.info("\n ==================================================================================="
				+"\n IncomeRecordsReaderApplication readed income records in .JSON file"
				+"\n ===================================================================================");
		incomeRecordsReader.getIncomeRecords("criteria", FileType.CSV);
		log.info("\n ==================================================================================="
				+"\n IncomeRecordsReaderApplication readed income records in .CSV file"
				+"\n ===================================================================================");
	}

}
