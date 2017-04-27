/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdfacebookapp;

/**
 *
 * @author otorradomiguez
 */
public class CDFacebookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FB face=new FB();
        face.Config();
        //face.publicarEstado("Facilisimo");
        face.buscarUsuario("Omar Torrado");
        face.publicarPost();
    }
    
}
