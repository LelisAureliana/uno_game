/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JPanel;
import kernel.task.StartTask;
import kernel.task.TestTask;
import view.load.LoadInterface;
import view.load.LoadPanel;
import view.login.LoginController;

/**
 * Frame principal
 * @author sergi
 */
public class MainFrameController {
    private static MainFrame mainFrame;
    public MainFrameController(){
        mainFrame = new MainFrame();
    }
    /**
     * Metodo para startar a view incial da aplicação
     */
    public static void startView(){
        mainFrame.setVisible(true);
        //Start Task
        new Thread(() -> {
            new StartTask().executeTasks();
        }).start();
        // Set view com a Load para observar o carregamento
        setView(new LoadPanel(new LoadInterface() {
            @Override
            public void onLoadComplete() {
                new Thread(() -> {
                    //Linha para testes
                        new TestTask().executeTasks();
                }).start();
                MainFrameController.setView(new LoadPanel(new LoadInterface() {
                    @Override
                    public void onLoadComplete() {
                        LoginController loginController = new LoginController();
                        loginController.startView();
                    }
                }));
                
                //Linha para produção
                    //LoginController loginController = new LoginController();
                    //loginController.startView();
            }
        }));
    }
    
    /**
     * Metodo para setar um Panel novo na Frame principal
     * @param view 
     */
    public static void setView(JPanel view){
        System.out.println("view.MainFrameController.setView()"+view.getClass().getName());
        view.setVisible(true);
        mainFrame.setContentPane(view);
        mainFrame.revalidate();
    }
}
