package objects;

import exceptions.TrackNotFoundEx;
import java.io.File;
import java.util.Map;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 *
 * MP3Player.java
 * 
 * Klasse mit allen Kernfunktionen des MP3Players wie:
 * - play
 * - stop
 * - pause/resume
 * - skip
 * - skipback
 * - Volume setzen
 * - Playlist einlegen
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class MP3Player extends Observable implements BasicPlayerListener {

    Player playMp3;
    AdvancedPlayer playAdMp3;
    BasicPlayer basicPlayer;
    BasicPlayerListener basicPlayerListener;
    private Playlist aktuellePlaylist;
    private int aktuelleTrackNr;
    private boolean isPlaying;
    private boolean isPaused;
    private Timer timerPosition;
    private Track aktTrack = null;
    private int position = 0;
    private double actVolume = 0.5;

    // Default Konstruktor
    public MP3Player() {
        basicPlayer = new BasicPlayer();
        basicPlayer.addBasicPlayerListener(this);
    }

    /**
     * 
     * Playlist auf aktuell setzen
     * 
     */
    public void insert(Playlist aktPlaylist) {
        aktuellePlaylist = aktPlaylist;
        aktuelleTrackNr = 0;
    }

    /**
     * 
     * Abspielen des aktuellen Songs, Starten des Timers zur Positionsbe-
     * stimmung, erzeugen einer Growl Message
     * 
     */
    public void play() throws TrackNotFoundEx, BasicPlayerException {

        synchronized (this) {
            if (aktuellePlaylist != null) {
                aktTrack = aktuellePlaylist.getTrackByIndex(aktuelleTrackNr);

                try {
                    // Damit im laufenden Prozess das erneute Aufrufen play
                    // nicht nochmal startet
                    if (!isPlaying) {
                        isPlaying = true;
                        basicPlayer.open(new File(aktTrack.getSoundFile()));
                        position = 0;
                        // Neuer Timer erzeugen, der nach einer Sekunde jede
                        // Sekunde abfeuert - Zum Befuellen der progressBar
                        timerPosition = new Timer();
                        MyTaskGetPosition myTask = new MyTaskGetPosition();
                        timerPosition.schedule(myTask, 1000, 1000);
                        // Player auf aktuelle Lautstaerke setzen
                        volume(actVolume);
                        basicPlayer.play();
                        // Anzeigen einer GrowlMessage des aktuellen Tracks
                        new GrowlMessage("Aktueller Track", aktTrack.getTTitle(), "Album: " + aktTrack.getAlbumTitle() + "\n" + "Künstler: " + aktTrack.getBand());
                    }
                } catch (Exception e) {
                    System.out.println("Abspielen nicht möglich!\n");
                }
            }
        }
    }

    /**
     * 
     * Stoppen des aktuellen Songs, Timer beenden
     * 
     * 
     */
    public void stop() throws BasicPlayerException {

        if (isPlaying == true) {
            basicPlayer.stop();
            isPlaying = false;
            timerPosition.cancel();
            position = 0;
        }
    }

    /**
     * 
     * SkipForward des aktuellen Songs, setzen der Lautstaerke
     * 
     */
    public void skip() throws TrackNotFoundEx, BasicPlayerException {

        aktuelleTrackNr++;

        if (isPlaying == true) {
            stop();


            if (aktuellePlaylist != null) {
                try {
                    if (aktuelleTrackNr >= aktuellePlaylist.getNumberOfTracks()) {
                        aktuelleTrackNr = 0;
                    }
                    aktuellePlaylist.getTrackByIndex(aktuelleTrackNr);
                } catch (Exception e) {
                    System.out.println("Skippen nicht moeglich\n");
                }

                play();
                basicPlayer.setGain(actVolume);
            }
        } // Falls geskippt und der Player aktiv ist
        else {
            if (aktuellePlaylist != null) {
                try {
                    if (aktuelleTrackNr >= aktuellePlaylist.getNumberOfTracks()) {
                        aktuelleTrackNr = 0;
                    }
                    aktuellePlaylist.getTrackByIndex(aktuelleTrackNr);
                } catch (Exception e) {
                    System.out.println("Skippen nicht moeglich\n");
                }
            }
        }
    }

    /**
     * 
     * SkipBackward des aktuellen Songs, setzen der Lautstaerke
     * 
     */
    public void skipBack() throws TrackNotFoundEx, BasicPlayerException {

        if (isPlaying == true) {
            stop();

            if (aktuellePlaylist != null) {
                try {
                    if (aktuelleTrackNr == 0) {
                        aktuelleTrackNr += aktuellePlaylist.getNumberOfTracks();
                    }
                    aktuellePlaylist.getTrackByIndex(--aktuelleTrackNr);
                } catch (Exception e) {
                    System.out.println("Skippen nicht moeglich\n");
                }
                play();
                basicPlayer.setGain(actVolume);
            }
        } // // Falls geskippt und der Player aktiv ist
        else {
            if (aktuellePlaylist != null) {
                try {
                    if (aktuelleTrackNr == 0) {
                        aktuelleTrackNr += aktuellePlaylist.getNumberOfTracks();
                    }
                    aktuellePlaylist.getTrackByIndex(--aktuelleTrackNr);
                } catch (Exception e) {
                    System.out.println("Skippen nicht moeglich\n");
                }
            }
        }
    }

    /**
     * 
     * Pausieren des aktuellen Songs, Timer beenden
     * 
     */
    public void pause() throws JavaLayerException, BasicPlayerException {
        if (isPlaying == true) {
            basicPlayer.pause();
            isPlaying = false;
            isPaused = true;
            timerPosition.cancel();
        }
    }

    /**
     * 
     * Resume des aktuellen Songs, Timer neu initialisieren
     * 
     */
    public void resume() throws BasicPlayerException {
        basicPlayer.resume();
        isPlaying = true;
        isPaused = false;
        // Timer neu initialisieren
        timerPosition = new Timer();
        MyTaskGetPosition myTask = new MyTaskGetPosition();
        timerPosition.schedule(myTask, 1000, 1000);
    }

    /**
     * 
     * Lautstaerke des Players setzen
     * 
     */
    public void volume(double volume) throws BasicPlayerException {
        actVolume = volume;
        try{
           basicPlayer.setGain(actVolume);
        }
        catch (Exception ex){
            System.out.print("Volume konnte nicht gesetzt werden!\n");
        } 
    }

    /**
     * 
     * Methode zum Erhalten des aktuellen Playlisttitels
     * 
     */
    public String playlistInfo() {

        String aktPlaylist = null;

        if (aktuellePlaylist != null) {
            aktPlaylist = aktuellePlaylist.getPTitle();
        } else {
            aktPlaylist = "Keine Playlist ausgewählt";
        }
        return aktPlaylist;
    }

    @Override
    public void opened(Object o, Map map) {
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
    }

    /**
     * 
     * Automatisches Skippen, wenn der aktuelle Track zu Ende ist
     * 
     */
    public void stateUpdated(BasicPlayerEvent event) {

        if (event.getCode() == 8) {
            try {
                skip();
                basicPlayer.setGain(actVolume);
            } catch (TrackNotFoundEx ex) {
                Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void setController(BasicController bc) {
    }

    /**
     * 
     * Innere Klasse die durch den Timer verwendet wird
     * Jede Sekunde wir position um 1 hochgezaehlt, das ist ein Ersatz zum 
     * Zaehlen der Sekunden der Spielzeit
     * 
     */
    private class MyTaskGetPosition extends TimerTask {

        public void run() {

            position += 1;
            // Eine Aenderung ist aufgetreten 
            setChanged();
            // Informiere Observer über Aenderung der Position
            notifyObservers(position);
        }
    }

    /**
     * 
     * Beschriftung neben der ProgressBar mit der aktuellen Spielzeit in Min
     * und Sek
     * 
     */
    public void formatLength(JLabel playPositionTotal) {

        int value = aktTrack.getTLength();

        // Beschriftung neben der ProgressBar mit der aktuellen Spielzeit
        int minutePos = value / 60;
        int sekundePos = value % 60;

        String minString = String.valueOf(minutePos);
        String sekString = String.valueOf(sekundePos);

        if (sekundePos < 10) {
            playPositionTotal.setText(minString + ":0" + sekString);
        } else {
            playPositionTotal.setText(minString + ":" + sekString);
        }

    }

    /**
     * 
     * Beschriftung neben der ProgressBar mit der aktuellen Spielzeit in Min
     * und Sek mit Rueckgabe des Strings
     * 
     */
    public String formatLength(int value) {

        // Beschriftung neben der ProgressBar mit der aktuellen Spielzeit
        int minutePos = value / 60;
        int sekundePos = value % 60;

        String minString = String.valueOf(minutePos);
        String sekString = String.valueOf(sekundePos);

        if (sekundePos < 10) {
            return (minString + ":0" + sekString);
        } else {
            return (minString + ":" + sekString);
        }
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public boolean getIsPaused() {
        return isPaused;
    }

    public Track getAktTrack() {
        return aktTrack;
    }

    public double getVolume() {
        return actVolume;
    }

    public void setAtkTrackNr(int aktuelleTrackNr) {
        this.aktuelleTrackNr = aktuelleTrackNr;
    }
}
