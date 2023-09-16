package androidsamples.java.dicegames;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {
  Die6 die;
  private int currBalance, numSingleSixes, numTotalRolls, numDoubleSixes, numDoubleOthers, previousRollValue, currRollValue;

  /**
   * The no argument constructor.
   */
  public WalletViewModel() {
    die = new Die6();
    currBalance = 0;
    numSingleSixes = 0;
    numTotalRolls = 0;
    numDoubleSixes = 0;
    numDoubleOthers = 0;
    previousRollValue = 0;
  }

  /**
   * Reports the current balance.
   *
   */
  public int balance() {
    return currBalance;
  }

  /**
   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
   */
  public void rollDie() {
    previousRollValue = currRollValue;
    die.roll();
    currRollValue = die.value();

    numTotalRolls++;

    if(currRollValue == 6){
      numSingleSixes++;
      currBalance += 5;
      if(previousRollValue == 6) {
        numDoubleSixes++;
        currBalance += 5;
      }
    }
    else if(previousRollValue == currRollValue){
      numDoubleOthers++;
      currBalance -= 5;
    }
  }

  /**
   * Reports the current value of the {@link Die}.
   *
   */
  public int dieValue() {
    return currRollValue;
  }

  /**
   * Reports the number of single (or first) sixes rolled so far.
   *
   */
  public int singleSixes() {
    return numSingleSixes;
  }

  /**
   * Reports the total number of dice rolls so far.
   *
   */
  public int totalRolls() {
    return numTotalRolls;
  }

  /**
   * Reports the number of times two sixes were rolled in a row.
   *
   */
  public int doubleSixes() {
    return numDoubleSixes;
  }

  /**
   * Reports the number of times any other number was rolled twice in a row.
   *
   */
  public int doubleOthers() {
    return numDoubleOthers;
  }

  /**
   * Reports the value of the die on the previous roll.
   *
   */
  public int previousRoll() {
    return previousRollValue;
  }
}
