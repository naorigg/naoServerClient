package jp.naori.client;
import fr.arinonia.arilibfx.utils.AriLogger;
import javafx.application.Application;

import javax.swing.*;

public class Main {
    public static AriLogger Logger;
    public static void main(String[] args) {

        Logger = new AriLogger("NaoClient");

        try{
            Class.forName("javafx.application.Application");
            Application.launch(FxApplication.class, args);

        }catch(ClassNotFoundException e){
            Logger.warn(null, "Err with Java" + e.getMessage() + "Not found...", "Err Java", JOptionPane.ERROR_MESSAGE);



        }
    }

}
