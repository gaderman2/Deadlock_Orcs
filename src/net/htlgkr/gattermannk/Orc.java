package net.htlgkr.gattermannk;

import java.time.LocalTime;
import java.util.concurrent.locks.ReentrantLock;

public class Orc extends Thread {

    private Dagger rightDagger;
    private Dagger leftDagger;

    private String name;

    private static ReentrantLock grabLock = new ReentrantLock();

    public Orc(String name, Dagger rightDagger, Dagger leftDagger) {
        this.name = name;
        this.rightDagger = rightDagger;
        this.leftDagger = leftDagger;
    }

    @Override
    public void run() {
        boolean shouldDrink = true;
        while (true) {
            try {
                if(shouldDrink) drinking();
                shouldDrink = false;

                grabLock.lock();
                try {
                    if (!grabDaggers()) {
                        //debug("Continued loop");
                        //Thread.sleep(1);
                        continue;
                    }
                }finally {
                    grabLock.unlock();
                }

                feasting();
                shouldDrink = true;

                releaseRightDagger();
                releaseLeftDagger();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void drinking() throws InterruptedException {
        debug("Is drinking now...");
        Thread.sleep((long) (Math.random() * 3000) + 3000);
    }

    private boolean grabDaggers() {
        if(rightDagger.isOccupied() || leftDagger.isOccupied()) return false;

        rightDagger.occupy();
        leftDagger.occupy();
        debug("Both daggers grabbed");
        return true;
    }

    private void feasting() throws InterruptedException {
        debug("Is having a feast");
        Thread.sleep((long) (Math.random() * 8000) + 5000);
    }

    private void releaseRightDagger() {
        rightDagger.release();
        debug("Right dagger released");
    }

    private void releaseLeftDagger() {
        leftDagger.release();
        debug("Left dagger released");
    }

    private void debug(String message){
        System.out.println(LocalTime.now() + " | " + name + ": " + message);
    }

}
