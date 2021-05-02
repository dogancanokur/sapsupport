package net.okur.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.okur.blog.model.Post;
import net.okur.blog.model.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByAuthor(User author);

  Post findBySlug(String slug);

}
