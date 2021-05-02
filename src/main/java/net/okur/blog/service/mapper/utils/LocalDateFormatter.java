package net.okur.blog.service.mapper.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.ObjectUtils;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class LocalDateFormatter extends BidirectionalConverter<LocalDate, String> {
  @Override
  public String convertTo(LocalDate localDate, Type<String> type, MappingContext mappingContext) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return localDate == null ? "" : localDate.format(dateTimeFormatter);
  }

  @Override
  public LocalDate convertFrom(String stringDate, Type<LocalDate> type, MappingContext mappingContext) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return ObjectUtils.isEmpty(stringDate) ? null : LocalDate.parse(stringDate, dateTimeFormatter);
  }
}
