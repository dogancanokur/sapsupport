package net.okur.blog.service.mapper.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.util.ObjectUtils;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class LocalDateTimeFormatter extends BidirectionalConverter<LocalDateTime, String> {

  @Override
  public String convertTo(LocalDateTime localDateTime, Type<String> type, MappingContext mappingContext) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
    return localDateTime == null ? "" : localDateTime.format(dateTimeFormatter);

  }

  @Override
  public LocalDateTime convertFrom(String localDateTime, Type<LocalDateTime> type, MappingContext mappingContext) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
    return ObjectUtils.isEmpty(localDateTime) ? null : LocalDateTime.parse(localDateTime, dateTimeFormatter);

  }
}
