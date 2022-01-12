package controller;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Segundo implements Initializable {



    @FXML
    private Button homebtn;

    @FXML
    private Button nextbtn;

    @FXML
    private Button pausebtn;

    @FXML
    private Button playbtn;

    @FXML
    private Button playlistbtn;

    @FXML
    private Button previousbtn;

    @FXML
    private Button restartbtn;

    @FXML
    private Button searchbtn;

    @FXML
    private Slider volume;

    @FXML
    private ProgressBar timer;

    @FXML
    private Label songLable;

    private Media media;
    private MediaPlayer mediaplayer;

    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private Timer timerr;
    private TimerTask task;
    private boolean running;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
                songs = new ArrayList<File>();
                directory = new File("/music");
                files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        songs.add(file);

                    }
                }
                media = new Media(songs.get(songNumber).toURI().toString());
                mediaplayer = new MediaPlayer(media);

                songLable.setText(songs.get(songNumber).getName());


        }



    @FXML
    void home(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void play(ActionEvent event) {
        begintimer();
        mediaplayer.setVolume(volume.getValue() * 0.01);
        mediaplayer.play();
    }

    @FXML
    void pause(ActionEvent pausebtn) {
        cancelTimer();
        mediaplayer.pause();
    }

    @FXML
    void playlist(ActionEvent event) {

    }

    @FXML
    void previous(ActionEvent event) {

    }

    @FXML
    void restart(ActionEvent event) {
        timer.setProgress(0);
        mediaplayer.seek(Duration.seconds(0));
    }

    @FXML
    void search(ActionEvent event) {

    }
    public void begintimer() {
        timerr = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaplayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                timer.setProgress(current/end);

                if(current/end == 1) {

                    cancelTimer();
                }
            }
        };
    }

    public void cancelTimer() {

        running = false;

    }


}
