package net.okur.blog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 15, nullable = false, unique = true)
  private String username;

  @Column(length = 100, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String surname;

  @Column(name = "profile_info", length = 300)
  private String profileInfo;

  @Column(name = "last_logged_in_time", columnDefinition = "DATE")
  private LocalDateTime lastLoggedInTime;

  @Column(name = "last_password_change", columnDefinition = "DATE")
  private LocalDateTime lastPasswordChange;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
  private Set<Post> posts;

  public User(Long id, String username) {
    this.id = id;
    this.username = username;
  }
}
