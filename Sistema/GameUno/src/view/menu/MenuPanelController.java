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
public class MenuPanelController implements ViewController{
    private MenuPanel myView;
    
    @Override
    public void startView() {
        myView = new MenuPanel(this);
        MainFrameController.setView(myView);
        //Caso o usuario logado esteja usando o sistema pela primeira vez
        if(GameModel.USER_LOGGED.getFirstContact()==1){
           myView.showTutorial(true);
           myView.enableComponents(false);
        }
    }
    /**
     * Reponde ao evento de fechar o tutorial
     */
    void exitTutorial() {
           myView.showTutorial(false);
           myView.enableComponents(true);
            //TODO: Alterar valor do User e salvar
    }
    /**
     * Sair da aplicação
     */
    void exitApp() {
        if(myView.confirmExit()){
        } else {
            System.exit(0);
        }
        
    }
   
    
    
    
}
