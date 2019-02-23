package programowanie_zaawansowane.exercise2.todo;

import java.time.LocalDate;

public class OptionalDemo {

  public static void main(String[] args) {
    //Zadanie bez daty deadline
    TextTask task1 = new TextTask(null,"Zadanie");
    //Co zwracają metody obliczające ile dni zostało do dealine'u, gdy go brak?

    //Metoda zwracająca typ prosty int
    System.out.println("Zostało: " + task1.getDaysToDeadline());

    //Meoda zwracająca typ opakowujący Integer
    System.out.println("Zostało: " + task1.getDaysToDeadlineInteger());

    //Metoda zwracająca typ Optional
    System.out.println("Zostało: " + task1.getDaysToDeadlineOptional());


    //Zdanie z podanymm deadline'm
    TextTask task2 = new TextTask(LocalDate.of(2019,2,20),"Zdanie");

    //Metoda zwracająca typ prosty int
    System.out.println("Zostało: " + task2.getDaysToDeadline());

    //Meoda zwracająca typ opakowujący Integer
    System.out.println("Zostało: " + task2.getDaysToDeadlineInteger());

    //Metoda zwracająca typ Optional
    System.out.println("Zostało: " + task2.getDaysToDeadlineOptional().get());

    //wykorzystanie Optional
    task1.getDaysToDeadlineOptional().ifPresent(a -> System.out.println("Zostało "+a+" dni"));
    task2.getDaysToDeadlineOptional().ifPresent(a -> System.out.println("Zostało "+a+" dni"));
  }
}
