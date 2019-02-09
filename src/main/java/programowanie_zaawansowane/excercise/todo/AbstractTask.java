package programowanie_zaawansowane.excercise.todo;

import java.io.Serializable;
import java.time.LocalDate;

abstract public class AbstractTask implements Serializable {
  private static final long serialVersionUID = 2153163831571434056L;
  private final String content;
  private boolean isDone;
  private final LocalDate creation;
  private LocalDate deadline;
  private LocalDate completed;

  public AbstractTask(String content, LocalDate deadline) {
    this.content = content;
    this.creation = LocalDate.now();
    this.deadline = deadline;
    this.isDone = false;
  }

  abstract public String get();

  public String getContent() {
    return content;
  }

  public boolean isDone() {
    return isDone;
  }

  public LocalDate getCreation() {
    return creation;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public LocalDate getCompleted() {
    return completed;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  protected void setDone(boolean done) {
    isDone = done;
  }

  protected void setCompleted(LocalDate completed) {
    this.completed = completed;
  }

  @Override
  public String toString() {
    return content + " " + isDone + " " + creation + " " + deadline + " " + completed;
  }
}

