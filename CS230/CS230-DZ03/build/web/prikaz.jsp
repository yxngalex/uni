<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CS230 - DZ03 </title>
    </head>
    <body>
        <img src="logo.png" alt="logo" />
        <h1>Izabrani fakultet:</h1>
        <%
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fit")) {
                out.print("Vi ste student " + request.getParameter("fname") + " fakulteta.");

        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija">
        <% }
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fad")) {
                out.print("Vi ste student " + request.getParameter("fname") + " fakulterta.");
        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment">
        <%
            }
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fam")) {
                out.print("Vi ste student " + request.getParameter("fname") + " fakulterta.");
        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2">
        <%
            }
        %>
    </body>
</html>
