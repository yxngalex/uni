<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prikaz detaljnijih podataka</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="prikaz-podataka-container">
            <div class="logo-container">
                <img src="images/metropolitanTransparent.png" alt="logo"/>
            </div>
            <% if(request.getParameter("fit") != null){ %>
                <p>Vi ste student <span>FIT</span> fakuleta.</p>
            <%
                }
             if(request.getParameter("fdu") != null){ %>
                <p>Vi ste student <span>FDU</span> fakuleta.</p>
            <%
                }
            if(request.getParameter("fam") != null){ %>
                <p>Vi ste student <span>FAM</span> fakuleta.</p>
            <%
                }
            %>
        </div>
    </body>
</html>
