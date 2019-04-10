package podstawowa.date;


import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate payment = LocalDate.of(1999,10, 23);
        Period period = Period.between(payment, LocalDate.now());
        System.out.println(period);
        System.out.println(LocalDate.now().toEpochDay() - payment.toEpochDay());
        System.out.println(period.toTotalMonths());
    }
}
