<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IT355 - DZ04</title>
    </head>
    <body>
        <h1>Kreirajte izbor:</h1>
        <form method="GET" action="forma.jsp">
            FIT:<input type="checkbox" name="fit"/></br>
            FAD:<input type="checkbox" name="fad"/></br>
            FAM:<input type="checkbox" name="fam"/></br>
            <input type="text" name="ime"/>
            <input type="submit" value="Posalji"/>
        </form>
    </body>
</html>
