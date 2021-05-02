package net.okur.blog.service.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import net.okur.blog.service.mapper.utils.LocalDateFormatter;
import net.okur.blog.service.mapper.utils.LocalDateTimeFormatter;

@Component
public class ServiceMapper extends ConfigurableMapper {
  @Override
  protected void configure(MapperFactory factory) {
    factory.getConverterFactory().registerConverter(new LocalDateFormatter());
    factory.getConverterFactory().registerConverter(new LocalDateTimeFormatter());
  }
}
