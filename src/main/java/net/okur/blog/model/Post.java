package net.okur.blog.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.okur.blog.enums.PublishedEnum;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "post")
public class Post implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "title", length = 25)
  private String title;

  @Column(name = "meta_title")
  private String metaTitle;

  @Column(name = "slug", length = 25)
  private String slug;

  @Column(name = "summary", length = 120)
  private String summary;

  @Column(name = "published", length = 1)
  @Enumerated(EnumType.STRING)
  private PublishedEnum published;

  @Column(name = "created_at", columnDefinition = "DATE")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "DATE")
  private LocalDateTime updatedAt;

  @Column(name = "published_at", columnDefinition = "DATE")
  private LocalDateTime publishedAt;

  @Column(name = "content", length = 5000)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "FK_AUTHOR_ID"))
  private User author;
}
