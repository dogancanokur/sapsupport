package net.okur.blog.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.okur.blog.enums.PublishedEnum;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
@NoArgsConstructor
public class PostComment implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 60)
  private String title;

  @Column(name = "author_email", length = 100, nullable = false)
  private String authorEmail;

  @Column(length = 15, nullable = false)
  private String username;

  @Column(name = "published", length = 1)
  @Enumerated(EnumType.STRING)
  private PublishedEnum published;

  @Column(name = "created_at", columnDefinition = "DATE")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "DATE")
  private LocalDateTime updatedAt;

  @Column(name = "published_at", columnDefinition = "DATE")
  private LocalDateTime publishedAt;

  @Column(name = "content", length = 200)
  private String content;

}
