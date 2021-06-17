package rs.ac.metropolitan.cs230.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=utf8;");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet1</title>");
        out.println("</head>");
        out.println("<h2>Pozdrav korisniče sa sledećim unetim podacima : Ime: " + request.getParameter("ime") + ", Prezime : " + request.getParameter("prezime") + "</h2>");
        out.println("<body>");
        out.print("<a href='Servlet2?ime=" + request.getParameter("ime") + "&prezime=" + request.getParameter("prezime") + " '>Drugi servlet link</a></br>");
        out.println("</body>");
        out.println("</html>");
    }

}
