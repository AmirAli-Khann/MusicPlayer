package com.amiralifakhrabadi.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    private boolean isMusicPlayed;
    private boolean isPaused;
    private int indexOfPlayed;


    private final int[] musicResID = {R.raw.az_chi_begam, R.raw.barcode,
            R.raw.entezar, R.raw.faryad,
            R.raw.edameh_midam, R.raw.nisti};

    private final int[] picResId = {R.drawable.yas_az_chi_begam,
            R.drawable.yas_barcode, R.drawable.yas_entezar,
            R.drawable.yas_faryad, R.drawable.yas_man_edameh_midam, R.drawable.yas_nisti};

    private final int[] nameResID = {R.string.az_chi_begam, R.string.barcode,
            R.string.entezar, R.string.faryad,
            R.string.edame_midam, R.string.nisti};

    private final int[] durationResID = {R.string.duration_az_chi_begam, R.string.duration_barcode,
            R.string.duration_entezar, R.string.duration_faryad,
            R.string.duration_edame_midam, R.string.duration_nisti};

    private ImageView ivCurrentMusic;
    private TextView tvCurrentSingerName;
    private TextView tvCurrentPlayingSong;
    private TextView tvCurrentDurationOfPlayingSong;
    private ImageView ivPlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();

        LinearLayout music1 = findViewById(R.id.music_1);
        music1.setOnClickListener(this);
        LinearLayout music2 = findViewById(R.id.music_2);
        music2.setOnClickListener(this);
        LinearLayout music3 = findViewById(R.id.music_3);
        music3.setOnClickListener(this);
        LinearLayout music4 = findViewById(R.id.music_4);
        music4.setOnClickListener(this);
        LinearLayout music5 = findViewById(R.id.music_5);
        music5.setOnClickListener(this);
        LinearLayout music6 = findViewById(R.id.music_6);
        music6.setOnClickListener(this);

        ivCurrentMusic = findViewById(R.id.iv_current_music);

        ImageView ivPrevious = findViewById(R.id.iv_previous);
        ivPrevious.setOnClickListener(this);
        ivPlayPause = findViewById(R.id.iv_play_pause);
        ivPlayPause.setOnClickListener(this);
        ImageView ivNext = findViewById(R.id.iv_next);
        ivNext.setOnClickListener(this);
        ImageView ivStop = findViewById(R.id.iv_stop);
        ivStop.setOnClickListener(this);

        tvCurrentSingerName = findViewById(R.id.tv_current_singer_name);
        tvCurrentPlayingSong = findViewById(R.id.tv_current_playing_song);
        tvCurrentDurationOfPlayingSong = findViewById(R.id.tv_duration_of_current_playing_song);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.music_1:
                isMusicPlayed = true;
                indexOfPlayed = 0;
                setMusicPlayer(indexOfPlayed);

                break;
            case R.id.music_2:
                indexOfPlayed = 1;
                isMusicPlayed = true;
                setMusicPlayer(indexOfPlayed);
                break;
            case R.id.music_3:
                indexOfPlayed = 2;
                isMusicPlayed = true;
                setMusicPlayer(indexOfPlayed);
                break;
            case R.id.music_4:
                indexOfPlayed = 3;
                isMusicPlayed = true;
                setMusicPlayer(indexOfPlayed);
                break;
            case R.id.music_5:
                indexOfPlayed = 4;
                isMusicPlayed = true;
                setMusicPlayer(indexOfPlayed);
                break;
            case R.id.music_6:
                indexOfPlayed = 5;
                isMusicPlayed = true;
                setMusicPlayer(indexOfPlayed);
                break;
            case R.id.iv_play_pause:
                if (isMusicPlayed) {
                    isPaused = true;
                    isMusicPlayed = false;
                    ivPlayPause.setImageResource(R.drawable.play_icon);
                    mediaPlayer.pause();
                } else if (isPaused) {
                    isPaused = false;
                    isMusicPlayed = true;
                    ivPlayPause.setImageResource(R.drawable.pause_icon);
                    mediaPlayer.start();
                }
                break;
            case R.id.iv_next:
                if (isMusicPlayed) {
                    if (indexOfPlayed < 5) {
                        indexOfPlayed++;
                        setMusicPlayer(indexOfPlayed);
                    } else {
                        indexOfPlayed = 0;
                        setMusicPlayer(indexOfPlayed);
                    }
                }
                break;
            case R.id.iv_previous:
                if (isMusicPlayed) {
                    if (indexOfPlayed > 0) {
                        indexOfPlayed--;
                        setMusicPlayer(indexOfPlayed);
                    } else {
                        indexOfPlayed = 5;
                        setMusicPlayer(indexOfPlayed);
                    }
                }
                break;
            case R.id.iv_stop:
                isMusicPlayed = false;
                mediaPlayer.stop();

                ivPlayPause.setImageResource(R.drawable.play_pause_icon);
                ivCurrentMusic.setImageResource(R.drawable.music_icon);
                tvCurrentSingerName.setText(R.string.stop_name);
                tvCurrentPlayingSong.setText(R.string.stop_music);
                tvCurrentDurationOfPlayingSong.setText(R.string.stop_duration);
                break;
        }
    }

    private void setMusicPlayer(int indexOfPlayed) {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, musicResID[indexOfPlayed]);
        mediaPlayer.start();

        ivPlayPause.setImageResource(R.drawable.pause_icon);
        ivCurrentMusic.setImageResource(picResId[indexOfPlayed]);
        tvCurrentSingerName.setText(R.string.singer);
        tvCurrentPlayingSong.setText(nameResID[indexOfPlayed]);
        tvCurrentDurationOfPlayingSong.setText(durationResID[indexOfPlayed]);
    }
}