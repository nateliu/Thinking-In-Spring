package org.springframework.samples.knight;

import java.io.PrintStream;

/**
 * Created by jinlliu on 9/17/2016.
 */
public class SlayDragonQuest implements IQuest {
    private PrintStream out;
    public SlayDragonQuest(PrintStream out) {
        this.out = out;
    }

    @Override
    public void embark() {
        out.println("Embarking on quest to slay the dragon!");
    }
}
