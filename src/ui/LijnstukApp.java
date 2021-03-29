package ui;

import domain.LijnStuk;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private final Label invoerXStartLabel;
    private final Label invoerYStartLabel;
    private final TextField invoerXStart;
    private final TextField invoerYStart;
    private final Label invoerXEindLabel;
    private final Label invoerYEindLabel;
    private final TextField invoerXEind;
    private final TextField invoerYEind;
    private final Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private LijnStuk lijnStuk;
    private Punt startPunt;
    private Punt eindPunt;

    public LijnstukApp(GridPane root) {

        invoerXStartLabel = new Label("Geef de x-coördinaat van het start punt ");
        invoerXStart = new TextField();
        invoerYStartLabel = new Label("Geef de y-coördinaat van het start punt ");
        invoerYStart = new TextField();
        invoerXEindLabel = new Label("Geef de x-coördinaat van het start punt ");
        invoerXEind = new TextField();
        invoerYEindLabel = new Label("Geef de y-coördinaat van het start punt ");
        invoerYEind = new TextField();

        root.add(invoerXStartLabel, 0, 0);
        root.add(invoerXStart, 1, 0);

        invoerXStart.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerXStart.getText());
                root.add(invoerYStartLabel, 0, 1);
                root.add(invoerYStart, 1, 1);
            } catch (NumberFormatException e) {
                invoerXStart.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van het start punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerYStart.setOnAction(eventIngaveY -> {
            try {
                startPunt = new Punt(Integer.parseInt(invoerXStart.getText()), Integer.parseInt(invoerYStart.getText()));
                root.getChildren().clear();

            } catch (NumberFormatException e) {

                invoerYStart.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat van het start punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        root.add(invoerXEindLabel, 0, 0);
        root.add(invoerXEind, 1, 0);

        invoerXEind.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerXEind.getText());
                root.add(invoerYEindLabel, 0, 1);
                root.add(invoerYEind, 1, 1);
            } catch (NumberFormatException e) {
                invoerXEind.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat van het eind punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerYEind.setOnAction(eventIngaveY -> {
            try {
                eindPunt = new Punt(Integer.parseInt(invoerXEind.getText()), Integer.parseInt(invoerYEind.getText()));
                lijnStuk = new LijnStuk(startPunt, eindPunt);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnStuk.toString());
                root.add(uitvoer, 0, 0);
            } catch (NumberFormatException e) {

                invoerYEind.clear();

                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }
}