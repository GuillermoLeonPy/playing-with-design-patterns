package py.com.patterns.api.bridgepattern.behaviour.card;

import java.util.Map;

public interface CardOperation {

	public static final String CARD_PROVIDER_DATA_ID = "CARD_PROVIDER_ID";	
	
	public enum CardProvider{
		MASTER_CARD,
		DINERS_CLUB,
		AMERICAN_EXPRESS
	}
	
	CardProvider getCardProvider();
	Map<String,Object> getCardData(Map<String,Object> data);
	Map<String,Object> doTransaction(Map<String,Object> data);
	Map<String,Object> unDoTransaction(Map<String,Object> data);
}
