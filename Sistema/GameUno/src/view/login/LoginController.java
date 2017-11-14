/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import model.user.User;
import model.user.UserModel;
import view.MainFrameController;
import view.ViewController;
import view.load.LoadInterface;
import view.load.LoadPanel;
import view.menu.MenuPanelController;


/**
 * Controller da view de Login
 * @author sergi
 */
public class LoginController implements ViewController{
    private LoginPanel myView;
    
    public LoginController(){
        myView  = new LoginPanel(this);
    }
    /**
     * Responder ao botao de login
     * @param login
     * @param senha 
     */
    public void onBtnLoginClicked(String login, String senha){
        //Realizar login
        UserModel model = new UserModel();
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(senha);
        myView.confirmLogin(model.doLogin(newUser));
    }
    
    /**
     * Realizar login
     */
    public void loginSuccess(){
        //Carregar jogo, iniciar task de jogo
        
        //Definir Task para executar
        
        
        MainFrameController.setView(new LoadPanel(new LoadInterface() {
            @Override
            public void onLoadComplete() {
                MenuPanelController menuPanelController = new MenuPanelController();
                menuPanelController.startView();
            }
        }));
        
        
       
    }
    @Override
    public void startView() {
        MainFrameController.setView(myView);
    }

    

}
