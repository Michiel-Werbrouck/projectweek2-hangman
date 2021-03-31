package domain;
import javafx.scene.paint.Color;
public class Vorm {
    private Color Kleur;
    public  Vorm(Color Kleur){
        setKleur(Kleur);
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

}
