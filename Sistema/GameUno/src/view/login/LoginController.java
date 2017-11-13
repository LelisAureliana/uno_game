/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import javax.swing.JPanel;
import model.user.User;
import model.user.UserModel;
import view.MainFrameController;
import view.ViewController;
import view.menu.MenuPanel;
import view.menu.MenuPanelController;


/**
 *
 * @author sergi
 */
public class LoginController extends ViewController{

 
    
    public LoginController(){
        myView  = new LoginPanel(this);
    }
    
    public void onBtnLoginClicked(String login, String senha){
        //Realizar login
        UserModel model = new UserModel();
        User u = new User();
        u.setLogin(login);
        u.setPassword(senha);
        ((LoginPanel)myView).confirmLogin(model.doLogin(u));
    }
    public void loginSuccess(){
        MenuPanelController menuPanelController = new MenuPanelController();
        menuPanelController.startView();
       
    }
    @Override
    public void startView() {
        MainFrameController.setView(myView);
    }

    

}
