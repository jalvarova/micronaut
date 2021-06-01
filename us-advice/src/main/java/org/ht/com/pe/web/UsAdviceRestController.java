package org.ht.com.pe.web;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.ht.com.pe.model.Schedule;
import org.ht.com.pe.model.ScheduleRepository;

import javax.inject.Inject;

@Controller("/api/v1")
public class UsAdviceRestController {

    @Inject
    private ScheduleRepository scheduleRepository;

    @Get(uri = "/advice/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Single<?> findById(@PathVariable("id") String id) {
        return scheduleRepository.findById(id);
    }

    @Get(uri = "/advices", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Observable<?> findByAll() {
        return scheduleRepository.findByAll();
    }

    @Post(uri = "/advice", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Single<?> save(@Body Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Put(uri = "/advice/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public Single<?> update(@PathVariable("id") String id, @Body Schedule schedule) {
        return scheduleRepository.update(id, schedule);
    }
}