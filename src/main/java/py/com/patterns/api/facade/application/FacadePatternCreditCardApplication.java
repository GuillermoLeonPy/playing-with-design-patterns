package py.com.patterns.api.facade.application;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

import py.com.patterns.api.facade.CommonCreditCardOperation;
import py.com.patterns.api.facade.CreditCardOperation;
import py.com.patterns.api.facade.impl.CreditCardOperationImpl;

public class FacadePatternCreditCardApplication {

	public static void main(String[] args) {
		CreditCardOperation creditCardOperation = new CreditCardOperationImpl();
		Map<String, Object> cardData = creditCardOperation.getCardData("1234567890123456", "123");
		Map<String, Object> cardPurchaseData = creditCardOperation.purchase(getFakePurchaseData(cardData));
		Map<String, Object> cardUndoPurchaseData = creditCardOperation.unDoPurchase(cardPurchaseData);		
	}
	
	private static Map<String, Object> getFakePurchaseData(Map<String, Object> cardData){
		cardData.put(CommonCreditCardOperation.CARD_OPERATION_COMMERCE_ID_DATA_KEY, UUID.randomUUID().toString());
		cardData.put(CommonCreditCardOperation.CARD_OPERATION_CURRENCY_ID_DATA_KEY, "USD");
		cardData.put(CommonCreditCardOperation.CARD_OPERATION_AMOUNT_DATA_KEY, BigDecimal.TEN);
		return cardData;
	}

}
