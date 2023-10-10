import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView fractalImageView;
    private SeekBar complexitySeekBar;
    private Button colorButton;

    private FractalGenerator fractalGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fractalImageView = findViewById(R.id.fractalImageView);
        complexitySeekBar = findViewById(R.id.complexitySeekBar);
        colorButton = findViewById(R.id.colorButton);

        fractalGenerator = new FractalGenerator();
        updateFractal();

        complexitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateFractal();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        colorButton.setOnClickListener(view -> {
            // Implement color selection logic (dialog or color picker).
        });
    }

    private void updateFractal() {
        int complexity = complexitySeekBar.getProgress();
        Bitmap fractalBitmap = fractalGenerator.generateFractal(complexity);
        fractalImageView.setImageBitmap(fractalBitmap);
    }
}
