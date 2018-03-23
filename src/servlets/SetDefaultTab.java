package servlets;

import processing.DefT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetDefaultTab")
public class SetDefaultTab extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tab = (String)request.getParameter("tab");
        request.getSession().setAttribute("tab", tab);
        DefT defT = new DefT();
        defT.setMark(Integer.parseInt(tab));
        request.getSession().setAttribute("defT", defT);
    }
}
