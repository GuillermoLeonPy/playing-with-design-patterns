package py.com.patterns.api.proxy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
/**
 * The heavy duty implementation class that is desirable to be loaded on demand and the reused
 * @author test-user
 *
 */
class TravelDestinationLocationImpl implements TravelDestinationLocation {
	
	private static final Logger log = getLogger(lookup().lookupClass());
	
	Map<String, Object> destinationList;
	
	private TravelDestinationLocationImpl() {
		/**
		 * Instance initializer
		 * Resources needed setup; database access, file system access
		 * */
    	
		log.info("\n TravelDestinationLocationImpl constructor"
				+"\n initializing the heavy duty class, setting up resources...");
		destinationList = new HashMap<String, Object>();	
		readDestinationList_by_InputStream_and_classLoader_getResourceAsStream();
	}	
	
	static class TravelDestinationLocationImpl_SingletonPatternHelper{
		private TravelDestinationLocationImpl_SingletonPatternHelper() {
			log.info("\n TravelDestinationLocationImpl_SingletonPatternHelper private constructor"
					+"\n should never be executed");
		}
		static {
			log.info("\n TravelDestinationLocationImpl_SingletonPatternHelper static block"
					+"\n should be executed once on class loading");
		}
		static TravelDestinationLocationImpl heavyDutyClass = new TravelDestinationLocationImpl();		
	}
	
	@Override
	public Map<String, Object> getDestinationListByCriteria(String criteria) {
		//some filtering operations
		log.info("\n TravelDestinationLocationImpl.getDestinationListByCriteria"
				+"\n the heavy duty class making some high memory requirement job ");
		return TravelDestinationLocationImpl_SingletonPatternHelper.heavyDutyClass.destinationList;
	}
	
	void readDestinationList_by_BufferedReader_and_FileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("travel_destination_location_list.txt"));
			String[] lineCommaSeparated;
			for(String line = reader.readLine(); line != null ; line = reader.readLine()) {
				log.info("\n File travel_destination_location_list.txt line readed: " + line);
				lineCommaSeparated = line.split(",");
				destinationList.put(lineCommaSeparated[0], (lineCommaSeparated[1] + "-" + lineCommaSeparated[2]));
			}
			
		} catch (IOException e) {
			log.error("\n Error reading from file system",e);
		}finally {
			/**
			 * compilation error, no access to the reader variable !!!
			 */
			//reader.close();
		}
	}
	
	void readDestinationList_by_Files_and_Path() {		
    	try {    	
			List<String> travel_destination_location_list = Files.readAllLines(Paths.get("travel_destination_location_list.txt"));
			String[] lineCommaSeparated;
			for (String line : travel_destination_location_list) {
				lineCommaSeparated = line.split(",");
				destinationList.put(lineCommaSeparated[0], (lineCommaSeparated[1] + "-" + lineCommaSeparated[2]));
			}
		} catch (IOException e) {
			log.error("\n Error reading from file system",e);
		}	
	}
	
    void readDestinationList_by_InputStream_and_classLoader_getResourceAsStream(){
    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("travel_destination_location_list.txt");    	
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
        	String[] lineCommaSeparated;
        	for(String line = br.readLine(); line != null ; line = br.readLine()) {
				log.info("\n File travel_destination_location_list.txt line readed: " + line);
				lineCommaSeparated = line.split(",");
				destinationList.put(lineCommaSeparated[0], (lineCommaSeparated[1] + "-" + lineCommaSeparated[2]));
        	}    	
        }catch (IOException e) {
			log.error("\n Error reading from file system",e);
		}	
    }

}
