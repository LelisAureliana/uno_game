/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JPanel;
import view.load.LoadPanel;

/**
 *
 * @author sergi
 */
public class MainFrameController {
    private static MainFrame mainFrame;
    LoadPanel loadPanel;
    public MainFrameController(){
        mainFrame = new MainFrame();
        loadPanel = new LoadPanel();
    }
    
    public static void startView(){
        mainFrame.setVisible(true);
        setView(new LoadPanel());
    }
    
    public static void refreshFrame(){
        mainFrame.revalidate();
    }
    public static void setView(JPanel view){
        System.out.println("view.MainFrameController.setView()"+view.getClass().getName());
        view.setVisible(true);
        mainFrame.setContentPane(view);
    }
}
