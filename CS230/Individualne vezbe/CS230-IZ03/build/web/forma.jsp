<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <center> 
        <h1>Citanje Checkbox podataka</h1>
    </center>
    <form method="POST" action="prikaz.jsp">
        <ul>
            <% if (request.getParameter("fit") != null) { %>  
                <h3>Izabrali ste FIT!</h3>
                <input type="submit" name="fit" value="Prikažite informacije o FIT-u">
            <%
                } 
            %>
            <% if (request.getParameter("fdu") != null) { %>  
                <h3>Izabrali ste FDU!</h3>
                <input type="submit" name="fdu" value="Prikažite informacije o FDU-u">
            <%
                }
            %>
            <% if (request.getParameter("fam") != null) { %>  
                <h3>Izabrali ste FAM!</h3>
                <input type="submit" name="fam" value="Prikažite informacije o FAM-u">
            <%
                }
            %>
        </ul>
    </form>
</body>
</html>
