package com.example.myanimalsoundapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutMain;
    ImageView imgAnimal, phoneIcon;
    TextView txtAnimal;
    ProgressBar progressBar;
    TextView progressPercent;
    int currentProgress = 0;

    int[] colors = {R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5};
    int[] icons = {R.drawable.bee, R.drawable.penguin, R.drawable.cat, R.drawable.rabbit, R.drawable.bird};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Thay đổi màn hình giữa các phần luyện tập
        setContentView(R.layout.luyentap3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*//Xử lí bài luyện tập 1
        layoutMain = findViewById(R.id.main);
        imgAnimal = findViewById(R.id.imgAnimal);
        txtAnimal = findViewById(R.id.txtAnimal);

        imgAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int randomColor = colors[random.nextInt(colors.length)];
                layoutMain.setBackgroundResource(randomColor);

                int randomIcon = icons[random.nextInt(icons.length)];
                imgAnimal.setImageResource(randomIcon);
            }
        });*/

        //Xử lý bài luyện tập 2
        /*progressBar = findViewById(R.id.progressBar);
        progressPercent = findViewById(R.id.progressPercent);
        final CountDownTimer countDownTimer = new CountDownTimer(10*1000, 1000) {
            @Override
            public void onTick(long l) {
                currentProgress = currentProgress + 100;
                progressBar.setProgress(currentProgress);
                progressBar.setMax(1000);
                progressPercent.setText(currentProgress/10+ "%");
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Progress Finished!", Toast.LENGTH_SHORT).show();
                currentProgress = 0;
                progressBar.setProgress(currentProgress);
                progressPercent.setText("0%");

                this.start();
            }
        };
        countDownTimer.start();*/

        //Xử lý bài luyện tập 3
        phoneIcon = findViewById(R.id.phoneIcon);
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall("0974891496");
            }
        });


    }//oncreate

    public void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}//main