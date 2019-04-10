package jdbchibernate.entity;

import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, unique = true)
  long id;

  @Column(name="title", nullable = false)
  String title;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  Author author;

  @Column(name="content")
  String content;

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
