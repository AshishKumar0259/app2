package my.fishdetection.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import my.fishdetection.AddFishDataActivity;
import my.fishdetection.R;


public class AccountFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Spinner spinner2;
    CardView AddFishData;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_account, container, false);
        /*String[] language=new String[] {"Hindi","English"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.drop_sown_item,language
        );
        autoCompleteTextView=v.findViewById(R.id.language);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/
        // for language
        /*spinner=v.findViewById(R.id.lang_spin);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(getActivity(),R.array.Language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/
        //for Assitant language
        /*spinner2=v.findViewById(R.id.Assilang_spin);
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(getActivity(),R.array.Assi_Language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);*/
        AddFishData = v.findViewById(R.id.AddFishData);
        AddFishData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddFishData = new Intent(getContext(), AddFishDataActivity.class);
                startActivity(AddFishData);
            }
        });
        return v;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}