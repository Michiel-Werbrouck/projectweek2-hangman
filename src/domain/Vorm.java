package domain;
import javafx.scene.paint.Color;
public abstract class Vorm {
    private Color Kleur;



    public void setKleur(Color Kleur){
        if (Kleur==null){
            this.Kleur = Color.WHITE;
        }
        this.Kleur = Kleur;
    }


    public abstract String toString();



    public Color getKleur() {
        return Kleur;
    }

    public abstract Omhullende getOmhullende();

}
