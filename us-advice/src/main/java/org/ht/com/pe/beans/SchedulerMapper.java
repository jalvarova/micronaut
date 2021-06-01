package org.ht.com.pe.beans;

import org.ht.com.pe.model.Schedule;

import java.time.LocalDateTime;

import static org.ht.com.pe.util.ConvertUtil.generatedId;

public final class SchedulerMapper {

    public static Schedule scheduleBuild() {
        return Schedule.builder()
                .scheduleOrder(generatedId())
                .scheduleName("atten-error-disk")
                .scheduleDate(LocalDateTime.now())
                .subject("Alvaro Aguinaga")
                .email("alvarodaniel2808@gmail.com")
                .adviser("walavo")
                .remark("Error al iniciar el SO Windows")
                .resolve("-")
                .documentResolve("-")
                .build();
    }
}
