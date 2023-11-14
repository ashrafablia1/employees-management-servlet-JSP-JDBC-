<%-- 
    Document   : update
    Created on : Oct 12, 2023, 1:01:16 PM
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
        <h1>Update User</h1>
        
        
         <form action="control" method="post">
         <input type="hidden" name="id" value=${user.getId()} >
          EMAIL: <input type="text" name="email" value=${user.getEmail()} /> <br>  
          PASSWORD: <input type="password" name="password" value=${user.getPassword()} /> <br>
          Name: <input type="text" name="name" value=${user.getName()} /> <br>
          age: <input type="text" name="age" value=${user.getAge()} /> <br>
          skill: <input type="text" name="skill" value=${user.getSkill()} /> <br>
          position: <input type="text" name="position" value=${user.getPostion()} /> <br>
          address: <input type="text" name="address" value=${user.getAddress()} /> <br>
      
        role: <select name="role" > <br>
     <option value=${user.getRole()}>${user.getRole()}</option>
     <option value=${user.getRole()=="ADMIN"? "ADMIN" : "CLIENT" } >${user.getRole()=="ADMIN"? "CLIENT" : "ADMIN" }</option>
        </select>

          <input type="hidden" name="action" value="updatePost">
          <input type="submit" value="submit"/>
        </form> 
        
    </body>
</html>
