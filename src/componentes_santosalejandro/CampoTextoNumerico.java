/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package componentes_santosalejandro;

import java.io.IOException;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 *
 * @author Alejandro Santos Gutiérrez
 */
public class CampoTextoNumerico extends TextField {
    

    public CampoTextoNumerico() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CampoTextoNumerico.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void replaceText(int start, int end, String text) 
    {
        if (!text.matches("[a-z, A-Z]")) {
        super.replaceText(start, end, text);
    }
        //label.setText("Enter a numeric value");
    }
    @Override
    public void replaceSelection(String text) {
    if (!text.matches("[a-z, A-Z]")) {
        super.replaceSelection(text);
        }
    }
}
