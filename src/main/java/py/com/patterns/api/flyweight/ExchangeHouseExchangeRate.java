package py.com.patterns.api.flyweight;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExchangeHouseExchangeRate extends AbstractExchangeRate {

	public ExchangeHouseExchangeRate(Currency from, Currency to, BigDecimal rate, String institutionName,
			LocalDateTime issueDateTime) {
		super(from, to, rate, institutionName, issueDateTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal convert(ClientScope clientScope, BigDecimal ammount) {
		/*some specific business logic for exchange house*/
		return rate.multiply(clientScope.getConversionFactor()).multiply(ammount) ;
	}
	
}
