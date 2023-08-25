package com.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pageobjects.CustomerLoginPage;

public class LoginTest {
	CustomerLoginPage customer;

	@Before
	public void setUp() throws Exception {
		customer = new CustomerLoginPage();
		customer.get();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	customer.get().giveCredentials("mngr91612", "AmEhErA");
	
	}

}
