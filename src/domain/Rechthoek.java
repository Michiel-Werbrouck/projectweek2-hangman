package domain;

import java.util.Objects;

public class Rechthoek extends Vorm {
    private int breedte;
    private int hoogte;
    private Punt linkerBovenhoek;
    private Omhullende omhullende;

    public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte){
        if(breedte <= 0){
            throw new DomainException("De breedte mag niet negatief zijn");
        }
        this.breedte = breedte;

        if(hoogte <= 0){
            throw new DomainException("De hoogte mag niet negatief zijn");
        }
        this.hoogte = hoogte;

        if(linkerBovenhoek == null){
            throw new DomainException("Er moet een linker bovenhoek zijn");
        }
        this.linkerBovenhoek = linkerBovenhoek;

        this.omhullende = new Omhullende(linkerBovenhoek, breedte, hoogte);
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rechthoek rechthoek = (Rechthoek) o;
        return breedte == rechthoek.breedte &&
                hoogte == rechthoek.hoogte &&
                Objects.equals(linkerBovenhoek, rechthoek.linkerBovenhoek);
    }

    @Override
    public String toString() {
        return "Rechthoek: positie: " + linkerBovenhoek.toString() + " - breedte: " + breedte + " - hoogte: " + hoogte
                + "\n" + omhullende.toString();
    }

    @Override
    public Omhullende getOmhullende() {
        return omhullende;
    }
}
