package my.fishdetection.fragments;

import static android.app.Activity.RESULT_OK;


import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.fishdetection.Adepter.reycleviewAdepter;
import my.fishdetection.Camra_activity;
import my.fishdetection.FishListActivity;
import my.fishdetection.HomeActivity;
import my.fishdetection.R;
import my.fishdetection.model.recycleviewModel;


public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RelativeLayout button;
    ImageView img;
    CardView srhfrmlist, sltfrmglry, clkfish;
    ImageView tobeuploadedimage, tobeuploadedimage2;
    private Uri filePath;
    LinearLayout l3, l2, l4;
    Button reselectimage, reselectimage2, uploadimage, uploadimage2, cancelimage, cancelimage2;

    ArrayList<recycleviewModel> dataholder;
    private final int PICK_IMAGE_REQUEST = 22;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tobeuploadedimage = v.findViewById(R.id.tobeuploadedimage);
        tobeuploadedimage2 = v.findViewById(R.id.tobeuploadedimage2);
        l3 = v.findViewById(R.id.l3);
        l2 = v.findViewById(R.id.l2);
        l4 = v.findViewById(R.id.l4);
        reselectimage = v.findViewById(R.id.reselectimage);
        reselectimage2 = v.findViewById(R.id.reselectimage2);
        uploadimage = v.findViewById(R.id.uploadimage);
        uploadimage2 = v.findViewById(R.id.uploadimage2);
        cancelimage = v.findViewById(R.id.cancelimage);
        cancelimage2 = v.findViewById(R.id.cancelimage2);
        cancelimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l4.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
            }
        });
        cancelimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l3.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);
            }
        });

        //Click Picture
        clkfish = v.findViewById(R.id.clkfish);
        clkfish.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                // Launch camera if we have permission
                if (checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                } else {
                    //Request camera permission if we don't have it.
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                }
            }
        });
        reselectimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 1);
                } else {
                    //Request camera permission if we don't have it.
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                }
            }
        });
        
        //Add Picture From Gallery
        sltfrmglry = v.findViewById(R.id.sltfrmglry);
        sltfrmglry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFromGalley();
            }
        });
        reselectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFromGalley();
            }
        });

        //Search Fish From List
        srhfrmlist = v.findViewById(R.id.srhfrmlist);
        srhfrmlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent srhfrmlistIntent = new Intent(getContext(), FishListActivity.class);
                startActivity(srhfrmlistIntent);
            }
        });


        recyclerView = v.findViewById(R.id.rcy);
        dataholder = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleviewModel ob1 = new recycleviewModel(R.drawable.anchovy, "anchovy", "Rohu", "India, Nepal");
        recycleviewModel ob2 = new recycleviewModel(R.drawable.download, "rhfbjvcd", "Katla", "India, Nepal");
        recycleviewModel ob3 = new recycleviewModel(R.drawable.tuna, "tuna", "Gaicha", "India, Nepal");
        dataholder.add(ob1);
        dataholder.add(ob2);
        dataholder.add(ob3);
        recyclerView.setAdapter(new reycleviewAdepter(dataholder));
        //camra button

        //button = v.findViewById(R.id.btn_camra);
        //img = v.findViewById(R.id.img_colour);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frame,new camra());
                fr.commit();*//*
                //send home fragment to camra Activity
                Intent i = new Intent(getActivity().getApplication(), Camra_activity.class);
                startActivity(i);
            }
        });*/


        return v;
    }


    private void selectFromGalley() {
        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                        getActivity().getContentResolver(),
                        filePath);
                l3.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
                tobeuploadedimage.setImageBitmap(bitmap);
            } catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
        /*if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            tobeuploadedimage.setImageBitmap(photo);
        }*/
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            //int dimension = Math.min(image.getWidth(),image.getHeight());
            //image = ThumbnailUtils.extractThumbnail(image,dimension,dimension);
            l4.setVisibility(View.VISIBLE);
            l2.setVisibility(View.INVISIBLE);
            tobeuploadedimage2.setImageBitmap(image);

            /*image = Bitmap.createScaledBitmap(image,imageSize,imageSize,false);
            classifyImage(image);*/
        }

    }

}