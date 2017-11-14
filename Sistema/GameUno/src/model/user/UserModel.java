/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.user;

import data.dao.UserDAO;
import java.util.List;
import model.game.GameModel;

/**
 * Model de Usuario
 * @author sergi
 */
public class UserModel {
    
    private UserDAO myDAO;
    public UserModel(){
        this.myDAO = new UserDAO();
    }
    /**
     * Listar todos os usuarios do sistema
     * @return 
     */
    public List<User> getAllUsers(){
        return myDAO.getAll();
    }
    /**
     * Inserir usuarios
     * @param newUser 
     */
    public void insertUser(User newUser){
        myDAO.INSERT(newUser);
    }
    
    /**
     * Realizar login de usuario
     * @param userReceiver
     * @return 
     */
    public boolean doLogin(User userReceiver) {
        
        User searchUser =  myDAO.doLogin(userReceiver);
        
        if(searchUser!=null){
            GameModel.USER_LOGGED = searchUser; 
            return true;
        }
        return  false;
    }
}
