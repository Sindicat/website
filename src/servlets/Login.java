package servlets;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "login")
public class Login extends HttpServlet {
    final static Logger logger = Logger.getLogger(Login.class);
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("User is trying to log in");
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
        req.getSession().setAttribute("locale", locale);
        req.getSession().setAttribute("lang",lang);
        req.setAttribute("lang",lang);
        req.getSession().setAttribute("lang",lang);
        RequestDispatcher dispatcher = req.getRequestDispatcher("webapp/jsplists/login.jsp");
        dispatcher.forward(req,resp);
    }
}
