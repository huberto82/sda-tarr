package programowanie_zaawansowane.c4_yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YamlDemo {
  public static void main(String[] args) {
    String pathStr = "src\\main\\java\\programowanie_zaawansowane\\c4_yaml\\configuration.yaml";
    System.out.println(new File(pathStr).getAbsolutePath());
    Yaml yaml = new Yaml();
    try(InputStream in = Files.newInputStream(Paths.get(pathStr))) {
      Configuration config = yaml.loadAs(in, Configuration.class);
      System.out.println( config.toString() );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
