package controller;

import implementation.service.RegistrationServiceImpl;
import interfaceService.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        super.init();
        registrationService = new RegistrationServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        if (registrationService.addNewUser(login, password, name, surname) != null) {
            // int role = registrationService.setRole(2);
            //  req.getSession().setAttribute("role", role);
            resp.sendRedirect("/index.jsp?loginToEnter=LoginToEnter");
        } else {
            req.getRequestDispatcher("/registration.jsp?error=ChangeLogin").forward(req, resp);
        }
    }


}
