package programowanie_zaawansowane.exercise3;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Cross {
  static Path make(double x, double y, double size) {
    Path plusik = new Path();
    plusik.getElements().addAll(
            new MoveTo(x, y - size / 2),
            new LineTo(x, y + size / 2),
            new MoveTo(x - size / 2, y),
            new LineTo(x + size / 2, y)
    );
    return plusik;
  }
}
