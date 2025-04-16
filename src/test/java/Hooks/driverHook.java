package Hooks;


import java.io.IOException;

import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class driverHook {
	
	
	 @Before
	    public void setUp() throws Exception {
		 
	        	TestBase.DriverManager();
	        	
	    }

	 
	@After
	    public void tearDown() throws IOException {
	        
	            TestBase.closeDriver();
	        
	    }
	}