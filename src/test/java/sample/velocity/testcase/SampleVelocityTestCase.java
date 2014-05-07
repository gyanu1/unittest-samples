package sample.velocity.testcase;


public class SampleVelocityTestCase extends VelocityTestCase {
    @Override
    protected String getWebRoot() {
	return "./websrc/velocity";
    }

    // @Test
    public void previousUsernameIsRetained() throws Exception {
	String previousUsername = "Bob";
	setAttribute("username", previousUsername);
	render("/login.vtl");
	assertFormFieldValue("j_username", previousUsername);
    }

}
