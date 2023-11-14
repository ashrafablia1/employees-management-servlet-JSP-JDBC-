package Service;


import dao.EmployeeDao;
import java.util.List;
import model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aablia
 */
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }
    
    
    public String loginValidate(String email, String password){

        User user = employeeDao.find(email);
        if(user != null && user.getPassword().equals(password)){
            return user.getRole().name();
        }
        return null;
    }

    public User viewuserInfo(String email) {
        User user = employeeDao.find(email);
        User viewUser = null;
        if(user != null){
        viewUser = new User();
        viewUser.setName(user.getName());
        viewUser.setId(user.getId());
        viewUser.setRole(user.getRole());
        viewUser.setEmail(user.getEmail());
        viewUser.setAge(user.getAge());
        viewUser.setSkill(user.getSkill());
        viewUser.setPostion(user.getPostion());
        viewUser.setAddress(user.getAddress());
        }
    return viewUser;        
    }

    public List<User> viewAllusers() {
        List<User> employees = employeeDao.findAll();
        if(!employees.isEmpty()) {
            return employees;
        }
        return null;
    }
    
    
    public boolean addNewUser(User user){
        if(user != null && employeeDao.find(user.getEmail()) == null ){
           int num = employeeDao.insert(user);
           return num!=0;
        }
        return false;
    }
    
    
    
   public void updateUser(User user){
       if(user.getId()!= null || user.getName() != null || user.getEmail()!= null ||
               user.getPassword() != null || user.getAddress() != null ||
         user.getPostion()!= null ||  user.getRole()!= null || user.getSkill()!= null){
           
           employeeDao.update(user);
           
       }
   } 
    

   public User updateView(Long id){
      User user = employeeDao.findById(id);
      return user;
   }


   
   
 public boolean delete(Long id){
     if(employeeDao.findById(id)!= null ){
        return employeeDao.delete(id)!=0;
     }
     return false;
 }


    
}
