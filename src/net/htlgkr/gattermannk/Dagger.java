package net.htlgkr.gattermannk;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

public class Dagger {

    private boolean isOccupied;
    private Lock daggerLocker;

    public Dagger(Lock daggerLocker) {
        this.daggerLocker = daggerLocker;
        this.isOccupied = false;
    }

    public void occupy(){
        daggerLocker.lock();
        isOccupied = true;
    }

    public void release(){
        //if(!isOccupied) return;
        isOccupied = false;
        daggerLocker.unlock();
    }

    public boolean isOccupied(){
        return isOccupied;
    }

}
