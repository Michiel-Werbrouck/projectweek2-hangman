package domain;

import domain.Punt;

import java.util.Objects;

public class Driehoek extends Vorm {
    private Punt hoekPunt1;
    private Punt hoekPunt2;
    private Punt hoekPunt3;

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

    private void sorteerHoekpunten() {
        Punt hoogstePunt = hoekPunt3;
        Punt middelstePunt = hoekPunt2;
        Punt laagstePunt = hoekPunt1;
        if (hoekPunt1.compareTo(hoekPunt2) == 1) {
            middelstePunt = hoekPunt1;
            laagstePunt = hoekPunt2;

        } else {
            middelstePunt = hoekPunt2;
            laagstePunt = hoekPunt1;
        }
        if (hoogstePunt.compareTo(hoekPunt3) == 1) {
            hoogstePunt = middelstePunt;
            if (laagstePunt.compareTo(hoekPunt3) == 1) {
                middelstePunt = laagstePunt;
                laagstePunt = hoekPunt3;
            } else {
                middelstePunt = hoekPunt3;
            }
        } else {
            hoogstePunt = hoekPunt3;
        }
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
                ')';
    }
}
