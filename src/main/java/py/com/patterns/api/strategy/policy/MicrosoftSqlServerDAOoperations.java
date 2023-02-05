package py.com.patterns.api.strategy.policy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

class MicrosoftSqlServerDAOoperations implements DAOoperations {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	MicrosoftSqlServerDAOoperations() {
		super();
		log.info("\n ================================================="
				+"\n MicrosoftSqlServerDAOoperations class constructor"
				+"\n =================================================");
	}

	@Override
	public Map<String, Object> insert(Map<String, Object> columnValueparameters) {
		log.info("\n ================================================="
				+"\n MicrosoftSqlServerDAOoperations class insert method"
				+"\n =================================================");
		return null;
	}

	@Override
	public Map<String, Object> update(Map<String, Object> recordIdentifierValueparameters,
			Map<String, Object> columnValueparameters) {
		log.info("\n ================================================="
				+"\n MicrosoftSqlServerDAOoperations class update method"
				+"\n =================================================");
		return null;
	}

	@Override
	public Map<String, Object> delete(Map<String, Object> recordIdentifierValueparameters) {
		log.info("\n ================================================="
				+"\n MicrosoftSqlServerDAOoperations class delete method"
				+"\n =================================================");
		return null;
	}

	@Override
	public Map<String, Object> select(Map<String, Object> recordIdentifierValueparameters) {
		log.info("\n ================================================="
				+"\n MicrosoftSqlServerDAOoperations class select method"
				+"\n =================================================");
		return null;
	}

}
