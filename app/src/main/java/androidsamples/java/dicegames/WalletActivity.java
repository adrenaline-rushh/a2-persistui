package androidsamples.java.dicegames;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {
  public WalletViewModel walletViewModel;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
      setContentView(R.layout.activity_wallet_potrait);
    }
    else {
      setContentView(R.layout.activity_wallet_landscape);
    }

    walletViewModel = new ViewModelProvider(this).get(WalletViewModel.class);
    updateUI();
  }

  protected void addSuspense() {
    ((Button)findViewById(R.id.btn_die)).setText(R.string.blank_string);
    // Disable pressing of button
    ((Button)findViewById(R.id.btn_die)).setEnabled(false);
    ((TextView)findViewById(R.id.txt_prev_roll)).setText(R.string.suspense_string);

    ((TextView)findViewById(R.id.txt_coins)).setText(R.string.blank_string);
    ((TextView)findViewById(R.id.txt_single_sixes)).setText(R.string.blank_string);
    ((TextView)findViewById(R.id.txt_total_rolls)).setText(R.string.blank_string);
    ((TextView)findViewById(R.id.txt_double_sixes)).setText(R.string.blank_string);
    ((TextView)findViewById(R.id.txt_double_others)).setText(R.string.blank_string);
  }

  protected void updateUI() {
    if(walletViewModel.dieValue() == 6) {
      Toast.makeText(this, R.string.congratulations_string, Toast.LENGTH_SHORT).show();
    }

    ((TextView)findViewById(R.id.txt_coins)).setText(R.string.initial_coins);
    ((TextView)findViewById(R.id.txt_coins)).append(Integer.toString(walletViewModel.balance()));

    ((Button)findViewById(R.id.btn_die)).setText(Integer.toString(walletViewModel.dieValue()));

    ((TextView)findViewById(R.id.txt_prev_roll)).setText(R.string.initial_prev_roll);
    ((TextView)findViewById(R.id.txt_prev_roll)).append(Integer.toString(walletViewModel.previousRoll()));

    ((TextView)findViewById(R.id.txt_single_sixes)).setText(R.string.initial_sixes_rolled);
    ((TextView)findViewById(R.id.txt_single_sixes)).append(Integer.toString(walletViewModel.singleSixes()));

    ((TextView)findViewById(R.id.txt_total_rolls)).setText(R.string.initial_total_rolls);
    ((TextView)findViewById(R.id.txt_total_rolls)).append(Integer.toString(walletViewModel.totalRolls()));

    ((TextView)findViewById(R.id.txt_double_sixes)).setText(R.string.initial_double_sixes);
    ((TextView)findViewById(R.id.txt_double_sixes)).append(Integer.toString(walletViewModel.doubleSixes()));

    ((TextView)findViewById(R.id.txt_double_others)).setText(R.string.initial_double_others);
    ((TextView)findViewById(R.id.txt_double_others)).append(Integer.toString(walletViewModel.doubleOthers()));

    // Enable button again
    ((Button)findViewById(R.id.btn_die)).setEnabled(true);
  }

  public void rollDie(View view) {
    walletViewModel.rollDie();
    addSuspense();

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        updateUI();
      }
    };

    handler.postDelayed(runnable, 500);
  }
}