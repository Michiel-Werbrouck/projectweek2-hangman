package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WoordRadenApp {
    private Label invoerLetterLabel;
    private TextField invoerLetter;
    private Label woordLabel;
    private String woord;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private HintWoord hintWoord = new HintWoord("hangmanspel");

    public WoordRadenApp(GridPane root, Speler speler){
        invoerLetterLabel = new Label("Geef een letter:");
        invoerLetter = new TextField();

        Text uitvoer1 = new Text();
        uitvoer1.setText("Rarara, welk woord zoeken we?");
        root.add(uitvoer1,0,1);
        Text uitvoer2 = new Text();
        uitvoer2.setText(hintWoord.toString());
        root.add(uitvoer2,0,2);

        root.add(invoerLetterLabel, 0, 3);
        root.add(invoerLetter, 0, 4);

        invoerLetter.setOnAction(eventIngaveLetter -> {
            try {
                if (hintWoord.raad(invoerLetter.getText().charAt(0))){
                    root.getChildren().clear();

                    Text uitvoer3 = new Text();
                    uitvoer3.setText("Super, doe zo voort!");
                    root.add(uitvoer3, 0, 0);

                }
                else {
                    root.getChildren().clear();

                    Text uitvoer3 = new Text();
                    uitvoer3.setText("Helaas volgende keer beter!");
                    root.add(uitvoer3, 0, 0);

                }
                root.add(uitvoer1,0,1);
                uitvoer2.setText(hintWoord.toString());
                root.add(uitvoer2,0,2);
                root.add(invoerLetterLabel, 0, 3);
                root.add(invoerLetter, 0, 4);
                invoerLetter.clear();

                if(hintWoord.isGeraden()){
                    root.getChildren().clear();
                    Text uitvoer = new Text();
                    uitvoer.setText("Goed gedaan "+speler.getNaam()+"! Je hebt het woord geraden!");
                    root.add(uitvoer, 0, 1);
                }
            } catch (DomainException e) {
                invoerLetter.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }
}
