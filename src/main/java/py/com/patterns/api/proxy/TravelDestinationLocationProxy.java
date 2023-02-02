package py.com.patterns.api.proxy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

/**
 * The proxy class: a simplified version of a complex or heavy object which loads the original object on demand, also called as lazy initialization 
 * 
 * @author test-user
 *
 */
class TravelDestinationLocationProxy implements TravelDestinationLocation {
	
	private static final Logger log = getLogger(lookup().lookupClass());
	
	TravelDestinationLocation heavyDutyClass;
	
	/**
	 * Lightweight constructor, does not represents high memory load because it does not instantiates the heavy duty class
	 */
	public TravelDestinationLocationProxy() {
		
		log.info("\n TravelDestinationLocationProxy constructor"
				+"\n Lightweight constructor, does not represents high memory load because it does not instantiates the heavy duty class...");
	}

	/**
	 * Implements obtain a singleton instance of the heavy duty class through the Bill Pugh approach 
	 */
	@Override
	public Map<String, Object> getDestinationListByCriteria(String criteria) {
		log.info("\n TravelDestinationLocationProxy getDestinationListByCriteria method");
		if(heavyDutyClass == null) {
			log.info("\n\n\n"
					+"\n TravelDestinationLocationProxy getDestinationListByCriteria method"
					+"\n only once getting an instance of the heavy duty class"
					+"\n\n\n");
			
			
			heavyDutyClass = TravelDestinationLocationImpl.TravelDestinationLocationImpl_SingletonPatternHelper.heavyDutyClass;
			
		}		
		return heavyDutyClass.getDestinationListByCriteria(criteria);
	}

}
