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
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt hoekPunt1, hoekPunt2, hoekPunt3;
    private Driehoek driehoek;
    private GridPane root;

    private int x, y, index;

    public DriehoekApp(GridPane root) {
        this.root = root;

        hoekPunt1 = puntInput("hoekpunt 1");
        hoekPunt2 = puntInput("hoekpunt 2");
        hoekPunt3 = puntInput("hoekpunt 3");

        root.getChildren().clear();

        /*Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
        driehoek.sorteerHoekPunten();

        Text uitvoer = new Text();
        uitvoer.setText(driehoek.toString());
        root.getChildren().clear();
        root.add(uitvoer, 0, 0);*/
    }

    public Punt puntInput(String puntNaam) {
        Label puntLabel =  new Label("Geef de x-coordinaat en y-coordinaat van " + puntNaam);
        TextField invoerPuntX = new TextField();
        TextField invoerPuntY = new TextField();

        root.add(puntLabel,0,index);
        root.add(invoerPuntX,1,index);
        root.add(invoerPuntY, 2, index);

        invoerPuntX.setOnAction(eventIngaveX ->{
            try
            {
                x = Integer.parseInt(invoerPuntX.getText());
            }
            catch(NumberFormatException e)
            {
                invoerPuntX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerPuntY.setOnAction(eventIngaveY ->{
            try
            {
                y = Integer.parseInt(invoerPuntY.getText());
            }
            catch(NumberFormatException e)
            {
                invoerPuntY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        index += 1;

        return new Punt(x, y);
    }
}
