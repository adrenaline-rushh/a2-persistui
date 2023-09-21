package androidsamples.java.dicegames;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WalletTest {
  @Mock
  private Die6 die;

  @InjectMocks
  private WalletViewModel walletViewModel;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void dice_rolled_3_5() {
    when(die.value()).thenReturn(3);

    walletViewModel.rollDie();
    assertEquals(3, walletViewModel.dieValue());

    when(die.value()).thenReturn(5);

    walletViewModel.rollDie();
    assertEquals(5, walletViewModel.dieValue());
  }

  @Test
  public void dice_rolled_3_6_5_5_6_check_values() {
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(5);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(5);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();

    assertEquals(5, walletViewModel.balance());
    assertEquals(5, walletViewModel.previousRoll());
    assertEquals(2, walletViewModel.singleSixes());
    assertEquals(5, walletViewModel.totalRolls());
    assertEquals(0, walletViewModel.doubleSixes(), 0);
    assertEquals(1, walletViewModel.doubleOthers());
  }

  @Test
  public void dice_roll_2166561633() {
    when(die.value()).thenReturn(2);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(1);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(5);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(1);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();

    assertEquals(20, walletViewModel.balance());
    assertEquals(3, walletViewModel.previousRoll());
    assertEquals(4, walletViewModel.singleSixes());
    assertEquals(10, walletViewModel.totalRolls());
    assertEquals(1, walletViewModel.doubleSixes(), 0);
    assertEquals(1, walletViewModel.doubleOthers());
  }

  @Test
  public void dice_rolled_2_1_3_3_4_check_values() {
    when(die.value()).thenReturn(2);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(1);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    when(die.value()).thenReturn(4);
    walletViewModel.rollDie();

    assertEquals(-5, walletViewModel.balance());
    assertEquals(3, walletViewModel.previousRoll());
    assertEquals(0, walletViewModel.singleSixes());
    assertEquals(5, walletViewModel.totalRolls());
    assertEquals(0, walletViewModel.doubleSixes(), 0);
    assertEquals(1, walletViewModel.doubleOthers());
  }

  @Test
  public void dice_roll_66633616654() {
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(5, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(15, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(3);
    walletViewModel.rollDie();
    assertEquals(20, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(1);
    walletViewModel.rollDie();
    assertEquals(25, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(30, walletViewModel.balance());
    when(die.value()).thenReturn(6);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());
    when(die.value()).thenReturn(5);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());
    when(die.value()).thenReturn(4);
    walletViewModel.rollDie();
    assertEquals(40, walletViewModel.balance());

    assertEquals(40, walletViewModel.balance());
    assertEquals(5, walletViewModel.previousRoll());
     assertEquals(6, walletViewModel.singleSixes());
    assertEquals(11, walletViewModel.totalRolls());
    assertEquals(3, walletViewModel.doubleSixes(), 0);
    assertEquals(1, walletViewModel.doubleOthers());
  }
}