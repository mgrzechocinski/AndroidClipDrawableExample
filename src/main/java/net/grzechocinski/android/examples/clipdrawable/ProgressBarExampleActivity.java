package net.grzechocinski.android.examples.clipdrawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import net.grzechocinski.android.examples.domain.Percent;

public class ProgressBarExampleActivity extends Activity {

    public static final String PERCENT_CHAR = "%";

    private VerticalProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progressBar = (VerticalProgressBar) findViewById(R.id.acd_id_proress_bar);

        setupClickListener(R.id.acd_id_button_0, Percent.PERCENT_0);
        setupClickListener(R.id.acd_id_button_25, Percent.PERCENT_25);
        setupClickListener(R.id.acd_id_button_50, Percent.PERCENT_50);
        setupClickListener(R.id.acd_id_button_75, Percent.PERCENT_75);
        setupClickListener(R.id.acd_id_button_100, Percent.PERCENT_100);
    }

    private void setupClickListener(int buttonResId, final Percent percentToSet) {
        final Button button = (Button) findViewById(buttonResId);
        button.setText(percentToSet.asIntValue() + PERCENT_CHAR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setCurrentValue(percentToSet);
            }
        });
    }
}
