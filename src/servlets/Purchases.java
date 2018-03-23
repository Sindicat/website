package servlets;

import org.apache.log4j.Logger;
import processing.ListOrders;
import processing.OrderManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class Purchases extends HttpServlet {
    final static Logger logger = Logger.getLogger(Purchases.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String lang =  req.getParameter("lang");
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

        OrderManager orderManager = new OrderManager();
        ListOrders listOrders = orderManager.getOrders(req.getUserPrincipal().getName());
        req.setAttribute("historyList", listOrders);
        logger.info("Forward to purchases.jsp page");
        RequestDispatcher dispatcher = req.getRequestDispatcher("webapp/jsplists/purchases.jsp");
        dispatcher.forward(req,resp);
    }
}