package ui;

import domain.Cirkel;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CirkelApp {
    private final Label invoerXLabel;
    private final Label invoerYLabel;
    private final Label invoerRadiusLabel;
    private final TextField invoerX;
    private final TextField invoerY;
    private final TextField invoerRadius;
    private final Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Cirkel cirkel;

    public CirkelApp(GridPane root) {
        invoerXLabel = new Label("Geef de x-coördinaat van het punt ");
        invoerX = new TextField();
        invoerYLabel = new Label("Geef de y-coördinaat van het punt ");
        invoerY = new TextField();
        invoerRadiusLabel = new Label("Geef de radius van de cirkel.");
        invoerRadius = new TextField();

        root.add(invoerXLabel, 0, 0);
        root.add(invoerX, 1, 0);

        invoerX.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            } catch (NumberFormatException e) {
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
               // cirkel = new Cirkel(Integer.parseInt(invoerX.getText(), invoerY.getText()), Integer.parseInt(invoerY.getText()));
                cirkel = new Cirkel(new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText())), Integer.parseInt(invoerRadius.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(cirkel.toString());
                root.add(uitvoer, 0, 0);
            } catch (NumberFormatException e) {

                invoerY.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
    }


