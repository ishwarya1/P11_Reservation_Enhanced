package sg.edu.rp.soi.p11_reservation_enhanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivityPage extends AppCompatActivity {
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        tvDetail = findViewById(R.id.textViewDetails);
        Intent intentReceived = getIntent();
        String name = intentReceived.getStringExtra("Name");
        int telephone = intentReceived.getIntExtra("Telephone", 0);
        int size = intentReceived.getIntExtra("Size", 0);
        boolean isSmoke = intentReceived.getBooleanExtra("Smoking", true);
        String date = intentReceived.getStringExtra("Day");
        String time = intentReceived.getStringExtra("Time");
        String smoke = "";
        if (isSmoke == true) {
            smoke = "smoking";
        } else {
            smoke = "non-smoking";
        }
        tvDetail.setText("New Reservation\nName: " + name + "\nTelephone:" + telephone + "\nSmoking: " + smoke + "\nSize: " + size + "\nDate: " + date + "\nTime: " + time);
    }
}