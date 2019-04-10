package jdbchibernate.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "message")
public class MyMessage implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "text", unique = false, nullable = true)
  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}