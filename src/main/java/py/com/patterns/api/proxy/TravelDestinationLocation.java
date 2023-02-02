package py.com.patterns.api.proxy;

import java.util.Map;

interface TravelDestinationLocation {
	Map<String,Object> getDestinationListByCriteria(String criteria);
}
