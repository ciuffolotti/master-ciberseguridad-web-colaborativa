package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String email, String type){
        if(User.exists(email)) {
            flash.error("User with this email already exists!");
            register();
        } else {
            User u = new User(username, HashUtils.getMd5(password), email, type, -1);
            u.save();
            registerComplete();
        }
    }    

    public static void registerComplete(){
        render();
    }
}
