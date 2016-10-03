package org.springframework.samples.knight;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by jinlliu on 9/17/2016.
 */
public class BraveKnightTest {
    @Test
    public void embarkOnQuest() throws Exception {
        IQuest mockQuest = Mockito.mock(IQuest.class);
        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();
        verify(mockQuest,times(1)).embark();
    }

}