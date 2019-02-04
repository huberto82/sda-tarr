package programowanie_zaawansowane.excercise.kantor;

import java.io.IOException;
import java.net.MalformedURLException;
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
