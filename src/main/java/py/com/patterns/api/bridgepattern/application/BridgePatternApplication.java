package py.com.patterns.api.bridgepattern.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import py.com.patterns.api.bridgepattern.behaviour.card.impl.MasterCardOperationImpl;
import py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.OutsourcedTransactionProcessor;
import py.com.patterns.api.bridgepattern.behaviour.transactionprocessor.impl.BancardTransactionProcessor;

public class BridgePatternApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Object> data = new HashMap<>();
		
		data.put(OutsourcedTransactionProcessor.TRANSACTION_CARD_NUMBER_DATA_ID, "1234567890123456");
		data.put(OutsourcedTransactionProcessor.TRANSACTION_AMOUNT_DATA_ID, BigDecimal.TEN);
		data.put(OutsourcedTransactionProcessor.TRANSACTION_INSTALLMENTS_NUMBER_DATA_ID, Integer.valueOf(5));
		data.put(OutsourcedTransactionProcessor.TRANSACTION_CURRENCY_DATA_ID, "USD");		
		data.put(OutsourcedTransactionProcessor.TRANSACTION_TYPE_DATA_ID, OutsourcedTransactionProcessor.TRANSACTION_TYPE_PAYMENT);
		
		data.put(OutsourcedTransactionProcessor.TRANSACTION_PROCESSOR_CREDENTIAL_USER_DATA_ID, "BANCARD_USER");
		data.put(OutsourcedTransactionProcessor.TRANSACTION_PROCESSOR_CREDENTIAL_PASSWORD_DATA_ID, "123456");
		OutsourcedTransactionProcessor transactionProcessor = new BancardTransactionProcessor(new MasterCardOperationImpl());
		transactionProcessor.doTransaction(data);
	}

}
