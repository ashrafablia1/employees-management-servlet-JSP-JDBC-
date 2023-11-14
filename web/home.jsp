<%-- 
    Document   : home
    Created on : Oct 12, 2023, 8:31:03 AM
    Author     : aablia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>employee info</h1>
        
        Id: ${user.id} <br/>
        Name: ${user.name}<br/>
        role: ${user.role} <br/>
        email: ${user.email} <br/>
        age: ${user.age} <br/>
        skill: ${user.skill} <br/>
        position: ${user.postion} <br/>
        Address: ${user.address}

    </body>
</html>
