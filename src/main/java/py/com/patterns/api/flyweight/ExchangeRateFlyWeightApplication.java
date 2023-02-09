package py.com.patterns.api.flyweight;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;

import py.com.patterns.api.flyweight.ExchangeRate.Currency;

public class ExchangeRateFlyWeightApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) throws InterruptedException {
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n ExchangeRateFlyWeightApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		
		LocalDateTime vLocalDateTime = LocalDateTime.now();
		ExchangeRate vExchangeRate_1 = ExchangeRateFactory.getExchangeRateFactory().createExchangeRate(
				Currency.EUR, 
				Currency.PYG, 
				BigDecimal.ONE, 
				"BCP", 
				vLocalDateTime, 
				true);

		ExchangeRate vExchangeRate_2 = ExchangeRateFactory.getExchangeRateFactory().createExchangeRate(
				Currency.EUR, 
				Currency.PYG, 
				BigDecimal.ONE, 
				"BCP", 
				vLocalDateTime, 
				true);
		
		Thread.sleep(500);
		
		ExchangeRate vExchangeRate_3 = ExchangeRateFactory.getExchangeRateFactory().createExchangeRate(
				Currency.EUR, 
				Currency.PYG, 
				BigDecimal.ONE, 
				"BCP", 
				LocalDateTime.now(), 
				true);
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n vExchangeRate_1 id: " + vExchangeRate_1.getId()
				+"\n vExchangeRate_2 id: " + vExchangeRate_2.getId()
				+"\n vExchangeRate_3 id: " + vExchangeRate_3.getId()
				+"\n cache size: " + ExchangeRateFactory.getExchangeRateFactory().getCacheSize()
				+"\n >>>>>>>>>>>>>>>>>>>");
	}

}
