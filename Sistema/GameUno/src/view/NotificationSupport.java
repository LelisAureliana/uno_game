/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.notification.NotificationType;

/**
 *
 * @author sergi
 */
public interface NotificationSupport {
    public void notify(NotificationType notificationType,String message);
}
