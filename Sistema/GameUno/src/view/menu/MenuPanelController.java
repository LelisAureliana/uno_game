/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

import view.MainFrameController;
import view.ViewController;

/**
 *
 * @author sergi
 */
public class MenuPanelController extends ViewController{

    @Override
    public void startView() {
        myView = new MenuPanel(this);
        MainFrameController.setView(myView);
    }

    void exitApp() {
        if(((MenuPanel)myView).confirmExit()){
        } else {
            System.exit(0);
        }
        
    }
   
    
    
    
}
