package podstawowa;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Listed {
  List<String> apply(Stream<List<String>> input);
}



interface Func {
  List<String> apply(List<String> input);
}
public class StepikCourse {

  /**
   * The operator combines all values in the given range into one value
   * using combiner and initial value (seed)
   */
  public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator = (a, fun)-> fun;

  /**
   * The operator calculates the sum in the given range (inclusively)
   */
  public static final IntBinaryOperator sumOperator = (a, b) -> a + b ;

  /**
   * The operator calculates the product in the given range (inclusively)
   */
  public static final IntBinaryOperator productOperator = (a, b) -> a*b;

  public static void main(String[] args) {
    int r = reduceIntOperator.apply(1, sumOperator).applyAsInt(2,4);
    System.out.println(r);
    String str = "ALA OLA ALA KAROL OLA";
    Func func = x-> x.stream().distinct().collect(Collectors.toList());
    Listed al = x->x.flatMap(a->a.stream()).distinct().collect(Collectors.toList());
    List<String> lista = Arrays.asList(str.split("\\s+"));
    List<List<String>> slist = new ArrayList<>();
    slist.add(lista);
    List<String> res = al.apply(slist.stream());
    List<String> result = func.apply(lista);
    result.stream().forEach(a-> System.out.println(a));


  }
}
