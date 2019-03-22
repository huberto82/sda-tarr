package podstawowa;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Account {
  String number;
  Long balance;

  public Account(String number, Long balance) {
    this.number = number;
    this.balance = balance;
  }

  public String getNumber() {
    return number;
  }

  public Long getBalance() {
    return balance;
  }
}

class Transaction{
  String uuid;
  Long sum;
  Account account;

  public Transaction(String uuid, Long sum, Account account) {
    this.uuid = uuid;
    this.sum = sum;
    this.account = account;
  }

  public String getUuid() {
    return uuid;
  }

  public Long getSum() {
    return sum;
  }

  public Account getAccount() {
    return account;
  }
}

class LogEntry{
  LocalDate created;
  String login;
  String url;

  public LogEntry(LocalDate created, String login, String url) {
    this.created = created;
    this.login = login;
    this.url = url;
  }

  public LocalDate getCreated() {
    return created;
  }

  public String getLogin() {
    return login;
  }

  public String getUrl() {
    return url;
  }
}

public class Task {

  public int solution(String S) {
    int count = 0;
    int l = S.length();
    if (S.length() == 1){
      return 0;
    }
    int i = 0;
    while (S.charAt(i)==S.charAt(l-i-1) && (i != l-i-1)){
      count++;
      i++;
    }
    return count;
  }

  static Function<Integer, Function<Integer , Function<Integer ,Integer>>> fun(){
    return a -> b -> c -> a + b * b + c * c * c;
  }

  public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
    return predicates.stream().reduce((a, accu)-> a.or(accu)).orElse(a->false);
  }

  public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
    return Arrays.stream(text.split("\\s+")).map(a->badWords.contains(a)?a:"").filter(a->a.length()>0).sorted(String::compareTo).distinct();
  }

  public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
    return IntStream.concat(evenStream, oddStream).filter(a-> a % 3 == 0 || a % 5 == 0).sorted().skip(2);
  }

  public static long factorial(long n) {
    return LongStream.range(1,n+1).reduce((a,accu) -> a*accu).orElse(1);
  }

  public static long sumOfOddNumbersInRange(long start, long end) {
    return LongStream.range(start, end+1).filter(a->a%2 != 0).reduce((a,accu)-> a+accu).orElse(0);
  }

  public static boolean isPrime(final long number) {
    return LongStream.range(2, number).allMatch(a->number%a != 0);
  }

  public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
    return LongStream.rangeClosed(rangeBegin, rangeEnd).parallel().filter(a-> a%2 == 0);
  }

  public static void main(String[] args) {
    Task t = new Task();
    System.out.println(t.solution("RACECAR"));
    Scanner scan = new Scanner(System.in);
    System.out.println(fun().apply(2).apply(3).apply(4));
    List<List<String>> l = Arrays.asList(Arrays.asList("ALA", "BELA"), Arrays.asList("OLA","KAROL"));
    int n = l.stream().flatMap(a -> a.stream()).filter(a-> a.length()>3).map(String::length).reduce((a,sum)-> a+sum).get();
    System.out.println(n);
    Optional<Integer> a = Optional.of(5);
    final Thread thread = new Thread();
    List<LogEntry> list = Arrays.asList(new LogEntry(LocalDate.now(),"ADA","AA"),
            new LogEntry(LocalDate.now(),"KOK","AA"),
            new LogEntry(LocalDate.now(),"KOKI","BB"),
            new LogEntry(LocalDate.now(),"BETA","BB"));
    Map<String, Long> map = list.stream().collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    map.forEach((k,v)-> System.out.println(k + " " + v));

    String[] words = {"ALA", "ZAKAZ", "OLLO", "KOOK"};

    Map<Boolean, List<String>> palindromeOrNoMap =
            Arrays.stream(words)
                    .collect(Collectors.partitioningBy(str->new StringBuilder(str).reverse().toString().equals(str)));
    //palindromeOrNoMap.putIfAbsent(false, Collections.emptyList());
    palindromeOrNoMap.forEach((k,v)-> System.out.println(k+" "+v));

    Map<String, Integer> mapka = new TreeMap<>();
    mapka.put("Gamma",  3);
    mapka.put("Omega", 24);
    mapka.put("Alpha",  1);
    mapka.forEach((k,v) -> System.out.println(k +"=" + v));
    List<Integer> liczby = Arrays.asList( 1, 2, 3, 4);
    long h = liczby.stream().collect(Collectors.reducing(0, (suma, item)->suma*item*item));

    createBadWordsDetectingStream("ALA OLA KAROL ALA MIKE KAROL", Arrays.asList("ALA", "KAROL")).forEach(let-> System.out.println(let));
    createFilteringStream(IntStream.of(30, 75), IntStream.of(60,90)).forEach(liczba -> System.out.println(liczba));
    System.out.println(factorial(2));
    System.out.println(sumOfOddNumbersInRange(7,9));
    System.out.println(isPrime(10));

    List<String> transactions = Arrays.asList("ALA", "OLA", "ADAM", "KAROL", "OLAF");

    Account adam = new Account("234A", 456L);
    Account cala = new Account("345B", 456L);
    /*
    transactions.stream()
            .collect(Collectors.groupingBy(ss->ss.charAt(0)+"", Collectors.summingLong(String::length)));
    */
    List<Transaction> trans = Arrays.asList(new Transaction("12", 234L, adam),
            new Transaction("45a", 456L, adam),
            new Transaction("47a", 456L, cala),
            new Transaction("49a", 456L, cala));

    //Map<Account, Long> totalSumOfTransByEachAccount =
            trans.stream()
                    .collect(Collectors.groupingBy(tr->tr.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum)))
            .forEach((pk, pv) -> System.out.println(pk +" "+ pv));

    String str = "1 2 3 4 5 6 7 8 9 10";
    LinkedList<Integer> ll = new LinkedList<>();

    for(String stt: str.split("\\s+")){
      ll.addFirst(Integer.parseInt(stt));
    }
    ll.remove();
    ll.remove();
    ll.remove();
    Collections.sort(ll);
    ll.forEach(sss-> System.out.println(sss));

  }

}
