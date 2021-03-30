package domain;

import java.util.Objects;

public class Punt {
   public int x;
   public int y;

   public Punt(int x, int y){
       this.x = x;
       this.y = y;
   }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return x == punt.x &&
                y == punt.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
