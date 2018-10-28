package controller;

import implementation.service.DocumentServiceImpl;
import interfaceService.DocumentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DocumentServlet extends HttpServlet {

    private DocumentService documentService;

    @Override
    public void init() throws ServletException {
        super.init();
        documentService = new DocumentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/documentCreation.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Integer docType = Integer.parseInt(req.getParameter("docType"));
        String data = req.getParameter("data");
        String userLogin = req.getParameter("userLogin");
        if (documentService.addDocument(docType, data, userLogin) != null) {
            resp.sendRedirect("/inner/document?savePass=SavePass");
        } else {
            resp.sendRedirect("/inner/document?saveInn=SaveInn");
        }
    }
}
