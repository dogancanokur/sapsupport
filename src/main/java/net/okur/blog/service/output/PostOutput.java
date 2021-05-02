package net.okur.blog.service.output;

import lombok.Data;
import net.okur.blog.enums.PublishedEnum;

@Data
public class PostOutput {
  private String title;
  private String metaTitle;
  private String slug;
  private String summary;
  private PublishedEnum published;
  private String content;
  private String authorUsername;
}
