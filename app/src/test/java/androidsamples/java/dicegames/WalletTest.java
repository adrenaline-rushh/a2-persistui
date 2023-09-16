package androidsamples.java.dicegames;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import androidx.core.widget.TextViewCompat;

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
}