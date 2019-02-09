package programowanie_zaawansowane.excercise.todo;


import java.io.Serializable;
import java.time.LocalDate;

public class SimpleTask extends AbstractTask implements Serializable {
  private static final long serialVersionUID = 7153163831571434056L;

  public SimpleTask(String content, LocalDate deadline) {
    super(content, deadline);
  }

  @Override
  public String get() {
    return getContent() +" " + getCreation() +" "+getDeadline()+ " "+isDone();
  }

  public void setAsDone(){
    this.setDone(true);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}