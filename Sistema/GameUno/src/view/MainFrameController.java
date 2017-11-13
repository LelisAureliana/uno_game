/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import view.load.LoadPanel;

/**
 *
 * @author sergi
 */
public class MainFrameController {
    private static MainFrame mainFrame;
    LoadPanel a;
    public MainFrameController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        a = new LoadPanel();
        setView(a);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(a.loadApp()){
                        //TODO: Chamar a tela de Login
                    }
                }
            }
        }).start();        
    }

    public static void setView(JPanel view){
        System.out.println("view.MainFrameController.setView()"+view.getClass().getName());
        view.setVisible(true);
        mainFrame.setContentPane(view);
    }
}
