package py.com.patterns.api.facade;

import java.util.Map;

public interface CommonCreditCardOperation {

	enum CreditCardProvider{
		AMERICAN_EXPRESS,
		DINERS_CLUB,
		DISCOVER,
		JBC,
		MASTER_CARD,
		VISA
	}
	
	public final String CARD_PROVIDER_DATA_KEY = "CARD_PROVIDER";
	public final String CARD_NUMBER_DATA_KEY = "CARD_NUMBER";
	public final String CARD_EXPIRATION_DATE_DATA_KEY = "CARD_EXPIRATION_DATE";
	public final String CARD_OWNER_FULL_NAME_DATE_DATA_KEY = "CARD_OWNER_FULL_NAME";
	
	public static final String CARD_OPERATION_COMMERCE_ID_DATA_KEY = "CARD_OPERATION_COMMERCE_ID";
	public static final String CARD_OPERATION_CURRENCY_ID_DATA_KEY = "CARD_OPERATION_CURRENCY_ID";
	public static final String CARD_OPERATION_AMOUNT_DATA_KEY = "CARD_OPERATION_AMOUNT";
	
	/**
	 * Perform a purchase.
	 * Send purchase details data.
	 * 
	 * @param purchaseData
	 * @return
	 */
	Map<String,Object> purchase(Map<String,Object> purchaseData);
	
	/**
	 * Undo a purchase.
	 * Send undo purchase details data.
	 * 
	 * @param unDoPurchase
	 * @return
	 */
	Map<String,Object> unDoPurchase(Map<String,Object> unDoPurchase);
}
