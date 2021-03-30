package ui;

import domain.Driehoek;
import domain.Punt;
import domain.Rechthoek;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label hoekPunt1Label, hoekPunt2Label, hoekPunt3Label;
    private TextField invoerHoekPunt1, invoerHoekPunt2, invoerHoekPunt3;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt hoekPunt1, hoekPunt2, hoekPunt3;
    private Driehoek driehoek;
    private int x, y, breedte, hoogte;

    public DriehoekApp(GridPane root) {

        hoekPunt1Label =  new Label("Geef de x-coordinaat van de linkerbovenhoek.");
        invoerHoekPunt1= new TextField();
        hoekPunt2Label = new Label("Geef de y-coordinaat van de linkerbovenhoek.");
        invoerHoekPunt2 = new TextField();
        hoekPunt3Label = new Label("Geef de breedte van de rechthoek.");
        invoerHoekPunt3 = new TextField();


        root.add(hoekPunt1Label,0,0);
        root.add(invoerHoekPunt1,1,0);

        invoerHoekPunt1.setOnAction(eventIngaveX ->{
            try
            {
                x = Integer.parseInt(invoerHoekPunt1.getText());
                invoerHoekPunt1.setDisable(true);
                root.add(hoekPunt2Label, 0, 1);
                root.add(invoerHoekPunt2, 1, 1);
            }
            catch(NumberFormatException e)
            {
                invoerHoekPunt1.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoekPunt2.setOnAction(eventIngaveY -> {
            try
            {
              //  linkerbovenhoek = new Punt(Integer.parseInt(invoerHoekPunt1.getText()), Integer.parseInt(invoerHoekPunt2.getText()));
                invoerHoekPunt2.setDisable(true);
                root.add(hoekPunt3Label,0,2);
                root.add(invoerHoekPunt3,1,2);
            }
            catch(NumberFormatException e)
            {
                invoerHoekPunt2.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoekPunt3.setOnAction(eventIngaveBreedte ->{
            try
            {
                breedte = Integer.parseInt(invoerHoekPunt3.getText());
                invoerHoekPunt3.setDisable(true);
             //   root.add(invoerHoogteLabel, 0, 3);
             //   root.add(invoerHoogte, 1, 3);
            }
            catch(NumberFormatException e)
            {
                invoerHoekPunt3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet positief zijn");
                foutenboodschap.showAndWait();
            }
        });



    }
}
