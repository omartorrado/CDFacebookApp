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

    public void Config() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1708752362750702")
                .setOAuthAppSecret("acab787dfca5bc6f057dcc9864ad2987")
                .setOAuthAccessToken("EAAYSGemXQu4BAM9b0wUSiUZAqu39KZA3wzbG89Tk207ZBIRDjPp3cHCEoZCMJyPXRVjHJs5PHnuo4jJ7cYleYsDWnEzhSD1yVVAwZBZC9HZA0Ys0xmjyRnGwF7ZCRNZAVIZBJxsHSwbcYpJCZC9BUwmnWID0OkvCO2T6i5wpPdW3ipoHJb0ceceNnvWPdV8vD7EPKMZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }

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

    public void publicarEstado(String mensaje) {
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException e) {
            e.toString();
        }
    }

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
