/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

import model.game.GameModel;
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
        if(GameModel.USER_LOGGED.getFirstContact()==1){
            ((MenuPanel)myView).showTutorial(true);
            ((MenuPanel)myView).enableComponents(false);
        }
    }

    void exitTutorial() {
            ((MenuPanel)myView).showTutorial(false);
            ((MenuPanel)myView).enableComponents(true);
            //TODO: Alterar valor do User e salvar
    }

    void exitApp() {
        if(((MenuPanel)myView).confirmExit()){
        } else {
            System.exit(0);
        }
        
    }
   
    
    
    
}
