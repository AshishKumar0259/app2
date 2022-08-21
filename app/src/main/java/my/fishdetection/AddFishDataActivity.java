package my.fishdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import my.fishdetection.model.AddDataModel;

public class AddFishDataActivity extends AppCompatActivity {

    EditText imagadata, Distribution, ThreatToHumans, Description, CommonName, FishName;
    Button AddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fish_data);
        imagadata = findViewById(R.id.imagadata);
        Distribution = findViewById(R.id.Distribution);
        ThreatToHumans = findViewById(R.id.ThreatToHumans);
        Description = findViewById(R.id.Description);
        CommonName = findViewById(R.id.CommonName);
        FishName = findViewById(R.id.FishName);

        AddData = findViewById(R.id.AddData);
        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(FishName.getText().toString())) {
                    Toast.makeText(AddFishDataActivity.this, "Write Fish Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(CommonName.getText().toString())) {
                    Toast.makeText(AddFishDataActivity.this, "Write Common Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Distribution.getText().toString())) {
                    Toast.makeText(AddFishDataActivity.this, "Write Distribution", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Description.getText().toString())) {
                    Toast.makeText(AddFishDataActivity.this, "Write Description", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(ThreatToHumans.getText().toString())) {
                    Toast.makeText(AddFishDataActivity.this, "Write Threat to Human", Toast.LENGTH_SHORT).show();
                } else {

                    String fishname = FishName.getText().toString().trim();
                    String commonName = CommonName.getText().toString().trim();
                    String description = Description.getText().toString().trim();
                    String distribution = Distribution.getText().toString().trim();
                    String threatToHumans = ThreatToHumans.getText().toString().trim();
                    String image = "-";

                    AddDataModel obj = new AddDataModel(fishname,
                            commonName, description,
                            distribution, threatToHumans,
                            image);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference fishref = db.getReference("Fish");

                    fishref.child(fishname).setValue(obj);
                    FishName.setText("");
                    CommonName.setText("");
                    Description.setText("");
                    Distribution.setText("");
                    ThreatToHumans.setText("");
                    imagadata.setText("");

                    Toast.makeText(AddFishDataActivity.this, "Data Added", Toast.LENGTH_SHORT).show();


                }

            }
        });

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Test/test2/Fishname");
        myRef.setValue("Hello");*/


    }
}