package controller;

import implementation.service.LoginServiceImpl;
import interfaceService.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") != null) {
            resp.sendRedirect("/inner/document");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (loginService.checkAuth(login, password) != null) {
            int role = loginService.getRole(login);

           /* HttpSession httpSession = req.getSession();
            httpSession.setAttribute("id",id);*/
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            resp.sendRedirect("/inner/document");
        } else {
            resp.sendRedirect("/login?errorCode=wrongLogin");
        }
    }
}
