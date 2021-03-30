package ui;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {
    private Label invoerXLabel, invoerYLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerX, invoerY, invoerBreedte, invoerHoogte;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Punt linkerbovenhoek;
    private Rechthoek rechthoek;
    private int x, y, breedte, hoogte;

    public RechthoekApp(GridPane root) {

        invoerXLabel =  new Label("Geef de x-coordinaat van de linkerbovenhoek.");
        invoerX= new TextField();
        invoerYLabel = new Label("Geef de y-coordinaat van de linkerbovenhoek.");
        invoerY = new TextField();
        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek.");
        invoerBreedte = new TextField();
        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek.");
        invoerHoogte = new TextField();

        root.add(invoerXLabel,0,0);
        root.add(invoerX,1,0);

        invoerX.setOnAction(eventIngaveX ->{
            try
            {
                x = Integer.parseInt(invoerX.getText());
                invoerX.setDisable(true);
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e)
            {
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try
            {
                linkerbovenhoek = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                invoerY.setDisable(true);
                root.add(invoerBreedteLabel,0,2);
                root.add(invoerBreedte,1,2);
            }
            catch(NumberFormatException e)
            {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            try
            {
                breedte = Integer.parseInt(invoerBreedte.getText());
                invoerBreedte.setDisable(true);
                root.add(invoerHoogteLabel, 0, 3);
                root.add(invoerHoogte, 1, 3);
            }
            catch(NumberFormatException e)
            {
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet positief zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveHoogte ->{
            try
            {
                hoogte = Integer.parseInt(invoerHoogte.getText());
                rechthoek = new Rechthoek(linkerbovenhoek, breedte, hoogte);
                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.getChildren().clear();
                root.add(uitvoer, 0, 0);
            }
            catch(NumberFormatException e)
            {
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("hoogte moet positief zijn");
                foutenboodschap.showAndWait();
            }
        });

    }
}
