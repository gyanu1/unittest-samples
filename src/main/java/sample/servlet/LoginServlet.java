package sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private boolean isValid;

    /**
     * Sample servlet that handles login which needs to be tested
     * 
     * @author gyanu
     */
    private static final long serialVersionUID = 2473252741884321641L;

    @Override
    public void init() throws ServletException {
	super.init();

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	resp.sendRedirect("/invalidlogin");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	String user = req.getParameter("j_username");
	String pass = req.getParameter("j_password");
	if (isValidLogin(user, pass)) {
	    resp.sendRedirect("/frontpage");
	    req.getSession().setAttribute("username", user);
	} else {
	    resp.sendRedirect("/invalidlogin");
	}

    }

    private boolean isValidLogin(String user, String pass) {
	return isValid;
    }

    public void setValid(boolean isValid) {
	this.isValid = isValid;
    }

}
