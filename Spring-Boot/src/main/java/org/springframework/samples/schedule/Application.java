package org.springframework.samples.schedule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.samples.knight.IKnight;
import org.springframework.samples.knight.IQuest;
import org.springframework.samples.knight.KnightConfig;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {
//		SpringApplication.run(Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        IQuest quest = context.getBean(IQuest.class);
        IKnight knight = context.getBean(IKnight.class, quest);
        knight.embarkOnQuest();
    }
}
