package py.com.patterns.api.flyweight;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import py.com.patterns.api.flyweight.ExchangeRate.Currency;

class ExchangeRateFactory {

	private final Map<String,ExchangeRate> exchangeRateCache;
	private final String DD_MM_YYYY_HH_mm_ss = "yyyyMMDDHHmmss";
	
	{
		exchangeRateCache = new HashMap<String,ExchangeRate>();
	}
	
	private ExchangeRateFactory() {}
	

	private static class ExchangeRateFactorySingletonHelper{
		private ExchangeRateFactorySingletonHelper(){}		
		private static ExchangeRateFactory exchangeRateFactory= new ExchangeRateFactory();
	}

	public static ExchangeRateFactory getExchangeRateFactory() {
		return ExchangeRateFactorySingletonHelper.exchangeRateFactory;
	}
	
	public ExchangeRate createExchangeRate(Currency from, Currency to, BigDecimal rate, String institutionName, LocalDateTime issueDateTime, boolean isBank) {		
		String id = generateIdByInstitutionNameAndReceptionDate(institutionName, issueDateTime);
		return exchangeRateCache.computeIfAbsent(id, newId -> { 
			return (isBank ? 
						new BankExchangeRate(from, to, rate, institutionName, issueDateTime): 
						new ExchangeHouseExchangeRate(from, to, rate, institutionName, issueDateTime)
					);
			
	    });	    
	}
	
	private String generateIdByInstitutionNameAndReceptionDate(String institutionName, LocalDateTime receptionDate) {
		return institutionName + "-" + DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_mm_ss).format(receptionDate);
	}
	
	public int getCacheSize() {
		return exchangeRateCache.size();
	}
	
}
