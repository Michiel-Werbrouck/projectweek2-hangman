package domain;


import java.util.Objects;

public class Cirkel extends Vorm {
    private Punt middelpunt;
    private int radius;
    private Omhullende omhullende;


    public Cirkel(Punt middelpunt, int radius){
        if(middelpunt == null){
            throw new DomainException("middelpunt mag niet leeg zijn");
        }
        this.middelpunt = middelpunt;

        if(radius <= 0 ){
            throw new DomainException("radius moet groter zijn als 0");
        }
        this.radius = radius;

        this.omhullende = new Omhullende(new Punt(middelpunt.getX()-radius, middelpunt.getY()-radius),radius*2,radius*2);
    }

    private void setMiddelpunt(Punt middelpunt) {
        this.middelpunt = middelpunt;
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

   public int getRadius() {
        return radius;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cirkel cirkel = (Cirkel) o;
        return radius == cirkel.radius &&
                Objects.equals(middelpunt, cirkel.middelpunt);
    }


    public String toString() {
        return "Cirkel: middelpunt: (" + this.getMiddelpunt().getX() + ", " + this.getMiddelpunt().getY() + ") - straal: " + this.getRadius() + "\n" + omhullende.toString();
   }

    @Override
    public Omhullende getOmhullende() {
        return omhullende;
    }
}
