package androidsamples.java.dicegames;

import java.util.Random;

/**
 * An implementation of a six-faced {@link Die} using {@link Random}.
 */
public class Die6 implements Die {
  static final int numFaces = 6;
  Random rand;
  private int topFaceValue;
  public Die6() {
    rand = new Random();
    topFaceValue = 0;
  }

  @Override
  public void roll() {
    topFaceValue = rand.nextInt(numFaces) + 1;
  }

  @Override
  public int value() {
    return topFaceValue;
  }
}
