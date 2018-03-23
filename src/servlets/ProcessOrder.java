package servlets;

import org.apache.log4j.Logger;
import processing.ListOrders;
import processing.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class ProcessOrder extends HttpServlet {
    final static Logger logger = Logger.getLogger(CommentHandler.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Integer add = Integer.parseInt(req.getParameter("add"));
        HttpSession session = req.getSession();
                ListOrders orders = (ListOrders) session.getAttribute("orders");
                String num = orders.getOrder(Integer.parseInt(id)).getNum();
                Integer n = Integer.parseInt(num);
                if(add==-1)
                {
                    if(n>0) {
                        n -= 1;
                    }
                }
                if(add==1) {
                    n += 1;
                }
                if(add==0) {
                    n=0;
                }
                logger.info("Add product to cart with ID:"+id);
                orders.getOrder(Integer.parseInt(id)).setNum(n.toString());
                session.setAttribute("orders", orders);
            }
        }


