package com.example.signal;

import android.app.Activity;
import android.widget.ImageButton;

import android.widget.Toast;
import android.os.Bundle;
import android.os.Environment;

import android.view.Menu;
import android.view.View;

import android.media.AudioManager;

import android.media.MediaRecorder;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;


import java.io.IOException;


public class AudioRecordTest extends Activity {

	private MediaRecorder myAudioRecorder;
	   private String outputFile = null;
	
	   private ImageButton pic,start,play,stop;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.recordmode);
	      start = (ImageButton)findViewById(R.id.imageButton1);
	      
	      stop = (ImageButton)findViewById(R.id.imageButton4);
	      play = (ImageButton)findViewById(R.id.imageButton3);
	      pic  = (ImageButton)findViewById(R.id.imageButton2);
	      stop.setEnabled(false);
	      play.setEnabled(false);
	      outputFile = Environment.getExternalStorageDirectory().
	      getAbsolutePath() + "/myrecording.3gp";

	      myAudioRecorder = new MediaRecorder();
	      myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
	      myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
	      myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
	      myAudioRecorder.setOutputFile(outputFile);
	   }
	   public void create()
	   {
		   
	   }
	   float rate=0.8f;
	   String voicetype ="Man Voice";
	   public void pic(View view){
		   if(rate==1.2f)
		   {
			   rate=0.8f;
			   pic.setImageResource(R.drawable.anonymous_boy_symbol);
			     Toast.makeText(getApplicationContext(), voicetype, Toast.LENGTH_SHORT).show();   
			   voicetype ="Woman Voice";
		   }
			else if(rate==0.8f)
			{
				rate=1.2f;
				pic.setImageResource(R.drawable.anonymous_girl_symbol);
			     Toast.makeText(getApplicationContext(), voicetype, Toast.LENGTH_SHORT).show();   
				voicetype = "Man Voice";
			}
		   
	   }
	
	   public void start(View view){
		start.setEnabled(false);
		stop.setEnabled(true);
			        	try {
					         myAudioRecorder.prepare();
					         myAudioRecorder.start();
					      } catch (IllegalStateException e) {
					         // TODO Auto-generated catch block
					         e.printStackTrace();
					      } catch (IOException e) {
					         // TODO Auto-generated catch block
					         e.printStackTrace();
					      }
					   
					  start.setVisibility(View.GONE);
					  stop.setVisibility(View.VISIBLE);
				      Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_SHORT).show();
		   
	   }
	  
public void stop(View view){
	start.setEnabled(false);
	stop.setEnabled(true);
	 myAudioRecorder.stop();
	  
     myAudioRecorder.release();
     myAudioRecorder  = null;
     
     start.setVisibility(View.VISIBLE);
	  stop.setVisibility(View.GONE);
   
Toast.makeText(getApplicationContext(), "Audio recorded successfully ",Toast.LENGTH_SHORT).show();
}
private SoundPool mSoundPool;
boolean loaded = false;
public void play(View view) throws IllegalArgumentException,   
SecurityException, IllegalStateException, IOException{
	   
	   mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	   final int explosion = mSoundPool.load(outputFile, 0);
	   mSoundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
         @Override
         public void onLoadComplete(SoundPool soundPool, int sampleId,
                 int status) {
         	mSoundPool.play(explosion, 20,20, 1, 0, rate);
         	
         }
     });
                                                        
}
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
	      getMenuInflater().inflate(R.menu.main, menu);
	      return true;
	   }
}



