package py.com.patterns.api.templatemethod.datasource.readers;

import java.math.BigDecimal;

import py.com.patterns.api.templatemethod.LoadDataIntoIncomeAndExpensesReport;

public class OracleDataBaseReaderIncomeAndExpensesReport extends LoadDataIntoIncomeAndExpensesReport {

	@Override
	public void loadIncomeRecords() {
		// TODO Auto-generated method stub
		//load rows from database
		//for each row
		//put in the map
		this.incomeRecords.put("00120013001400", BigDecimal.TEN);
		
	}

	@Override
	public void loadExpensesRecords() {
		// TODO Auto-generated method stub
		//load rows from database
		//for each row
		//put in the map
		this.expensesRecords.put("02120063055400", BigDecimal.TEN);		
	}

}
