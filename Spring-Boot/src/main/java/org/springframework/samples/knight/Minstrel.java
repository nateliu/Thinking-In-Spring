package org.springframework.samples.knight;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.PrintStream;

/**
 * Created by jinlliu on 9/17/2016.
 */
@Aspect
public class Minstrel {
    private PrintStream out;

    public Minstrel(PrintStream out) {
        this.out = out;
    }

    @Pointcut("execution(** com.spring.thinking.knight.IKnight.embarkOnQuest(..))")
    public void AspectPointCut() {
    }

    @Before("AspectPointCut()")
    public void singBeforeQuest() {
        out.println("The knight is so brave.");
    }

    @After("AspectPointCut()")
    public void singAfterQuest() {
        out.println("The brave knight did the embark on a quest.");
    }
}
