<%-- 
    Document   : adminHome
    Created on : Oct 11, 2023, 12:11:10 PM
    Author     : aablia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Employees</h1>
            <a href="/EmployeesManagement/addUser.jsp">Add new employee</a>
            
<br/><br/>
        
        
        
        
        <% List<User> employees = (ArrayList<User>)request.getAttribute("employees");
        for(User user : employees){
        
       out.print("Id: " + user.getId()+ " //  ");

        out.print("Name: " + user.getName()+ " //  ");
       
        
        out.print("Age: " + user.getAge()+ "  // ");
        
        
        out.print("skill: " + user.getSkill()+ " //  ");
        
        
         out.print("address: " + user.getAddress()+ "   ");
         out.print("    ///   <a href="+request.getContextPath()+"/control?action=updateGet&id="+user.getId()+">update</a>  ///  ");
         out.print("    ///   <a href="+request.getContextPath()+"/control?action=deleteUser&id="+user.getId()+">delete</a>  ///  ");

       //${}+
        out.print("<br/>");
        }
       
        %> 
    </body>
</html>
