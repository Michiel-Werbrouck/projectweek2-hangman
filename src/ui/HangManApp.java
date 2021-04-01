package ui;

import domain.HangMan;
import domain.Speler;
import db.domain.WoordenLijst;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HangManApp {
    private HBox hbox= new HBox();
    private HBox label = new HBox();
    private HBox invoerBox = new HBox();
    private HBox uitvoer = new HBox();

    private Text hintwoordUitvoer = new Text();
    private Label invoerLetterLabel = new Label("Geef een letter:");
    private TextField invoerLetter = new TextField();
    private HangMan hangman ;

    private TekenVenster tekening;
    private Pane pane = new Pane();
    private int aantal = 0;


    public HangManApp(VBox root, Speler speler, WoordenLijst woordenlijst) {
        this.hangman = new HangMan(speler, woordenlijst);
        this.tekening = new TekenVenster(pane,this.hangman.getTekening());

        hintwoordUitvoer.setText(this.hangman.getHint());
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        Text uitvoer1 = new Text();
        uitvoer1.setText("Rarara, welk woord zoeken we?");
        hbox.getChildren().add(hintwoordUitvoer);
        invoerBox.getChildren().add(invoerLetter);
        label.getChildren().add(invoerLetterLabel);
        uitvoer.getChildren().add(uitvoer1);

        root.getChildren().addAll(pane, uitvoer, hbox, label, invoerBox);
        root.setLayoutX(10);


        invoerLetter.setOnAction(eventIngaveLetter -> {
            aantal++;
            if (hangman.raad(invoerLetter.getText().charAt(0))) {
                hintwoordUitvoer.setText(this.hangman.getHint());
            }
            else {
                this.tekening = new TekenVenster(pane,this.hangman.getTekening());
            }
            if (hangman.isGewonnen()) {
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                label.getChildren().clear();
                uitvoer.getChildren().clear();
                hintwoordUitvoer.setText("Goed gedaan " + speler.getNaam() + " je hebt het woord geraden in " + aantal + " stappen!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else if (hangman.isGameOver()){
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                label.getChildren().clear();
                uitvoer.getChildren().clear();
                hintwoordUitvoer.setText("Jammer " + speler.getNaam() + " je hebt het woord niet geraden!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else{
                invoerLetter.clear();
            }
        });

    }
}