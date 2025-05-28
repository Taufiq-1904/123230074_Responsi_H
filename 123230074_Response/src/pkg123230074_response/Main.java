/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123230074_response;

import controller.ShopController;
import model.ShopDAO;
import view.ShopForm;
/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ShopForm view = new ShopForm();
            ShopDAO dao = new ShopDAO();
            new ShopController(dao, view);
        });
    }
    
}
