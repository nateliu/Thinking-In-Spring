package org.springframework.samples.repositories;

import org.springframework.samples.models.Spittle;

import java.util.List;

/**
 * Created by Administrator on 2016/10/4 0004.
 */
public interface ISpittleRepository {
    List<Spittle> finSpittles(long max, int count);
}
