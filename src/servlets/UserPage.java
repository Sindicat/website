package servlets;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class UserPage extends HttpServlet {
    final static Logger logger = Logger.getLogger(CommentHandler.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String lang = req.getParameter("lang");
        if (lang == null) lang = "rus";
        Locale locale = null;
        switch (lang) {
            case "en":
                locale = new Locale("en","US");
                break;
            case "rus":
                locale = new Locale("rus","RU");
                break;
            case "fra":
                locale = new Locale("fra","FR");
                break;
        }
        req.setAttribute("locale", locale);
        req.setAttribute("lang",lang);
        req.getSession().setAttribute("lang",lang);
        req.getSession().setAttribute("locale", locale);
        logger.info("Forward to profile.jsp page");
        RequestDispatcher dispatcher = req.getRequestDispatcher("webapp/jsplists/profile.jsp");
        dispatcher.forward(req,resp);
    }
}
