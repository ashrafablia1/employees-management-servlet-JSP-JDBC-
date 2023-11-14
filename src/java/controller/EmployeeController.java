/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Service.EmployeeService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Role;
import model.User;

/**
 *
 * @author aablia
 */
public class EmployeeController extends HttpServlet {

    private final EmployeeService employeeService;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
    }

    private void proccesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "addUser":
                addNewUser(request, response);
                break;
            case "updateGet":
                updateUserView(request, response);
                break;
            case "updatePost":
                updateUser(request, response);
                break;
            case "deleteUser":
                deleteUser(request, response);
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesRequest(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccesRequest(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null) {
            String role = employeeService.loginValidate(email, password);
            if (role == null) {
                request.setAttribute("error", "email or password is not correct");

                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
            if (role.equals(Role.CLIENT.name())) {
                User user = employeeService.viewuserInfo(email);

                request.setAttribute("user", user);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.setAttribute("employees", employeeService.viewAllusers());
                request.getRequestDispatcher("adminHome.jsp").forward(request, response);
            }

        }
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String skill = request.getParameter("skill");
        String postion = request.getParameter("postion");
        String address = request.getParameter("address");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setAddress(address);
        user.setRole(Role.valueOf(role));
        user.setSkill(skill);
        user.setPostion(postion);

        employeeService.addNewUser(user);

        request.setAttribute("employees", employeeService.viewAllusers());
        request.getRequestDispatcher("adminHome.jsp").forward(request, response);

    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String skill = request.getParameter("skill");
        String position = request.getParameter("position");
        String address = request.getParameter("address");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setAddress(address);
        user.setRole(Role.valueOf(role));
        user.setSkill(skill);
        user.setPostion(position);
        employeeService.updateUser(user);

        request.setAttribute("employees", employeeService.viewAllusers());
        request.getRequestDispatcher("adminHome.jsp").forward(request, response);

    }

    private void updateUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        request.setAttribute("user", employeeService.updateView(id));
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        employeeService.delete(id);

        request.setAttribute("employees", employeeService.viewAllusers());
        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
    }

}
