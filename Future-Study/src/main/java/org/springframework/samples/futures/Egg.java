package org.springframework.samples.futures;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class Egg {
    private boolean hasCooked;

    public Egg(boolean hasCooked) {
        this.hasCooked = hasCooked;
    }

    public boolean isHasCooked() {
        return hasCooked;
    }
}
