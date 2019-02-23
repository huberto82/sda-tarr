package programowanie_zaawansowane.exercise2.kantor;

import java.io.IOException;
import java.util.List;

public class testJson {
  public static void main(String[] args) throws IOException {
    CurrencyJsonReader reader = new CurrencyJsonReader();
    List<CurrencyJsonReader.CurrencyRate> lista =  reader.getCurrencies();
    for(CurrencyJsonReader.CurrencyRate item: lista){
      System.out.println(item);
    }
  }
}
