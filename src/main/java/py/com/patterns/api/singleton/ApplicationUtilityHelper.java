package py.com.patterns.api.singleton;
/**
 * Represents a class whose instance must be unique
 * @author test-user
 *
 */
class ApplicationUtilityHelper {

	private static ApplicationUtilityHelper applicationUtilityHelper;
	
	/**
	 * It can not be constructed from the outside
	 * 
	 * It can be constructed from INNER CLASES !
	 */
	private ApplicationUtilityHelper() {
		
	}
	/**
	 * Make the factory method synchronized to prevent more than one instance to be created.
	 * The fact of making the method synchronized comes with a performance cost.
	 * 
	 * Lazy initialization because the instance will not be created until this method gets called.
	 * @return
	 */
	static ApplicationUtilityHelper getInstance() {
		
		if(applicationUtilityHelper == null)
			synchronized (ApplicationUtilityHelper.class) {
				//https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
				if(applicationUtilityHelper == null)
					applicationUtilityHelper = new ApplicationUtilityHelper();					
			}
		return applicationUtilityHelper;
	}
	
	
	/**
	 * Bill Pugh singleton implementation
	 * 
	 * This is the most widely used approach for the singleton class as it doesn’t require synchronization
	 * The private static inner class has the instance of the singleton.
	 * When the singleton class is loaded into memory the inner class is not loaded.
	 * Only when getInstance_no_synchronization_required is invoked then the inner class is loaded and creates the singleton class instance.
	 * 
	 * Doesn’t require synchronization !!!
	 * 
	 * https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
	 */
	
	private static class ToAvoidSynchronizationRequirement{		
		
		/** 
		 * Despite of the private static class declaration, a constructor can be declared 
		 * */
		private ToAvoidSynchronizationRequirement() {}
		
		private static 
			ApplicationUtilityHelper applicationUtilityHelper = 
																new ApplicationUtilityHelper();//private constructor can be invoked from inner classes
		
	}
	
	/**
	 * Only when getInstance_no_synchronization_required is invoked then the inner class is loaded and creates the singleton class instance.
	 * 
	 * Doesn’t require synchronization !!!
	 */
	static ApplicationUtilityHelper getInstance_no_synchronization_required() {
		/**
		 * Despite the ToAvoidSynchronizationRequirement constructor private declaration it can be constructed from the outside 
		 * ToAvoidSynchronizationRequirement v = new ToAvoidSynchronizationRequirement(); 
		 */		
		return ToAvoidSynchronizationRequirement.applicationUtilityHelper;
	}
}
