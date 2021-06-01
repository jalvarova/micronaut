package org.ht.com.pe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.ht.com.pe.util.ConvertUtil;
import org.ht.com.pe.util.DateSerializable;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

import static org.ht.com.pe.util.ConvertUtil.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Schedule {

    private ObjectId _id;

    private String scheduleOrder;

    private String scheduleName;


    @FutureOrPresent(message = "Fecha debe de ser presente o futuro")
    @JsonDeserialize(using = DateSerializable.class)
    @JsonFormat(pattern = DATE_FORMAT)
    private LocalDateTime scheduleDate;

    private String subject;

    private String email;

    private String adviser;

    private String remark;

    private String resolve;

    private String documentResolve;

}
