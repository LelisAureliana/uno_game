/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

import view.MainFrameController;
import view.load.LoadPanel;

/**
 *
 * @author sergi
 */
public class AppCore {
    public static void main(String[] args){
        //Jogo 
        new Thread(() -> {
            new MainFrameController().startView();
        }).start();
        //Tasks
        new Thread(() -> {
            new AppTasks();
        }).start();
    }
}
