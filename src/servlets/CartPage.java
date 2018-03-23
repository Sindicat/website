package servlets;

import org.apache.log4j.Logger;
import processing.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class CartPage extends HttpServlet {
    final static Logger logger = Logger.getLogger(CartPage.class);
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
        DataBase dataBase = new DataBase();
        ArrayList<Product> arrayList = new ArrayList<>();
        ResourceBundle bundle=null;
        Product product = null;
        bundle = ResourceBundle.getBundle("resources/beats",locale);
        product = new Product("0", bundle.getString("price"),bundle.getString("product_name"), bundle.getString("briefly"), bundle.getString("fully"), bundle.getString("imagespath"), "/product?lang=" + lang + "&" + "goods=beats");
        arrayList.add(product);
        bundle = ResourceBundle.getBundle("resources/jbl",locale);
        product = new Product("1", bundle.getString("price"),bundle.getString("product_name"), bundle.getString("briefly"), bundle.getString("fully"), bundle.getString("imagespath"), "/product?lang=" + lang + "&" + "goods=jbl");
        arrayList.add(product);
        bundle = ResourceBundle.getBundle("resources/parrot",locale);
        product = new Product("2", bundle.getString("price"),bundle.getString("product_name"), bundle.getString("briefly"), bundle.getString("fully"), bundle.getString("imagespath"), "/product?lang=" + lang + "&" + "goods=parrot");
        arrayList.add(product);
        bundle = ResourceBundle.getBundle("resources/sennheiser",locale);
        product = new Product("3", bundle.getString("price"),bundle.getString("product_name"), bundle.getString("briefly"), bundle.getString("fully"), bundle.getString("imagespath"), "/product?lang=" + lang + "&" + "goods=sennheiser");
        arrayList.add(product);
        bundle = ResourceBundle.getBundle("resources/sony",locale);
        product = new Product("4", bundle.getString("price"),bundle.getString("product_name"), bundle.getString("briefly"), bundle.getString("fully"), bundle.getString("imagespath"), "/product?lang=" + lang + "&" + "goods=sony");
        arrayList.add(product);
        dataBase.setProductsList(arrayList);

        Interface inter = new Interface();
        bundle = ResourceBundle.getBundle("resources/interface", locale);
        inter.setCart(bundle.getString("cart"));
        inter.setLogin(bundle.getString("login"));
        inter.setPurchases(bundle.getString("history"));
        inter.setFilter(bundle.getString("filter"));
        inter.setFilterFrom(bundle.getString("filterFrom"));
        inter.setFilterTo(bundle.getString("filterTo"));
        inter.setAddToCart(bundle.getString("addToCart"));
        HttpSession session = req.getSession();
        session.setAttribute("locale", locale);
        session.setAttribute("lang",lang);
        req.setAttribute("locale",locale);
        req.setAttribute("orders",(ListOrders)req.getSession().getAttribute("orders"));
        req.setAttribute("db",dataBase);
        req.setAttribute("interfaceBean", inter );
        logger.info("Forward to cart.jsp page");
        RequestDispatcher dispatcher = req.getRequestDispatcher("webapp/jsplists/cart.jsp");
        dispatcher.forward(req,resp);
    }
    }
