/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

import data.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergi
 */
public class AppKernel {
    public static String TASK_STATUS;
    public static int TASK_VALUE = 0;
    public static int TASK_MAX_VALUE = 10;
    public AppKernel(){
        executeTasks();
    }

    private void executeTasks() {
        //Carregar e preparar DataBase
        TASK_STATUS = "Preparando banco de dados local...";
        DataBase dataBase = new DataBase();
        dataBase.createDataBase();
        TASK_VALUE = 1;
        TASK_STATUS = "Preparando tela de login...";
        waitMillis(2000);
        TASK_VALUE = 2;
        TASK_STATUS = "Embaralhando suas cartas...";
        waitMillis(1000);
        TASK_STATUS = "Boa sorte...";
        TASK_VALUE = TASK_MAX_VALUE;
        
        
    }
    private void waitMillis(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppKernel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
