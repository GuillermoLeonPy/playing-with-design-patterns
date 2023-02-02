package py.com.patterns.api.observer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author test-user
 *
 */
class ManagementApplicationTests {

	@Test
	void executeManagementApplication() {
		ManagementApplication managementApplication = new ManagementApplication();
		assertTrue(managementApplication.performDelegations());
	}
}
