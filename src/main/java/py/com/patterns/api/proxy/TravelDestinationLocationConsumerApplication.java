package py.com.patterns.api.proxy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

class TravelDestinationLocationConsumerApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	public static void main(String[] args) throws InterruptedException {
		TravelDestinationLocation travelDestinationLocation = new TravelDestinationLocationProxy();
		travelDestinationLocation.getDestinationListByCriteria("some particular requeriment...");
		log.info("\n\n\n\n");
		Thread.sleep(3000);
		travelDestinationLocation.getDestinationListByCriteria("another particular requeriment...");
		log.info("\n\n\n\n");
		Thread.sleep(3000);
		travelDestinationLocation.getDestinationListByCriteria("and another particular requeriment...");
	}

}
