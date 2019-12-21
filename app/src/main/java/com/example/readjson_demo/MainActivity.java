package com.example.readjson_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String mURL = "https://khoapham.vn/KhoaPhamTraining/json/tien/demo2.json";
    JSONObject jsonObject;
    RecyclerView recyclerView;
    ArrayList<classViewJSON>classViewJSONS;
    JSONADAPTOR jsonadaptor;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ReadJSON().execute(mURL);
        recyclerView= findViewById(R.id.recycleView);
    }
    class  ReadJSON extends AsyncTask<String,Void,String>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Start load mURL",Toast.LENGTH_LONG).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            return classReadLink.docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected  void onPostExecute(String s) {
            super.onPostExecute(s);

            try
            {
                jsonObject = new JSONObject(s);
                JSONArray array =jsonObject.getJSONArray("danhsach");
               classViewJSONS= new ArrayList<>();
                for(;i<array.length();i++)
                {
                    String name= array.getJSONObject(i).optString("khoahoc");
                    classViewJSONS.add(new classViewJSON(name));
                    Log.d("BBB",name+"");
                }
                jsonadaptor = new JSONADAPTOR(classViewJSONS);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(jsonadaptor);

            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
