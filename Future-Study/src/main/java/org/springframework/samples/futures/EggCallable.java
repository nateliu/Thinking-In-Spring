package org.springframework.samples.futures;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class EggCallable implements Callable<Egg> {
    @Override
    public Egg call() throws Exception {
        Thread.sleep(1000 * 10L);  //10 second with cook egg.
        return new Egg(true);
    }
}
