package domain;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Tekening implements Drawable {
    private String naam;
    private ArrayList<Vorm> vormen = new ArrayList<>(0);
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MAX_X = 399;
    public static final int MAX_Y = 399;

    public Tekening(String naam){
        if(isValidNaam(naam)){
            this.naam = naam;
        }
    }

    public static boolean isValidNaam(String naam){
        if (naam==null || naam.trim().isEmpty()){
            throw new IllegalArgumentException("naam mag niet leeg zijn.");
        }
        return true;
    }

    public String getNaam() {
        return naam;
    }

    public void voegToe(Vorm v) {
        if (v == null) {
            throw new DomainException("");
        }

        if (!(v.getOmhullende().getMinimumX() >= MIN_X && v.getOmhullende().getMinimumY() >= MIN_Y &&
                v.getOmhullende().getMaximumX() <= MAX_X && v.getOmhullende().getMaximumY() <= MAX_Y)) {
            throw new DomainException("Vorm niet binnen grenzen");
        }
        vormen.add(v);
    }

    public Vorm getVorm(int index){
        if (index<0 || index>vormen.size()){
            throw new DomainException("geef geldige index.");
        }
        return vormen.get(index);
    }

    public int getAantalVormen(){
        return vormen.size();
    }

    public void verwijder(Vorm vorm){
        if (vormen.contains(vorm)){
            vormen.remove(vorm);
        }
    }

    public boolean bevat(Vorm vorm){
        return vormen.contains(vorm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tekening tekening = (Tekening) o;
        return vormen.containsAll(tekening.vormen) && tekening.vormen.containsAll(vormen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, vormen, MIN_X, MIN_Y, MAX_X, MAX_Y);
    }

    @Override
    public String toString() {
        return "Tekening{" +
                "naam='" + naam + '\'' +
                ", vormen=" + vormen +
                ", MIN_X=" + MIN_X +
                ", MIN_Y=" + MIN_Y +
                ", MAX_X=" + MAX_X +
                ", MAX_Y=" + MAX_Y +
                '}';
    }

    public ArrayList<Vorm> getVormen() {
        return vormen;
    }

    @Override
    public void teken(Pane root) {
        for(Vorm vorm: vormen){
            if(vorm.isZichtbaar()){
                vorm.teken(root);
            }
        }
    }

}
