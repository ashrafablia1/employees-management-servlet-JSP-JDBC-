<%-- 
    Document   : addUser
    Created on : Oct 11, 2023, 4:20:39 PM
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
        <h1>Hello World!</h1>
        
        <form action="control" method="post">
          EMAIL: <input type="text" name="email" /> <br>  
          PASSWORD: <input type="password" name="password" />
          Name: <input type="text" name="name" />
          age: <input type="text" name="age" />
          skill: <input type="text" name="skill" />
          position: <input type="text" name="postion" />
          address: <input type="text" name="address" />
      
        role: <select name="role">
     <option value="ADMIN">ADMIN</option>
     <option value="CLIENT">CLIENT</option>
        </select>

          <input type="hidden" name="action" value="addUser">
          <input type="submit" value="submit"/>
        </form> 
        
        
        
    </body>
</html>
