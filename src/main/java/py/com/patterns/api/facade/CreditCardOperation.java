package py.com.patterns.api.facade;

import java.util.Map;

public interface CreditCardOperation extends CommonCreditCardOperation{

	/**
	 * Validate card.
	 * Get card details data.
	 * 
	 * @param cardNumber
	 * @param cvv
	 * @return
	 */
	Map<String,Object> getCardData(String cardNumber, String cvv);
}
