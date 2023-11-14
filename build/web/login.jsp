<%-- 
    Document   : index
    Created on : Oct 9, 2023, 10:07:20 AM
    Author     : aablia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        ${error}
        <form action="control">
          EMAIL: <input type="text" name="email" /> <br>  
          PASSWORD: <input type="password" name="password" />
          <input type="hidden" name="action" value="login">
          <input type="submit" value="submit"/>
        </form>    

    </body>
</html>
