package org.springframework.samples.repositories;

import org.springframework.samples.models.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
@Component
public class SpittleRepository implements ISpittleRepository {
    @Override
    public List<Spittle> finSpittles(long max, int count) {
        return createSpittleList(20);
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date(),(double)100*(i+3), (double)100*(i+7)));
        }
        return spittles;
    }
}
