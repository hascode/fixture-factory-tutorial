package com.hascode.tutorial.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
  private Long id;
  private String title;
  private List<Author> authors = new ArrayList<>();
  private Date created;

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Author> getAuthors() {
    return new ArrayList<>(authors);
  }

  public void setAuthors(List<Author> authors) {
    this.authors = new ArrayList<>(authors);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Book{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", authors=").append(authors);
    sb.append(", created=").append(created);
    sb.append('}');
    return sb.toString();
  }
}
