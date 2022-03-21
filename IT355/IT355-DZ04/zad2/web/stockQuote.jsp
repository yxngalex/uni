<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stock Quote</title>
    </head>
    <body>
        <h1>Stock Quote</h1>
        <%
            String brAkcija = request.getParameter("brojAkcija");
            int brojAkcija = 1;
            if (!brAkcija.equals(null) && !brAkcija.equals("")) {
                brojAkcija = Integer.parseInt(brAkcija);
            }
        %>
        <jsp:useBean id="stock" class="rs.ac.metropolitan.it355.StockBean" />
        <jsp:setProperty name="stock" property="simbol" />

        <jsp:useBean id="generator" class="rs.ac.metropolitan.it355.StockPrice" />
        <%
            String simbol = request.getParameter("simbol");
            if (!generator.calculatePrice(simbol, brojAkcija).equals("Simbol nije podrzan")) {
                out.println(generator.calculatePrice(simbol, brojAkcija) + ". Simbol je :" + simbol);
            } else {
                out.println("Bicete vraceni na pocetnu stranicu za 6 sekundi zbog nepravilno unetih podataka !!!");
                response.setHeader("Refresh", "6; URL=http://localhost:8080/CS230-DZ04/welcome.jsp");
            }
        %>
    </body>
</html>
