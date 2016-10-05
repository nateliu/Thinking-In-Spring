package org.springframework.samples.repositories;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.samples.models.Spittle;
import org.springframework.samples.models.Spittler;

import java.util.List;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public interface ISpittleRepository {
    List<Spittle> finSpittles(long max, int count);
    Spittle finOne(long id);

    Spittler save(Spittler spittler);
    Spittler finByUserName(String userName);
}
