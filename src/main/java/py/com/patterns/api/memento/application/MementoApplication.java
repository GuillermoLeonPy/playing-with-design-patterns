package py.com.patterns.api.memento.application;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

import py.com.patterns.api.memento.caretaker.FileHistory;
import py.com.patterns.api.memento.originator.File;

public class MementoApplication {

	private static final Logger log = getLogger(lookup().lookupClass());	
	
	public static void main(String[] args) {
		
		log.info("\n >>>>>>>>>>>>>>>>>>>"
				+"\n MementoApplication"
				+"\n >>>>>>>>>>>>>>>>>>>");
		
		File file = new File("initial file content");
		file.addProperty("file_name", "notes.txt");
		file.addProperty("creation_date", "2018-01-01");
		file.addProperty("creator", "jcaceres");
		file.addProperty("owner", "jcaceres");
		FileHistory careTaker = new FileHistory(file);
		file.setContent("update #1");		
		file.addProperty("last_update_date", "2018-01-03");
		saveFile(careTaker, file);
		file.setContent("update #2");
		file.addProperty("last_update_date", "2018-01-10");
		file.addProperty("owner", "lmartinez");
		saveFile(careTaker, file);
		file.setContent("update #3");
		file.addProperty("owner", "alopez");
		file.addProperty("last_update_date", "2018-01-21");
		saveFile(careTaker, file);
		file.setContent("update #4");
		file.addProperty("owner", "sgonzalez");
		file.addProperty("last_update_date", "2018-02-04");
		saveFile(careTaker, file);
		printAllSavedStatesObjects(careTaker);
	}
	
	private static void saveFile(FileHistory careTaker, File file) {
		careTaker.saveFile(file);		
	}
	
	private static void printAllSavedStatesObjects(FileHistory careTaker) {
		careTaker.getFileHistory().forEach((status,file) -> {System.out.println("\n status key: " + status + "\n recorded object: " + file.toString());});
	}
}
