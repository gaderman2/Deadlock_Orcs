package net.htlgkr.gattermannk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Orc> orcList = new ArrayList<>();
        List<Dagger> daggerList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            daggerList.add(new Dagger(i));
        }

        for(int i = 0; i < 5; i++){
            int x = i + 1 < daggerList.size() ? i + 1 : 0;
            int y = i - 1 > 0 ? i - 1 : daggerList.size() - 1;

            orcList.add(new Orc("Orc-" + i, daggerList.get(x), daggerList.get(y)));
        }

        orcList.forEach(Thread::start);
    }

}
