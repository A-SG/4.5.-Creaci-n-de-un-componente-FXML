/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package componentes_santosalejandro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author Alejandro Santos Gutiérrez
 */
public class Temporizador  extends HBox implements Initializable {
    

    private Integer segundos = 15;
    
    @FXML
    private Label muestraSegundos;
    
        public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
 
  
    private void CuentaAtras() {
    Timeline time= new Timeline();
    KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event) {
            segundos--;
            muestraSegundos.setText(segundos.toString());
            if(segundos<=0)
            {
                time.stop();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Cuenta atrás finalizada!");
                                alert.show();
            }
        } 
    });
  
  time.setCycleCount(Timeline.INDEFINITE);
  time.getKeyFrames().add(frame);
  if(time!=null)
  {
    time.stop();
  }
  time.play();
}
    
  public void setSegundos(Integer segundos)
    {
        this.segundos = segundos;
    }
  
   public Integer getSegundos()
    {
       return segundos;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CuentaAtras();
    }    
    
}
