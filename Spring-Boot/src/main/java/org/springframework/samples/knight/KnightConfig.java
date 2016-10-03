package org.springframework.samples.knight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by jinlliu on 9/17/2016.
 */
@Configuration
@EnableAspectJAutoProxy
public class KnightConfig {
    @Bean
    public IKnight knight(){
        return new BraveKnight(quest());
    }

    @Bean
    public IQuest quest(){
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel(){
        return new Minstrel(System.out);
    }
}
