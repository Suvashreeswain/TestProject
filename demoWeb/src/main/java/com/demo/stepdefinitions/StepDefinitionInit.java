 package com.demo.stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.demo.automation.framework.TestSession;
import com.demo.pages.demoPage;

public class StepDefinitionInit {

	Map<String, Object> options = new HashMap<String, Object>();
	protected static TestSession session;
	static demoPage demopage;
	

	public TestSession getTestSession() throws Exception {

		if (session == null) {
			session = new TestSession(options);
			// session.driver.navigate().refresh();
		} else {

		}
		
		 demopage = new demoPage(session);

		

		for (Entry<String, Object> entry : session.config.entrySet()) {
			System.out.println("*********" + entry.getKey() + " " + entry.getValue());
		}

		return session;
	}

}
