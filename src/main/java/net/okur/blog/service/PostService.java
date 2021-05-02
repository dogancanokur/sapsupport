package net.okur.blog.service;

import java.util.List;

import net.okur.blog.service.input.PostInput;
import net.okur.blog.service.output.PostOutput;

public interface PostService {
  List<PostOutput> findAllByAuthorUsername(String authorUsername);

  PostOutput save(PostInput postInput);

  PostOutput findBySlug(String slug);

}
