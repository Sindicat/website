package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "TimeServlet", urlPatterns = "/TimeServlet")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String lang = (String)request.getSession().getAttribute("lang");
        if (lang == null) lang = "rus";
        Locale locale = null;
        switch (lang) {
            case "en":
                locale = new Locale("en","US");
                break;
            case "rus":
                locale = new Locale("ru","RU");
                break;
            case "fra":
                locale = new Locale("fr","FR");
                break;
        }

        Date date = new Date();
    //    Locale locale = (Locale)request.getSession().getAttribute("locale");
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy H:m:s", locale);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(dateFormat.format(date));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
