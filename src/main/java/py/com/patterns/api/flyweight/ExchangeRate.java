package py.com.patterns.api.flyweight;

import java.math.BigDecimal;
import java.util.Map;

public interface ExchangeRate {

	enum Currency{
		USD,
		EUR,
		PYG
	}
	
	enum ClientScope{
		RETAIL(BigDecimal.valueOf(0.91)),
		WHOLESALER(BigDecimal.valueOf(0.98));
		
		private final BigDecimal conversionFactor;
		private ClientScope(BigDecimal conversionFactor) {
			this.conversionFactor = conversionFactor;
		}
		
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}		
	}
	
	public final String DD_MM_YYYY_HH_mm_ss = "yyyyMMDDHHmmss";
	public final String INSTITUTION_ID_DATA_KEY = "INSTITUTION_ID";
	public final String RECEPTION_DATE_TIME_DATA_KEY = "RECEPTION_DATE_TIME";
	
	BigDecimal convert(ClientScope clientScope, BigDecimal ammount);
	Currency getFrom();

	Currency getTo();

	BigDecimal getRate();
	
	Map<String, Object> getData();
	
	void addData(String dataId,Object dataObject);
	
	String getId();
}
