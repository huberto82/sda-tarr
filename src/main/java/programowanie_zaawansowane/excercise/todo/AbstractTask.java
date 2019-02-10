package programowanie_zaawansowane.excercise.todo;

import java.time.LocalDate;

abstract public class AbstractTask {
  private final LocalDate created;
  private final LocalDate deadline;
  private LocalDate completed;

  public AbstractTask(LocalDate deadline) {
    this.deadline = deadline;
    created = LocalDate.now();
  }

  public LocalDate getCreated() {
    return created;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public LocalDate getCompleted() {
    return completed;
  }

  public void setCompleted(LocalDate completed) {
    this.completed = completed;
  }

  public boolean isDone(){
    /*
    if (completed != null)
      return true;
    return false;
    */
    return completed != null;
  }

  public boolean isDoneBeforeDeadline(){
    if (!isDone())
      return false;
    return completed.isBefore(deadline);
  }

  abstract public Object getContent();

}
