package py.com.patterns.api.strategy.policy;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Map;

import org.slf4j.Logger;

class StrategyPolicySetter implements DAOoperations {

	/*
	https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
	https://www.baeldung.com/java-access-modifiers
	The Java Tutorials have been written for JDK 8
	----------------------------------------------
	Modifier	Class	Package	Subclass	World
	public			Y		Y		Y			Y
	protected		Y		Y		Y			N
	no modifier		Y		Y		N			N
	known as the default access modifier also called package-private
	
	
	private			Y		N		N			N	
	 */
	
	private static final Logger log = getLogger(lookup().lookupClass());
	
	DAOoperations daoOperations;
	
	StrategyPolicySetter() {
		super();		
		log.info("\n ***************************************"
				+"\n StrategyPolicySetter class constructor"
				+"\n ***************************************");
	}

	void setDaoOperations(DAOoperations daoOperations) {
		this.daoOperations = daoOperations;
	}

	@Override
	public Map<String, Object> insert(Map<String, Object> columnValueparameters) {
		log.info("\n ***************************************"
				+"\n StrategyPolicySetter class insert method"
				+"\n ***************************************");
		return daoOperations.insert(columnValueparameters);
	}

	@Override
	public Map<String, Object> update(Map<String, Object> recordIdentifierValueparameters,
			Map<String, Object> columnValueparameters) {
		log.info("\n ***************************************"
				+"\n StrategyPolicySetter class update method"
				+"\n ***************************************");
		return daoOperations.update(recordIdentifierValueparameters, columnValueparameters);
	}

	@Override
	public Map<String, Object> delete(Map<String, Object> recordIdentifierValueparameters) {
		log.info("\n ***************************************"
				+"\n StrategyPolicySetter class delete method"
				+"\n ***************************************");
		return daoOperations.delete(recordIdentifierValueparameters);
	}

	@Override
	public Map<String, Object> select(Map<String, Object> recordIdentifierValueparameters) {
		log.info("\n ***************************************"
				+"\n StrategyPolicySetter class select method"
				+"\n ***************************************");
		return daoOperations.select(recordIdentifierValueparameters);
	}
	

	
	
}
