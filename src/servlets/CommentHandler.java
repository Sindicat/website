package servlets;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import processing.CommentManager;
import processing.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CommentHandler",urlPatterns = "/CommentHandler")
public class CommentHandler extends HttpServlet {
    final static Logger logger = Logger.getLogger(CommentHandler.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject ;
        int indicator;
        CommentManager commentManager = new CommentManager();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if(request.getParameter("num").equals("last")){
            indicator = 1;
            logger.info("User is requesting last comment from DB...");
            commentManager.addComment(request.getUserPrincipal().getName(), request.getParameter("message"));
            jsonObject = commentManager.getCommentsList(request.getUserPrincipal().getName(), indicator);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonObject);
        }
        else if(request.getParameter("num").equals("all")){
            logger.info("User is requesting all comments from DB...");
            indicator = 2;
            jsonObject = commentManager.getCommentsList(request.getUserPrincipal().getName(),indicator);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(jsonObject);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
