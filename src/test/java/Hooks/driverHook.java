package Hooks;


import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class driverHook {
	
	
	 @Before
	    public void setUp() throws Exception {
	        if (TestBase.driver == null) {
	        	TestBase.DriverManager();
	        }
	    }

	  @After
	    public void tearDown() {
	        if (TestBase.driver != null) {
	            TestBase.driver.quit();
	        }
	    }
	}