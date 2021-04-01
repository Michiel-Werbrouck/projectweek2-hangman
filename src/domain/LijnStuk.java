package domain;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.Objects;
import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable{
    private Punt startPunt;
    private Punt eindPunt;
    private Omhullende omhullende;

    public LijnStuk(Punt startPunt, Punt eindPunt){
        setStartPuntEnEindPunt(startPunt, eindPunt);
        this.omhullende = new Omhullende(this.getLinkerBovenHoek(),
                Math.max(startPunt.getX(), eindPunt.getX())
                        - Math.min(startPunt.getX(), eindPunt.getX()),
                Math.max(startPunt.getY(),
                        eindPunt.getY()) - Math.min(startPunt.getY(), eindPunt.getY()));
    }

    public Punt getLinkerBovenHoek() {
        return new Punt(Math.min(startPunt.getX(), eindPunt.getX()),
                Math.min(startPunt.getY(), eindPunt.getY()));
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public void setStartPuntEnEindPunt(Punt startPunt, Punt eindPunt) {
        if (startPunt==null || eindPunt==null){
            throw new DomainException("Start en eindpunt mag niet null zijn.");
        }
        if (startPunt==eindPunt){
            throw new DomainException("Start en eindpunt mag niet gelijk zijn.");
        }
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijnStuk lijnStuk = (LijnStuk) o;
        return Objects.equals(startPunt, lijnStuk.startPunt) &&
                Objects.equals(eindPunt, lijnStuk.eindPunt);

    }

    @Override
    public int hashCode() {
        return Objects.hash(startPunt, eindPunt);
    }

    @Override
    public String toString() {
        return "Lijn: startpunt: " + startPunt + " - eindPunt: " + eindPunt + "\n" + omhullende.toString();
    }


    @Override
    public Omhullende getOmhullende() {
        return omhullende;
    }

    @Override
    public void teken(Pane root) {

        Line line = new Line(startPunt.getX(),startPunt.getY(),eindPunt.getX(),eindPunt.getY());
        line.setStrokeWidth(5);
        root.getChildren().add(line);

    }
}
