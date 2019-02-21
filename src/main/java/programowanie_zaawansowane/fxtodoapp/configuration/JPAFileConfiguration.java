package programowanie_zaawansowane.fxtodoapp.configuration;

public class JPAFileConfiguration {
  private String filePath;
  private int maxItems;

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public int getMaxItems() {
    return maxItems;
  }

  public void setMaxItems(int maxItems) {
    this.maxItems = maxItems;
  }
}
