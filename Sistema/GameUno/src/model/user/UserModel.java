/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import data.dao.UserDAO;
import java.util.List;

/**
 * 
 * @author sergi
 */
public class UserModel {
    
    private UserDAO myDAO;
    public UserModel(){
        this.myDAO = new UserDAO();
    }
    
    public List<User> getAllUsers(){
        return myDAO.getAll();
    }
    
    public void insertUser(User u){
        myDAO.INSERT(u);
    }
    
    public boolean doLogin(User u) {
        
        User searchUser =  myDAO.doLogin(u);
        
        if(searchUser!=null){
            return true;
        }
        return  false;
    }
}
