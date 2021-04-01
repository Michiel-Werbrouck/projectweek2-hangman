package ui;

import domain.*;
import javafx.scene.layout.Pane;

import java.awt.*;


public class TekenVenster {
    private Tekening tekening;



    public TekenVenster(Pane root, Tekening tekening){
        if (tekening == null) throw new UiException();
        this.tekening = tekening;
        this.teken(root);
    }

    public void teken(Pane root) {
        tekening.teken(root);
    }
}