package servlets;
import org.apache.log4j.Logger;
import processing.ListOrders;
import processing.Product;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;


public class OneProductServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(CommentHandler.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String lang = req.getParameter("lang");
        String goods = req.getParameter("goods");
        logger.info("Give product card:"+goods);
        if (lang == null) lang = "rus";
        Locale locale = null;
        switch (lang) {
            case "en":
                locale = new Locale("en");
                break;
            case "rus":
                locale = new Locale("rus");
                break;
            case "fra":
                locale = new Locale("fra");
                break;
        }

        req.setAttribute("locale", locale);
        req.setAttribute("lang", lang);
        req.getSession().setAttribute("lang",lang);
        req.getSession().setAttribute("locale", locale);
        String id= new String();
        if(goods.equals("beats")) id="0";
        if(goods.equals("jbl")) id="1";
        if(goods.equals("parrot")) id="2";
        if(goods.equals("sennheiser")) id="3";
        if(goods.equals("sony")) id="4";
        ResourceBundle bundle = ResourceBundle.getBundle("resources/"+goods, locale);
        ResourceBundle bundleInter = ResourceBundle.getBundle("resources/interface", locale);
        String foruser="";
        String profile="";
        String checkout="";
        if(req.isUserInRole("tomcat"))
        {
            foruser = "<a class=\"w3-bar-item w3-button\" href=\"/logout?lang="+lang+"\">"+bundleInter.getString("logout")+"</a>";
            profile = " <a class=\"w3-bar-item w3-button\" href=\"/profile?lang="+lang+"\">"+bundleInter.getString("myprofile") + "("+req.getUserPrincipal().getName() + ")</a>";
            if(!(((ListOrders)req.getSession().getAttribute("orders")).isEmpty())) {
                checkout = "<a class=\"w3-bar-item w3-button\" href=\"/order?lang=" + lang + "\">" + bundleInter.getString("checkout") + "</a>";
            }
        }
        else
        {
            foruser ="<a class=\"w3-bar-item w3-button\" href=\"/profile?lang="+lang+"\">"+bundleInter.getString("login")+"</a>";
        }

        String tab = (String)req.getSession().getAttribute("tab");
        if(tab==null)
        {
            tab="1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>index</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">"+
                "<link rel=\"stylesheet\" href=\"webapp/css/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"webapp/css/mystyle.css\">\n" +
                "</head>\n" +
                "\n" +
                "<script>"+
                "function openTab(currentTab) {\n" +
                "    if(currentTab==1)\n" +
                "    {\n" +
                "        document.getElementById(\"buttonBriefly\").classList.add(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonFeedbacks\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonFully\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"TabBriefly\").style.display=\"block\";\n" +
                "        document.getElementById(\"TabFully\").style.display=\"none\";\n" +
                "        document.getElementById(\"TabFeedbacks\").style.display=\"none\";\n" +
                "    }else if(currentTab==2)\n" +
                "    {\n" +
                "        document.getElementById(\"buttonFully\").classList.add(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonBriefly\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonFeedbacks\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"TabFully\").style.display=\"block\";\n" +
                "        document.getElementById(\"TabBriefly\").style.display=\"none\";\n" +
                "        document.getElementById(\"TabFeedbacks\").style.display=\"none\";\n" +
                "    }\n" +
                "    else if(currentTab==3)\n" +
                "    {\n" +
                "        document.getElementById(\"buttonFeedbacks\").classList.add(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonFully\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"buttonBriefly\").classList.remove(\"w3-light-gray\");\n" +
                "        document.getElementById(\"TabFeedbacks\").style.display=\"block\";\n" +
                "        document.getElementById(\"TabBriefly\").style.display=\"none\";\n" +
                "        document.getElementById(\"TabFully\").style.display=\"none\";\n" +
                "    }\n" +
                "}"+
                "</script>"+
                "<body>\n" +
                "<div class = \"w3-bar w3-black\" style=\"height: 38px;\">" +
                "<a class=\"w3-bar-item w3-button \" href=\"/products?lang="+lang+"&from=0&to=100000&filter=0\" style=\"padding-top: 2px;\"><div class=\"fa fa-home w3-xxlarge\"> </div> </a>"+
                foruser +
                profile +
                checkout +
                "<a class=\"w3-bar-item w3-button\" href=\"/cart?lang="+lang+"\">"+ bundleInter.getString("cart")+"</a>" +
                "<a class=\"w3-bar-item w3-button\" href=\"/purchases?lang="+lang+"\">"+ bundleInter.getString("history")+"</a>" +
                "<a style=\"float:right\" class=\"w3-bar-item w3-button\" href=\"/product?lang=fra&"+bundle.getString("reference")+"\">FRA</a>" +
                "<a style=\"float:right\" class=\"w3-bar-item w3-button\" href=\"/product?lang=en&"+bundle.getString("reference")+"\">ENG</a>" +
                "<a style=\"float:right\" class=\"w3-bar-item w3-button\" href=\"/product?lang=rus&"+bundle.getString("reference")+"\">RUS</a>" +
                "</div>"+
                "    <div class=\"wrapEx\">\n" +
                "    <div class=\"wrap\">\n" +
                "    \t<div class=\"w3-container space\">\n" +
                "         <h2 class=\"my-font\">" + bundle.getString("product_name") + "</h2>\n" +
                "        </div>  \n" +
                "\t\t<div class=\"w3-container w3-cell space\">\n" +
                "        \t<div class=\"w3-container w3-cell w3-cell-middle space underImage\">\n" +
                "            \t<div class=\"w3-content w3-display-container\" style=\"max-width:800px\">\n" +
                "                \t<img class=\"myImages\" src=\"" + bundle.getString("imagespath")+ "1.jpg\"" + " width=\"600px\" height=\"600px\">\n" +
                "  \t\t\t\t\t<img class=\"myImages\" src=\""+ bundle.getString("imagespath")+ "2.jpg\"" + " width=\"600px\" height=\"600px\">\n" +
                "  \t\t\t\t\t<img class=\"myImages\" src=\""+ bundle.getString("imagespath")+ "3.jpg\"" + " width=\"600px\" height=\"600px\">\n" +
                "                \t<div class=\"w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle\" style=\"width:100%\">\n" +
                "                    <div class=\"w3-left w3-text-black \" onclick=\"plusDivs(-1)\">&#10094;</div>\n" +
                "    \t\t\t\t<div class=\"w3-right w3-text-black\" onclick=\"plusDivs(1)\">&#10095;</div>\n" +
                "                \t<span class=\"w3-badge demo w3-border w3-transparent w3-hover-gray\" onclick=\"currentDiv(1)\"></span>\n" +
                "    \t\t\t\t<span class=\"w3-badge demo w3-border w3-transparent w3-hover-gray\" onclick=\"currentDiv(2)\"></span>\n" +
                "    \t\t\t\t<span class=\"w3-badge demo w3-border w3-transparent w3-hover-gray\" onclick=\"currentDiv(3)\"></span>\n" +
                "                </div>\n" +
                "            \t</div>\n" +
                "\t        \t</div>\n" +
                "        \t<div class=\"w3-container space\">\n" +
                "        \t\t<div class=\"w3-bar w3-black\">\n" +
                "        \t\t\t<button id=\"buttonBriefly\" class=\"w3-bar-item w3-button\" onClick=\"openTab(1)\">" + bundle.getString("briefly_tab") + "</button>\n" +
                "            \t\t<button id=\"buttonFully\" class=\"w3-bar-item w3-button\" onClick=\"openTab(2)\">" + bundle.getString("fully_tab") + "</button>\n" +
                "            \t\t<button id=\"buttonFeedbacks\" class=\"w3-bar-item w3-button\" onClick=\"openTab(3)\">" + bundle.getString("feedbacks_tab") + "</button>\n" +
                "                 </div>\n" +
                "        \t\t <div class=\"commentsArea\">\n" +
                "        \t\t\t<div id=\"TabBriefly\" >"+ bundle.getString("briefly") + "</div>\n" +
                "        \t\t\t<div id=\"TabFully\" > \n" + bundle.getString("fully") + " </div>\n" +
                "        \t\t\t<div id=\"TabFeedbacks\" > Feedbacks </div>\n" +
                "        \t\t</div>\n" +
                "\t\t\t</div>\n" +
                "        </div>\n" +
                "        <div class=\"w3-container w3-cell\">\n" +
                "        \t<button class=\"w3-button w3-round w3-blue buttonBuy\" onclick=\"addOrder('"+id+"','1')\" >" + bundleInter.getString("addToCart")+ "</button>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "        </div>\n" +
                "<script>openTab("+tab.toString()+")</script>"+
                "    <script src=\"webapp/SlideScripts.js\"></script>\n" +
                "    <script src=\"webapp/AddOrder.js\"></script>\n"+
                "</body>\n" +
                "</html>");
        PrintWriter out = resp.getWriter();
        out.println(sb.toString());
        out.close();
    }
}
