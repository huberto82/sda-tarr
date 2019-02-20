package programowanie_zaawansowane.c5_equals;

import java.time.LocalDate;
import java.util.Random;

public class EqualsDemo {

  static Random rand = new Random();

  static Person getRandomPerson(){
    return new Person(getRandomString(), getRandomString(), LocalDate.ofEpochDay(rand.nextInt(100000)));
  }

  static String getRandomString(){
    StringBuffer str = new StringBuffer();
    for(int i = 0; i < 3 + rand.nextInt(10); i++){
      str.append((char)('a' + rand.nextInt('z'-'a')));
    }
    return str.toString();
  }

  public static void main(String[] args) {
    Person a = new Person("Adam","Nowak", LocalDate.of(1998, 12,23));
    Person b = new Person("ADAM","nowak", LocalDate.of(1998, 12,23));
    Person c = new Person("Adam","Nowak", LocalDate.of(1998, 12,23));
    System.out.println("Różne obiekty: "+ a + " " + b);
    System.out.println("equals - " + a.equals(b));
    System.out.println("równość hashCode - " + (a.hashCode() == b.hashCode()));
    System.out.println("Identyczne obiekty "+ a + " " + c);
    System.out.println("equals - " + a.equals(c));
    System.out.println("równość hashCode - " + (a.hashCode() == c.hashCode()));

    User u1 = new User("ADAM", "1245Hj");
    User u2 = new User("Adam", "1245rg");
    System.out.println("Różne obiekty " + u1 + " " + u2);
    System.out.println("equals - " + u1.equals(u2));
    System.out.println("równość hashCode - " + (u1.hashCode() == u2.hashCode()));
  }
}
