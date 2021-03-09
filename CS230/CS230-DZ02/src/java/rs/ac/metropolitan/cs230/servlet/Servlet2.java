package rs.ac.metropolitan.cs230.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet2", urlPatterns = {"/Servlet2"})
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=utf8;");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Uspešno ste savladali osnove rada sa servletima : " + request.getParameter("ime") + " " + request.getParameter("prezime") + "" + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
