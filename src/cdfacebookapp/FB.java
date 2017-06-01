/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdfacebookapp;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author otorradomiguez
 */
public class FB {

    Facebook facebook;

    /**
     * Inicia la instancia de FB
     */
    public void Config() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("**********")
                .setOAuthAppSecret("**********")
                .setOAuthAccessToken("**********")
                .setOAuthPermissions("email,publish_stream,publish_actions,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }

    /**
     * Busca usuarios con el nombre indicado
     * @param usuario el nombre que queremos buscar
     */
    public void buscarUsuario(String usuario) {
        try {
            ResponseList<User> results = facebook.searchUsers(usuario);
            for (User u : results) {
                System.out.println(u.getFirstName() + " " + u.getLastName() + " :" + u.getUsername());
            }
            if (results.size() < 1) {
                System.out.println("Sin resultados");
            }
        } catch (FacebookException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Publica un estado en el muro
     * @param mensaje Texto que queremos publicar
     */
    public void publicarEstado(String mensaje) {
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException e) {
            e.toString();
        }
    }

    /**
     * Publica un post predefinido con una imagen
     */
    public void publicarPost() {
        try {
            PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
                    .picture(new URL("http://facebook4j.org/images/hero.png"))
                    .name("Facebook4J - A Java library for the Facebook Graph API")
                    .caption("facebook4j.org")
                    .description("Facebook4J is a Java library for the Facebook Graph API.");
            facebook.postFeed(post);
        } catch (MalformedURLException | FacebookException ex) {
            Logger.getLogger(FB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
