package com.globizs.uxdesignapp.util;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import com.globizs.uxdesignapp.BaseApplication;
import com.globizs.uxdesignapp.modal.Spot;

import java.io.File;

public class AudioFunction {
    
    public static MediaPlayer mediaPlayer;
    
    public static void playAudio(final Spot spot){
        try {
            // Syntax  :  android.resource://[package]/[res type]/[res name]
            // Example : Uri.parse("android.resource://com.my.package/raw/sound1");
            //
            // Syntax  : android.resource://[package]/[resource_id]
            // Example : Uri.parse("android.resource://com.my.package/" + R.raw.sound1);

            String RESOURCE_PATH = ContentResolver.SCHEME_ANDROID_RESOURCE + "://";

            String path;
            if (false) {
                path = RESOURCE_PATH + BaseApplication.getAppContext().getPackageName() + "/raw/" + spot.getAudioFileName();
            } else {
                int resID = BaseApplication.getAppContext().getResources().getIdentifier(spot.getAudioFileName(), "raw", BaseApplication.getAppContext().getPackageName());
                path = RESOURCE_PATH + BaseApplication.getAppContext().getPackageName() + File.separator + resID;
            }
            Uri soundUri = Uri.parse(path);
            //   mSoundName.setText(path);

            if( mediaPlayer==null)
                mediaPlayer = new MediaPlayer();
            if (true) {
                // Internal asset
                mediaPlayer.setDataSource(BaseApplication.getAppContext(), soundUri);
                mediaPlayer.prepare();
            } else if (false) {
                // Load external audio files url:
                //  "http://www.bogotobogo.com/Audio/sample.mp3";
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
            } else {
                // Internal resource asset
                ContentResolver resolver = BaseApplication.getAppContext().getContentResolver();
                AssetFileDescriptor afd = resolver.openAssetFileDescriptor(soundUri, "r");
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            }

            mediaPlayer.start();
        } catch (Exception ex) {
            Toast.makeText(BaseApplication.getAppContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
                mediaPlayer=null;
                Toast.makeText(BaseApplication.getAppContext(),spot.getSpotName()+" description is finised..",Toast.LENGTH_LONG).show();
            }
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(BaseApplication.getAppContext(),"Error ",Toast.LENGTH_LONG).show();
                return false;
            }
        });


    
    }
}
