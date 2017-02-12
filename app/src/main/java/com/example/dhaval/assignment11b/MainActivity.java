package com.example.dhaval.assignment11b;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button button;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ProgressBar progressBar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        progressBar1=(ProgressBar) findViewById(R.id.progressBar2);
        progressBar2=(ProgressBar) findViewById(R.id.progressBar3);
        progressBar3=(ProgressBar) findViewById(R.id.progressBar4);
        progressBar4=(ProgressBar) findViewById(R.id.progressBar5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new  ProgressLoading().execute();
            }
        });
    }

    public class ProgressLoading extends AsyncTask<Void,Integer,Void>
    {
        @Override
        protected Void doInBackground(Void... params) {

            for(int i=1;i<15;i++)
            {
                sleep();
                if(i>10) {
                    int j=i-10;
                    publishProgress(j * 10);
                }
                else
                {
                    publishProgress(i * 10);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if(progressBar1.getProgress()!=100
                    && progressBar2.getProgress()!=100) {
                progressBar1.setProgress(values[0]);
                progressBar2.setProgress(values[0]);
            }
            else
            {
                progressBar3.setProgress(values[0]);
                progressBar4.setProgress(values[0]);
            }
        }

        public void sleep()
        {
            try{
              Thread.sleep(500);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
