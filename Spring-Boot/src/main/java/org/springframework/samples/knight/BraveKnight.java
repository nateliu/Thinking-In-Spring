package org.springframework.samples.knight;

/**
 * Created by jinlliu on 9/17/2016.
 */
public class BraveKnight implements IKnight {
    private IQuest quest;

    public BraveKnight(IQuest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
