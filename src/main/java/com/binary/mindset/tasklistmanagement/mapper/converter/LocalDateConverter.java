package com.binary.mindset.tasklistmanagement.mapper.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.sql.Timestamp;
import java.time.LocalDate;

public class LocalDateConverter extends BidirectionalConverter<LocalDate, Timestamp> {

    public final static String LOCALDATE_TO_TIMESTAMP_CONVERTER_ID = "LocalDate to timestamp converter";

    @Override
    public Timestamp convertTo(LocalDate localDate, Type<Timestamp> type, MappingContext mappingContext) {
        return Timestamp.valueOf(localDate.atStartOfDay());
    }

    @Override
    public LocalDate convertFrom(Timestamp timestamp, Type<LocalDate> type, MappingContext mappingContext) {
        return timestamp.toLocalDateTime().toLocalDate();
    }
}
