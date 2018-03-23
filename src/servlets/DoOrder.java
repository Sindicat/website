package servlets;

import org.apache.log4j.Logger;
import processing.CustomersHash;
import processing.ListOrders;
import processing.Order;
import processing.OrderManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DoOrder", urlPatterns = "/DoOrder")
public class DoOrder extends HttpServlet {
    final static Logger logger = Logger.getLogger(DoOrder.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String lang =  (String)req.getSession().getAttribute("lang");
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

        HttpSession session=req.getSession();
        ListOrders listOrders= (ListOrders)session.getAttribute("orders");
        req.getSession().setAttribute("locale", locale);
        ListOrders readyList = new ListOrders();
        for (Order order: listOrders.getList()) {
            if(Integer.parseInt(order.getNum())!=0)
            {
                readyList.addOrder(order);
            }
        }
        OrderManager orderManager = new OrderManager();
        session.removeAttribute("orders");
        orderManager.addOrder(req.getUserPrincipal().getName(), req.getUserPrincipal().getName(),req.getParameter("address"), readyList );
        logger.info("User has made order. Forward to listCards.jsp");
        resp.sendRedirect("/products?lang="+lang+"&from=0&to=100000&filter=0");
    }
}