package sample.jsp.page;

/**
 * sample test case for jsp page
 * 
 * @author gyanu
 * 
 * **/
public class TestLoginPage extends MyJspTestCase {
	public void testFormFieldsArePresent() throws Exception {
		get("/login.jsp");
		form().shouldHaveField("j_username");
		form().shouldHaveField("j_password");
		form().shouldHaveSubmitButton("login");
	}
	
	public void testPreviousUsernameIsRetained() throws Exception {
		setRequestAttribute("j_username", "bob");
		get("/login.jsp");
		//for demo change name and show if this test case is working
		form().field("j_username").shouldHaveValue("bob");
		}
}
