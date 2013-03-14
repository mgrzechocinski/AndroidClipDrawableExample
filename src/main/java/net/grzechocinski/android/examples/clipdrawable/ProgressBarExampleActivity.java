package net.grzechocinski.android.examples.clipdrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import net.grzechocinski.android.examples.domain.Percent;

public class ProgressBarExampleActivity extends Activity {

    public static final String PERCENT_CHAR = "%";

    public static final int MAX_PERCENT_RANDOM_VALUE = 100;

    private VerticalProgressBar progressBar;

    private Random random;

    private Button randomValueButton;

    private TextView progressValueTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        random = new Random();

        progressBar = (VerticalProgressBar) findViewById(R.id.acd_id_proress_bar);
        randomValueButton = (Button) findViewById(R.id.acd_id_button_random);
        progressValueTextView = (TextView) findViewById(R.id.acd_id_proress_value);

        setupRandomProgressButton();

        setupStaticProgressButton(R.id.acd_id_button_25, Percent.PERCENT_25);
        setupStaticProgressButton(R.id.acd_id_button_50, Percent.PERCENT_50);
        setupStaticProgressButton(R.id.acd_id_button_75, Percent.PERCENT_75);
        setupStaticProgressButton(R.id.acd_id_button_100, Percent.PERCENT_100);
    }

    private void setupRandomProgressButton() {
        final Percent randomPercent = new Percent(random.nextInt(MAX_PERCENT_RANDOM_VALUE));
        randomValueButton.setText(randomPercent.asIntValue() + PERCENT_CHAR);
        randomValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateViews(randomPercent);
                setupRandomProgressButton();
            }
        });
    }

    private void setupStaticProgressButton(int buttonResId, final Percent percentToSet) {
        final Button button = (Button) findViewById(buttonResId);
        button.setText(percentToSet.asIntValue() + PERCENT_CHAR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateViews(percentToSet);
            }
        });
    }

    private void updateViews(Percent randomPercent) {
        progressBar.setCurrentValue(randomPercent);
        progressValueTextView.setText(randomPercent.asIntValue() + PERCENT_CHAR);
    }
}
