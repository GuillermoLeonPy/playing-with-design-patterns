package py.com.patterns.api.strategy.policy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

class InvoiceApplication {

	private static final Logger log = getLogger(lookup().lookupClass());
	
	enum DAOoperation{
		INSERT,
		UPDATE,
		DELETE,
		SELECT,
		RECORD_IDENTIFY
	}
	
	public static void main(String[] args) {
		log.info("\n ----------------------------------------"
				+"\n InvoiceApplication class constructor"
				+"\n ----------------------------------------");
		
		StrategyPolicySetter strategyPolicySetter = new StrategyPolicySetter();
		/* insert into the oracle data base*/
		strategyPolicySetter.setDaoOperations(new OracleDAOoperations());
		strategyPolicySetter.insert(getDAOoperationObject(DAOoperation.INSERT, new Object()));
		/* update the the postgre data base*/
		strategyPolicySetter.setDaoOperations(new PostgreDAOoperations());
		strategyPolicySetter.update(getDAOoperationObject(DAOoperation.INSERT, new Object()), getDAOoperationObject(DAOoperation.RECORD_IDENTIFY, new Object()));
		/* delete from sql server database*/
		strategyPolicySetter.setDaoOperations(new MicrosoftSqlServerDAOoperations());
		strategyPolicySetter.delete(getDAOoperationObject(DAOoperation.RECORD_IDENTIFY, new Object()));
	}
	
	/**
	 * Formats an invoice object to be send to an DAO operation
	 * @param invoice
	 * @return
	 */
	static Map<String,Object> getDAOoperationObject(DAOoperation operation, Object invoice){
		
		return null;
	}

}
