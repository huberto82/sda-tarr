package programowanie_zaawansowane.fxtodoapp.service;

import org.yaml.snakeyaml.Yaml;
import programowanie_zaawansowane.c4_yaml.Configuration;
import programowanie_zaawansowane.fxtodoapp.configuration.AppConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationService {
  private static Configuration instance;
  private static String configPath = "/fxtodoapp/configuration.yaml";

  private ConfigurationService(){
    Yaml yaml = new Yaml();
    try(InputStream in = Files.newInputStream(Paths.get(configPath))) {
      AppConfiguration config = yaml.loadAs(in, AppConfiguration.class);
      System.out.println(yaml.dump(config));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
