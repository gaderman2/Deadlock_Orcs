package net.htlgkr.gattermannk;

import java.util.Objects;

public class Dagger {

    private boolean isOccupied;
    private int id;

    public Dagger(int id) {
        this.id = id;
        this.isOccupied = false;
    }

    public void setOccupied(boolean occupied){
        this.isOccupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dagger dagger = (Dagger) o;
        return isOccupied == dagger.isOccupied && id == dagger.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOccupied, id);
    }
}
