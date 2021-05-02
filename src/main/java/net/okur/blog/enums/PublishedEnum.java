package net.okur.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PublishedEnum {
  P("PUBLISHED"), N("NOT_PUBLISHED"), T("TEMPLATE");

  @Getter
  private final String explanation;
}
