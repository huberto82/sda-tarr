package programowanie_zaawansowane.c1_json;
import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonDemo{

  public static void getObjects(JsonValue tree, List<JsonObject> list) {
    switch(tree.getValueType()) {
      case OBJECT:
        JsonObject object = (JsonObject) tree;
        System.out.println("KEYSET "+ object.keySet().size());
        if (object.keySet().size() > 1)
            list.add(object);
        for (String name : object.keySet())
          getObjects(object.get(name), list);
        break;
      case ARRAY:
        JsonArray array = (JsonArray) tree;
        for (JsonValue val : array)
          getObjects(val, list);
        break;
    }
  }



  public static void main(String[] args) throws URISyntaxException, IOException {
    //tworzenie JSON bez tworzenia obiektu
    JsonBuilderFactory jb = Json.createBuilderFactory(Collections.emptyMap());
    JsonObject jo = jb.createObjectBuilder()
            .add("name","Adam")
            .add("birthDate", LocalDate.now().toString())
            .add("salary", 3400)
            .build();
    //pobranie json z podanego url
    URL url= new URL("https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne.json");
    InputStream stream = url.openStream();
    JsonReader reader = Json.createReader(stream);
    JsonStructure jsonst = reader.read();

    List<JsonObject> list = new ArrayList<>();
    getObjects(jsonst, list);
    System.out.println(list.size());
    for (JsonObject o: list){
      System.out.println(o);
    }

    stream.close();
  }

}
