package py.com.patterns.api.facade.impl;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;

import py.com.patterns.api.facade.CommonCreditCardOperation;
import py.com.patterns.api.facade.CreditCardOperation;
import py.com.patterns.api.facade.impl.cardprovider.AmericanExpressOperation;
import py.com.patterns.api.facade.impl.cardprovider.DinersClubOperation;
import py.com.patterns.api.facade.impl.cardprovider.DiscoverOperation;
import py.com.patterns.api.facade.impl.cardprovider.JcbOperation;
import py.com.patterns.api.facade.impl.cardprovider.MasterCardOperation;
import py.com.patterns.api.facade.impl.cardprovider.VisaOperation;

public class CreditCardOperationImpl implements CreditCardOperation {

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
			
	@Override
	public Map<String, Object> getCardData(String cardNumber, String cvv) {		
		return getFakeCreditCardData(cardNumber, cvv);
	}

	@Override
	public Map<String, Object> purchase(Map<String, Object> purchaseData) {
		CommonCreditCardOperation commonCreditCardOperation = getCommonCreditCardOperationByProvider(getCardProvider(purchaseData));
		return commonCreditCardOperation.purchase(purchaseData);
	}

	@Override
	public Map<String, Object> unDoPurchase(Map<String, Object> unDoPurchaseData) {
		CommonCreditCardOperation commonCreditCardOperation = getCommonCreditCardOperationByProvider(getCardProvider(unDoPurchaseData));
		return commonCreditCardOperation.purchase(unDoPurchaseData);
	}
	
	private CreditCardProvider getCardProvider(Map<String, Object> cardOperationData) {
		if(cardOperationData == null || !cardOperationData.containsKey(CARD_PROVIDER_DATA_KEY)){
			return CreditCardProvider.MASTER_CARD;
		}else {
			return (CreditCardProvider)cardOperationData.get(CARD_PROVIDER_DATA_KEY);
		}
	}
	
	private CommonCreditCardOperation getCommonCreditCardOperationByProvider(CreditCardProvider creditCardProvider) {
		switch (creditCardProvider) {
			case AMERICAN_EXPRESS:
				return new AmericanExpressOperation();
			case DINERS_CLUB:
				return new DinersClubOperation();
			case JBC:
				return new JcbOperation();
			case VISA:
				return new VisaOperation();
			case DISCOVER:
				return new DiscoverOperation();
			default:
				return new MasterCardOperation();
		}
	}
	
	private Map<String, Object> getFakeCreditCardData(String cardNumber, String cvv){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(CARD_NUMBER_DATA_KEY, cardNumber);
		map.put(CARD_OWNER_FULL_NAME_DATE_DATA_KEY, "JOHN CONNOR");
		map.put(CARD_EXPIRATION_DATE_DATA_KEY, "20230501");
		map.put(CARD_PROVIDER_DATA_KEY, CreditCardProvider.MASTER_CARD);
		return map;
	}

}
