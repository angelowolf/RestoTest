<%-- 
    Document   : 404
    Created on : 09/12/2015, 01:04:03
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error 500</title>
        <style>
            html,body{
                height: 100%;
            }
            .horizontal{
                display: flex;
                justify-content: center;
            }
            .vertical{
                display:flex;
                flex-direction:column;
                justify-content: center;
            }
            .padre{
                height: 100%;
            }

        </style>
    </head>
    <body>
        <div class="horizontal padre">
            <div class="vertical">
                <img id="img" src=""/>
            </div>
        </div>
    </body>
</html>
<script>
    var x = Math.floor(Math.random() * 2) + 1;
    var img = document.getElementById('img');
    switch (x) {
        case 1:
            img.src = "/../imagenes/500.jpg";
            break;
        case 2:
            img.src = "/../imagenes/500_1.jpg";
            break;
    }
</script>