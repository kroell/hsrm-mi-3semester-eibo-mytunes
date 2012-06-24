package objects;

import javax.swing.ImageIcon;

/**
 *
 * Track.java
 * 
 * Klasse zum Erstellen eines Track-Objekts mit:
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class Track {

    private int tId = 0;
    private String tTitle = "";
    private int tLength = 0;
    private String albumTitle = "";
    private String band = "";
    private String soundFile = "";
    private ImageIcon coverFile;
    private String lyrics;

    // Default Konstruktor
    public Track() {
    }

    // Konstruktor
    public Track(String tTitle, int length, String albumTitle, String band, String soundFile, ImageIcon coverFile, String lyrics) {
        this.tTitle = tTitle;
        this.tLength = length;
        this.albumTitle = albumTitle;
        this.band = band;
        this.soundFile = soundFile;
        this.coverFile = coverFile;
        this.lyrics = lyrics;
    }

    // Konstruktor
    public Track(int tId, String tTitle, int length, String albumTitle, String band, String soundFile, ImageIcon coverFile, String lyrics) {
        this.tId = tId;
        this.tTitle = tTitle;
        this.tLength = length;
        this.albumTitle = albumTitle;
        this.band = band;
        this.soundFile = soundFile;
        this.coverFile = coverFile;
        this.lyrics = lyrics;
    }

    public int getTId() {
        return tId;
    }

    public String getTTitle() {
        return tTitle;
    }

    public int getTLength() {
        return tLength;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getBand() {
        return band;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public ImageIcon getCoverFile() {
        return coverFile;
    }

    public String getLyrics() {
        return lyrics;
    }
}
