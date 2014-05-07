package sample.servlet;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * sample test case for servlets
 * 
 * @author gyanu
 * 
 * **/

public class TestLoginServlet {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private LoginServlet login;
	
	@Before
	public void setUp(){
		 request=new MockHttpServletRequest();
		 response=new MockHttpServletResponse();
		 login=new LoginServlet();		
	}
		
	@Test
	public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
	request.addParameter("j_username", "gyanu");
	request.addParameter("j_password", "wrongpassword");
	login.setValid(false);
	login.doPost(request, response);
	assertEquals("/invalidlogin", response.getRedirectedUrl());
	}
	
	@Test
	public void rightPasswordShouldRedirectToFrontPage() throws Exception {
	request.addParameter("j_username", "gyanu");
	request.addParameter("j_password", "wrongpassword");
	login.setValid(true);
	login.doPost(request, response);
	assertEquals("/frontpage", response.getRedirectedUrl());
	}
}
