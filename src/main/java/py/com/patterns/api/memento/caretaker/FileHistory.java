package py.com.patterns.api.memento.caretaker;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;

import py.com.patterns.api.memento.originator.File;
import py.com.patterns.api.memento.originator.File.Status;

/**
 * The Caretaker, it will hold the state of the Originator and ask to restore it when needed
 * https://www.baeldung.com/java-memento-design-pattern#caretaker
 * @author test-user
 *
 */
public class FileHistory {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	/**
	 * File history represents the memento component of the pattern
	 */
	private Map<Status,File> fileHistory;
	private final List<Status> fileLifeCycle; 
	
	public FileHistory(File file) {
		/*LinkedHashMap to preserve insertion order*/
		fileHistory = new LinkedHashMap<Status,File>();		
		fileLifeCycle = new ArrayList<Status>();
		setUpFileLifeCycle();
		saveFile(file);
	}
	
	public void saveFile(File file) {
		if(file.getStatus().equals(Status.DELIVERED) || file.getStatus().equals(Status.ENTRY_REFUSED))
			throw new RuntimeException("Files in status: " + file.getStatus() + " can not continue the process");
	
		fileHistory.put(file.getStatus(), file.copyFile());
		//life cycle advance
		file.setStatus(fileLifeCycle.get(fileLifeCycle.indexOf(file.getStatus()) + 1));
		log.info("\n -------------------"
				+"\n File saved"
				+"\n " + file
				+"\n -------------------"
				+"\n File history: " + fileHistory
				+"\n -------------------");
	}
	
	public void pauseFile(File file) {
		if(file.getStatus().equals(Status.PAUSED))
			throw new RuntimeException("File already paused");
		fileHistory.put(file.getStatus(), file);
		file.setStatus(Status.PAUSED);
		fileHistory.put(file.getStatus(), file);
		log.info("\n -------------------"
				+"\n File paused"
				+"\n " + file
				+"\n -------------------"
				+"\n File history: " + fileHistory
				+"\n -------------------");		
	}
	
	public void refuseEntryFile(File file) {
		if(!file.getStatus().equals(Status.IN_ENTRY_REVIEW))
			throw new RuntimeException("Only files in entry review can be refused");		
		fileHistory.put(file.getStatus(), file);
		file.setStatus(Status.ENTRY_REFUSED);
		fileHistory.put(file.getStatus(), file);
		
	}
	
	public void resumeFile(File file) {
		if(!file.getStatus().equals(Status.PAUSED))
			throw new RuntimeException("Only paused files can be resumed, file status: " + file.getStatus());
		
		file.setStatus(getLastProcessStatus());
		fileHistory.put(file.getStatus(), file);	
		log.info("\n -------------------"
				+"\n File resumed"
				+"\n " + file
				+"\n -------------------"
				+"\n File history: " + fileHistory
				+"\n -------------------");		
	}
	
	public File getFileByStatus(Status status) {
		if(status == Status.PAUSED)
			throw new RuntimeException("Can not retrieve a paused file");
		return fileHistory.get(status);
	}
	
	private Status getLastProcessStatus() {
		int historySize = fileHistory.size();
		Iterator<Status> iterator = fileHistory.keySet().iterator();
		Status status = null;
		int counter = 0;
		while(iterator.hasNext()) {
			status = iterator.next();
			if (counter == (historySize - 2)) {
				break;
			}
			counter++;
		}
		return status;
	}
	
	private void setUpFileLifeCycle() {
		fileLifeCycle.add(Status.RECEIVED);
		fileLifeCycle.add(Status.IN_ENTRY_REVIEW);
		fileLifeCycle.add(Status.IN_PROGRESS);
		fileLifeCycle.add(Status.IN_APPROVAL_REVIEW);
		fileLifeCycle.add(Status.SIGNING);
		fileLifeCycle.add(Status.READY_FOR_DELIVER);
		fileLifeCycle.add(Status.DELIVERED);
	}
	
	
}
