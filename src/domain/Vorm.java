package domain;

import javafx.scene.paint.Color;

public abstract class Vorm {
    private Color Kleur;
    public  Vorm(Color Kleur){
        setKleur(Kleur);
    }

    public Vorm () {
        this.Kleur = Color.WHITE;
    }

    public void setKleur(Color Kleur){
        if (Kleur==null){
            this.Kleur = Color.WHITE;
        }
        this.Kleur = Kleur;
    }

    public Color getKleur() {
        return Kleur;
    }

    public abstract String toString();
    public abstract Omhullende getOmhullende();
}
