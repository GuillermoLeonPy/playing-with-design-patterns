package py.com.patterns.api.adapter;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;

import org.slf4j.Logger;

class IncomeRecordsReaderFileAdapterImpl implements IncomeRecordsReaderFileAdapter {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	final IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation originalSystemRecordsReader;
	
	IncomeRecordsReaderFileAdapterImpl(IncomeRecordsReaderCommaSeparatedFileOriginalSystemImplementation originalSystemRecordsReader) {
		super();
		this.originalSystemRecordsReader = originalSystemRecordsReader;
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class constructor"
				+"\n ###################################################################################");
	}

	@Override
	public File getIncomeRecords(String criteria, FileType fileType) {
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class getIncomeRecords method"
				+"\n ###################################################################################");
		File file = this.originalSystemRecordsReader.getIncomeRecords(criteria);
		switch (fileType) {
			case XLS:
				return this.transformCsvToXls(file);
			case XLSX:
				return this.transformCsvToXlsX(file);
			case XML:
				return this.transformCsvToXml(file);
			case JSON:
				return this.transformCsvToJson(file);
			default:			
				return file;
		}
	}
	
	private File transformCsvToXls(File file) {
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class transformCsvToXls method"
				+"\n ###################################################################################");
		return null;
	}

	private File transformCsvToXlsX(File file) {
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class transformCsvToXlsX method"
				+"\n ###################################################################################");
		return null;
	}
	
	private File transformCsvToXml(File file) {
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class transformCsvToXml method"
				+"\n ###################################################################################");
		return null;
	}
	
	private File transformCsvToJson(File file) {
		log.info("\n ###################################################################################"
				+"\n IncomeRecordsReaderFileAdapterImpl class transformCsvToJson method"
				+"\n ###################################################################################");
		return null;
	}
}
