package sg.edu.rp.soi.p11_reservation_enhanced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityPage extends AppCompatActivity {
    ListView lvRes;
    ArrayList<DataList> ResList = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        lvRes = findViewById(R.id.ReservationList);
        Intent intentReceived = getIntent();
        String name = intentReceived.getStringExtra("etName");
        int telephone = intentReceived.getIntExtra("etTelephone", 0);
        int size = intentReceived.getIntExtra("etSize", 0);
        String date = intentReceived.getStringExtra("etDay");
        String time = intentReceived.getStringExtra("etTime");
        ResList.add(new DataList("Patrick", 91191199, 10, true, "17/12/2014", "20:25"));
        adapter = new CustomAdapter(this, R.layout.row, ResList);
        lvRes.setAdapter(adapter);
        lvRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDetail = new Intent(getBaseContext(), DetailActivityPage.class);
                DataList currentRes = ResList.get(position);
                intentDetail.putExtra("Name", currentRes.getName());
                intentDetail.putExtra("Telephone", currentRes.getTelephone());
                intentDetail.putExtra("Size", currentRes.getSize());
                intentDetail.putExtra("Smoking", currentRes.isSmoking());
                intentDetail.putExtra("Day", currentRes.getDate());
                intentDetail.putExtra("Time", currentRes.getTime());
                startActivity(intentDetail);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.CreateReservationActivity) {
            Intent intentCreat = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intentCreat);
        }
        return super.onOptionsItemSelected(item);
    }
}