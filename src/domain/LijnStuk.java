package domain;

import java.awt.*;
import java.util.Objects;

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
    public void teken(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));
        graphics.drawLine(this.startPunt.getX(), this
                .startPunt.getY(), this.eindPunt.getX(), this
                .eindPunt.getY());

    }
}
