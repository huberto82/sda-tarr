package programowanie_zaawansowane.c6_assert;

import java.util.Scanner;

/**
 * Demonstracja wykorzystania asercji
 * assert warunek;
 * assert warunek:wartość; - dodatkowa informacja
 * Należy korzystać tylko do sprawdzania założeń we własnych klasach
 * Gdy są aktywne zgłaszają wyjątek AssertionError dla warunku równego false
 * Asercje nieaktywne są ignorowane i nie wpływają na kod
 * Aby uaktywnić asercje należy włączyć odpowiednią opcję VM
 * w menu Run->EditConfiguration w polu VM options wpisać -ea (lub -enableassertions)
 */
public class AssertDemo {

  static Scanner scan = new Scanner(System.in);

  public static int getNumber(){
    int number = scan.nextInt();
    //zakładamy, że numer nie może być ujemny
    assert number > 0 : number; //dodanie wartości zmiennej number do komunikatu assercji
    return number;
  }

  public static String getString(){
    scan.nextLine();
    String str = scan.nextLine();
    //zakładamy, że łacuch zawiera znaki
    assert str.length() > 0;
    return str;
  }

  public static void main(String[] args) {
    System.out.println("Wpisz liczbę nieujemną: ");
    int count = getNumber();
    System.out.println("Wpisz imie: ");
    String name = getString();
    System.out.println(count);
    while(count-- > 0){
      System.out.println(name);
    }
  }
}
