package domain;


import java.util.Objects;

public class Cirkel {
    private Punt middelpunt;
    private int radius;


    public Cirkel(Punt middelpunt, int radius){
        if(middelpunt == null){
            throw new IllegalArgumentException();
        }
        this.middelpunt = middelpunt;

        if(radius <= 0 ){
            throw new IllegalArgumentException();
        }
        this.radius = radius;
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
        return "Cirkel: middelpunt: (" + this.getMiddelpunt().getX() + ", " + this.getMiddelpunt().getY() + ") - straal: " + this.getRadius();
   }

}
