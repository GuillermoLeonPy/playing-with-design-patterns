package py.com.patterns.api.strategy.policy;

import java.util.Map;

interface DAOoperations {
	
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
	
	
	/*
	 * All interface methods are implicity public and abstract (you do not need to specify this)
	 * http://www.datadisk.co.uk/html_docs/java/access_control.htm
	 * 
	 * Every method declaration in the body of an interface is implicitly public
	 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.4
	 */
	
	Map<String,Object> insert(Map<String,Object> columnValueparameters);
	Map<String,Object> update(Map<String,Object> recordIdentifierValueparameters, Map<String,Object> columnValueparameters);
	Map<String,Object> delete(Map<String,Object> recordIdentifierValueparameters);
	Map<String,Object> select(Map<String,Object> recordIdentifierValueparameters);
}
