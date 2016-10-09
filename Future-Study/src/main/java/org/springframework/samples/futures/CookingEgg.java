package org.springframework.samples.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class CookingEgg {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1.cooking eggs
        System.out.println("Starting cook eggs.");
      /*  FutureTask<Egg> task = new FutureTask<Egg>(new EggCallable());
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(task);*/

        FutureTask<Egg> task = new FutureTask<Egg>(new EggCallable());
        Executors.newSingleThreadExecutor().execute(task);

        //2.washing with 8 seconds
        System.out.println("Starting washing.");
        Thread.sleep(1000 * 8L);
        System.out.println("washing done");

        while (!task.isDone()){
            System.out.println("cooking status: " + task.isDone());
        }

        System.out.println("cooking done");
        System.out.println(task.get().isHasCooked());
    }

}
