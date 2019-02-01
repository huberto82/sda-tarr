package programowanie_zaawansowane.c1_json;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.util.Collections;
import java.util.Map;

public class JsonPWriteDemo {
  public static void main(String[] args) {
    JsonBuilderFactory bf = Json.createBuilderFactory(Collections.emptyMap());
    JsonObject jsonObject =
      bf.createObjectBuilder()                                       //tworzymy obiekt
      .add("Zajęcia", bf.createArrayBuilder()                    //tworzymy pole typu tablica
          .add(bf.createObjectBuilder()                              //pierwszy obiekt tablicy
              .add("Tytuł", "Programowanie w Java 1")
              .add("Data", bf.createObjectBuilder()              //pole Data jest oviektem
                  .add("rok", 2019)
                  .add("miesiać", 1)
                  .add("dzień", 19)
                  .build())
              .build())
          .add(bf.createObjectBuilder()
              .add("Tytuł", "Programowanie w Java 1")
              .add("Data", bf.createObjectBuilder()
                  .add("rok", 2019)
                  .add("miesiać", 1)
                  .add("dzień", 19)
                  .build())
              .build())
          .build()
      ).build();
    Map<String, ?> config = Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true);
    JsonWriterFactory writerFactory = Json.createWriterFactory(config);
    writerFactory.createWriter(System.out).write(jsonObject);
  }
}
