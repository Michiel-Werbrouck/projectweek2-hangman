package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Driehoek extends Vorm {
    private Punt hoekPunt1;
    private Punt hoekPunt2;
    private Punt hoekPunt3;
    private Omhullende omhullende;

    public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
        if (punt1 == punt2 || punt1 == punt3 || punt2 == punt3) {
            throw new IllegalArgumentException();
        }
        if (punt1 == null || punt2 == null || punt3 == null) {
            throw new DomainException("");
        }
        if (liggenOp1Lijn(punt1, punt2, punt3)) {
            throw new DomainException("");
        }

        this.hoekPunt1 = punt1;
        this.hoekPunt2 = punt2;
        this.hoekPunt3 = punt3;

        this.sorteerHoekPunten();

        this.omhullende = new Omhullende(new Punt(hoekPunt1.getX(), hoekPunt3.getY()), hoekPunt3.getX(), hoekPunt3.getY() );
    }

    public Punt getHoekPunt1() {
        return hoekPunt1;
    }

    public Punt getHoekPunt2() {
        return hoekPunt2;
    }

    public Punt getHoekPunt3() {
        return hoekPunt3;
    }

    private boolean liggenOp1Lijn(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
        return ((hoekPunt2.getX() - hoekPunt1.getX()) * (hoekPunt3.getY() - hoekPunt1.getY()) == ((hoekPunt3.getX() - hoekPunt1.getX()) * (hoekPunt2.getY() - hoekPunt1.getY())));
    }

    public void sorteerHoekPunten()
    {
        ArrayList<Punt> punten = new ArrayList<>();
        punten.add(hoekPunt1);
        punten.add(hoekPunt2);
        punten.add(hoekPunt3);
        punten.sort((p1, p2) -> {
            if (p1.getX() != p2.getX()) {
                return Integer.compare(p1.getX(), p2.getX());
            } else {
                return Integer.compare(p1.getY(), p2.getY());
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driehoek driehoek = (Driehoek) o;
        return Objects.equals(hoekPunt1, driehoek.hoekPunt1) &&
                Objects.equals(hoekPunt2, driehoek.hoekPunt2) &&
                Objects.equals(hoekPunt3, driehoek.hoekPunt3);
    }

    @Override
    public String toString() {
        return "Driehoek: " +
                "hoekpunt1: (" + hoekPunt1.getX() + hoekPunt1.getY() +
                ") - hoekpunt2: (" + hoekPunt2.getX() + hoekPunt2.getY() +
                ") - hoekpunt3: (" + hoekPunt3.getX() + hoekPunt3.getY() +
                ')'+ "\n" + omhullende.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        return omhullende;
    }


}
