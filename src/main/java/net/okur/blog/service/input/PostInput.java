package net.okur.blog.service.input;

import java.time.LocalDateTime;

import lombok.Data;
import net.okur.blog.enums.PublishedEnum;

@Data
public class PostInput {
  private String title;
  private String metaTitle;
  private String slug;
  private String summary;
  private PublishedEnum published;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime publishedAt;
  private String content;
  private String authorUsername;

}
