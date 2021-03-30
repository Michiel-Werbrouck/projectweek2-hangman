package domain;

import java.util.Objects;

public class Omhullende {

    private Punt linkerbovenhoek;
    private int breedte, hoogte;

    public Omhullende(Punt linkerbovenhoek, int breedte, int hoogte) {
        if (linkerbovenhoek == null)
            throw new DomainException("Linkerbovenhoek mag niet leeg zijn.");

        if (breedte < 0 || hoogte < 0)
            throw new DomainException("Breedte en hoogte mogen niet negatief zijn.");

        this.linkerbovenhoek = linkerbovenhoek;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerbovenhoek;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getMinimumX() {
        return linkerbovenhoek.x;
    }

    public int getMinimumY() {
        return linkerbovenhoek.y;
    }

    public int getMaximumX() {
        return linkerbovenhoek.x + breedte;
    }

    public int getMaximumY() {
        return linkerbovenhoek.y + hoogte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Omhullende that = (Omhullende) o;
        return breedte == that.breedte && hoogte == that.hoogte && Objects.equals(linkerbovenhoek, that.linkerbovenhoek);
    }

    @Override
    public String toString() {
        return "Omhullende: " + linkerbovenhoek.toString() + " - " + breedte + " - " + hoogte;
    }
}
