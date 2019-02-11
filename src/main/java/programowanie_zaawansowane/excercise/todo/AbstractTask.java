package programowanie_zaawansowane.excercise.todo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

abstract public class AbstractTask implements Serializable {
  private static final long serialVersionUID = 2153163831571434056L;

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
    return completed.isBefore(deadline) || completed.equals(deadline);
  }

  abstract public Object getContent();

  public int getDaysToDeadline(){
    if (deadline == null)
      return Integer.MAX_VALUE;
    return (int) (deadline.toEpochDay() - LocalDate.now().toEpochDay());
  }

  public Optional<Integer> getDaysToDeadlineOptional(){
    return  deadline==null? Optional.empty(): Optional.ofNullable((int) (deadline.toEpochDay() - LocalDate.now().toEpochDay()));
  }
  public Integer getDaysToDeadlineInteger(){
    if (deadline == null)
      return null;
    return (int) (deadline.toEpochDay() - LocalDate.now().toEpochDay());
  }

  @Override
  public String toString() {
    return "created=" + created +
            ", deadline=" + deadline +
            ", completed=" + completed;
  }
}
