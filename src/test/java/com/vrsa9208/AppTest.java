package com.vrsa9208;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vrsa9208.controller.HomeController;

public class AppTest {

	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals("This is the home request", result);
	}
}
