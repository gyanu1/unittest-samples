package sample.jsp.page;

import net.sf.jsptest.HtmlTestCase;

/**
 * Abstract class extends {@link HtmlTestCase} and sets web root folder
 * 
 * @author gyanu
 * **/

public abstract class MyJspTestCase extends HtmlTestCase {
	@Override
	protected String getWebRoot() {
		return "./src/main/webapp/html";
	}

}
