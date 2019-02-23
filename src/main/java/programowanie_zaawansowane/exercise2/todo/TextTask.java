package programowanie_zaawansowane.exercise2.todo;

import java.io.Serializable;
import java.time.LocalDate;

public class TextTask extends AbstractTask implements Serializable {
  private static final long serialVersionUID = 2153163838571434056L;

  private final String content;

  public TextTask(LocalDate deadline, String content) {
    super(deadline);
    this.content = content;
  }

  @Override
  public Object getContent() {
    return content;
  }

  @Override
  public String toString() {
    return content +" "+ super.toString();
  }
}
