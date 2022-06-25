<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IT355 - DZ04</title>
    </head>
    <body>
        <h1>Izabrali ste: </h1>
        <%
            if (!request.getParameter("ime").equals("")) {
                out.print("Dobrodosli " + request.getParameter("ime") + ", izabrali ste sledece fakultete: ");
            } else {
                out.print("Polje za ime mora biti popunjeno !!");
            }
             if (request.getParameter("fit") != null && request.getParameter("fit").equals("on")) {
                out.print("FIT Link je : ");
                out.print("<a href='prikaz.jsp?fname=" + "fit" + "'>Link</a></br>");
                out.print("<p>Lorem ipsum.</p>");
            }
            if (request.getParameter("fad") != null && request.getParameter("fad").equals("on")) {
                out.print("FAD Link je : ");
                out.print("<a href='prikaz.jsp?fname=" + "fad" + "'>Link</a></br>");
                out.print("<p>Lorem ipsum.</p>");
            }
            if (request.getParameter("fam") != null && request.getParameter("fam").equals("on")) {
                out.print("FAM Link je : ");
                out.print("<a href='prikaz.jsp?fname=" + "fam" + "'>Link</a></br>");
                out.print("<p>Lorem ipsum</p>");
            }
        %>
    </body>
</html>
