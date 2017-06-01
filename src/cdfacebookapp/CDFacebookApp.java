/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdfacebookapp;

import javax.swing.JOptionPane;

/**
 *
 * @author otorradomiguez
 */
public class CDFacebookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FB face = new FB();
        face.Config();
        int opcion = -7;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Pulsa:\n1.Bucar usuario\n2.Publicar estado\n3.Publicar post"));
            switch (opcion) {
                case 1:
                    face.buscarUsuario(JOptionPane.showInputDialog("Indica el usuario a buscar"));
                    break;
                case 2:
                    face.publicarEstado(JOptionPane.showInputDialog("Escribe el estado que quieres publicar"));
                    break;
                case 3:
                    face.publicarPost();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (opcion != 0);
    }
}
