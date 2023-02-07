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
		FileHistory careTaker = new FileHistory(file);
		file.setContent("update #1");
		saveFile(careTaker, file);
		file.setContent("update #2");
		saveFile(careTaker, file);
		file.setContent("update #3");
		saveFile(careTaker, file);
		file.setContent("update #4");
		saveFile(careTaker, file);
		
	}
	
	private static void saveFile(FileHistory careTaker, File file) {
		careTaker.saveFile(file);		
	}
}
