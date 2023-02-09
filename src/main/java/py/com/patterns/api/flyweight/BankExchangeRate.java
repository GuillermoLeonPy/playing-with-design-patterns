package py.com.patterns.api.flyweight;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class BankExchangeRate extends AbstractExchangeRate{

	public BankExchangeRate(Currency from, Currency to, BigDecimal rate, String institutionName,
			LocalDateTime receptionDateTime) {
		super(from, to, rate, institutionName, receptionDateTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal convert(ClientScope clientScope, BigDecimal ammount) {
		/*some specific business logic for banks*/
		return rate.multiply(clientScope.getConversionFactor()).multiply(ammount) ;
	}

}
