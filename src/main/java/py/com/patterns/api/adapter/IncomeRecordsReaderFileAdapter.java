package py.com.patterns.api.adapter;

import java.io.File;

interface IncomeRecordsReaderFileAdapter {

	enum FileType{
		CSV,
		XLS,
		XLSX,
		XML,
		JSON		
	}	
	
	File getIncomeRecords(String criteria, FileType fileType);
}
