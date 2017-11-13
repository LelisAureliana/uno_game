/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import javax.swing.JPanel;
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
    
    }
    
    public void onBtnLoginClicked(){
        MenuPanelController menuPanelController = new MenuPanelController();
        menuPanelController.startView();
    }
    @Override
    public void startView() {
        MainFrameController.setView(new LoginPanel(this));
    }

    

}
