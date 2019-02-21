package programowanie_zaawansowane.excercise2.todo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TextTaskTest {

  @Test
  void isDone() {
    TextTask task = new TextTask(LocalDate.of(2019,2,20),"Zadanie 1");
    assertEquals(false, task.isDone(),"Metoda powinna zwrócić false");
    task.setCompleted(LocalDate.of(2019, 2,19));
    assertEquals(true, task.isDone(),"Metoda powinna zwrócić true");
  }

  @Test
  void isDoneBeforeDeadline() {
    TextTask task = new TextTask(LocalDate.of(2019,2,20),"Zadanie 1");
    assertEquals(false, task.isDoneBeforeDeadline(),"Brak daty zakończenia, false");
    task.setCompleted(LocalDate.of(2019, 2,19));
    assertEquals(true, task.isDoneBeforeDeadline(),"Data zakończenia przed deadline, true");
    task.setCompleted(LocalDate.of(2019, 2,21));
    assertEquals(false, task.isDoneBeforeDeadline(),"Data zakończenia po deadline, false");
    task.setCompleted(LocalDate.of(2019, 2,20));
    assertEquals(true, task.isDoneBeforeDeadline(),"Data zakończenia równa deadline, true");
  }


  @Test
  void getDaysToDeadline() {
    LocalDate now = LocalDate.now();
    LocalDate after = now.plusMonths(1);
    LocalDate befor = now.minusMonths(1);

    //Deadline jest null
    TextTask task = new TextTask(null,"Zadanie 1");
    assertEquals(Integer.MAX_VALUE, task.getDaysToDeadline(),"Brak daty deadline, MAX_VALUE");

    //Deadline jest po bieżącej dacie
    task = new TextTask(befor,"Zadanie 1");
    assertEquals(task.getDeadline().toEpochDay()-now.toEpochDay(), task.getDaysToDeadline(),"Przed deadline, wartość dodatnia");

    //deadline jest przed bieżącą datą
    task = new TextTask(after,"Zadanie 1");
    assertEquals(task.getDeadline().toEpochDay()-now.toEpochDay(), task.getDaysToDeadline(),"Po deadline, wartość ujemna");

    //deadline jest dzisiaj
    task = new TextTask(now,"");
    assertEquals(task.getDeadline().toEpochDay()-now.toEpochDay(), task.getDaysToDeadline(),"Deadline jest dzisiaj, wartość O");
  }
}