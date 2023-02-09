package py.com.patterns.api.flyweight;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

abstract class AbstractExchangeRate implements ExchangeRate{

	protected final Currency from;
	protected final Currency to;
	protected final BigDecimal rate;	
	protected final Map<String,Object> data;
	
	public AbstractExchangeRate(Currency from, Currency to, BigDecimal rate, String institutionName, LocalDateTime issueDateTime) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.data = new HashMap<String,Object>();
		this.data.put(INSTITUTION_ID_DATA_KEY, institutionName);
		this.data.put(RECEPTION_DATE_TIME_DATA_KEY, DateTimeFormatter.ofPattern(DD_MM_YYYY_HH_mm_ss).format(issueDateTime));
	}

	public Currency getFrom() {
		return from;
	}

	public Currency getTo() {
		return to;
	}

	public BigDecimal getRate() {
		return rate;
	}
	
	public Map<String, Object> getData() {
		return data;
	}	
	
	public void addData(String dataId,Object dataObject) {
		data.put(dataId, dataObject);
	}
	
	public String getId() {
		return data.get(INSTITUTION_ID_DATA_KEY) + "-" + data.get(RECEPTION_DATE_TIME_DATA_KEY);
	}
}
