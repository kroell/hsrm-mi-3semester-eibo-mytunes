package objects;

import java.util.LinkedList;
import exceptions.TrackNotFoundEx;

/**
 *
 * Playlist.java
 * 
 * Klasse zum Erstellen eines Playlist-Objekts mit:
 * - ID
 * - Titel
 * - Erstellungsdatum
 * 
 * und den Funktionen:
 * - Rueckgabe der Anzahl der Tracks
 * - Finden des Tracks nach dem Index
 * - Rueckgabe aller Tracks der Playlist
 * - Hinzufuegen und Loeschen von Tracks
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class Playlist {

    private int pId = 0;
    private String pTitle = "";
    private int pCreationDate;
    private LinkedList<Track> trackList = new LinkedList<Track>();
    private Track aktTrack = new Track();

    // Default-Konstruktor
    public Playlist() {
    }

    // Konstruktor
    public Playlist(String pTitle) {
        this.pTitle = pTitle;
    }

    // Konstruktor
    public Playlist(int pId, String pTitle) {
        this.pId = pId;
        this.pTitle = pTitle;
    }

    // Konstruktor mit zusaetzlich Erstellungsdatum
    public Playlist(int pId, String pTitle, int pCreationDate) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pCreationDate = pCreationDate;
    }

    // Gibt die Trackanzahl der Playlist zurück
    public int getNumberOfTracks() {
        return trackList.size();
    }

    // Track nach Track-ID in der Playlist finden
    public Track getTrackByIndex(int tId) throws TrackNotFoundEx {
        if (tId < trackList.size()) {
            return trackList.get(tId);
        } else {
            throw new TrackNotFoundEx("Playlist ist kürzer als gewählter Trackindex");
        }
    }

    // Zugriff auf alle Tracks innerhalb der Playlist
    public Track getTracks() throws TrackNotFoundEx {
        if (!trackList.isEmpty()) {
            for (int i = 0; i < trackList.size(); i++) {
                aktTrack = trackList.get(i);
            }
        } else {
            throw new TrackNotFoundEx("Track nicht vorhanden!");
        }
        return aktTrack;
    }

    // Fuegt einen Track der Playlist hinzu
    public void addTrack(Track aktTrack) {
        trackList.add(aktTrack);
    }

    // Loescht einen Track von der Playlist
    public void deleteTrack(int pos) {
        try {
            trackList.remove(pos - 1);
        } catch (Exception ex) {
            System.out.print("Track konnte nicht geloescht werden!");
        }
    }

    public int getPId() {
        return pId;
    }

    public String getPTitle() {
        return pTitle;
    }

    public void setPTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public int getPCreationDate() {
        return pCreationDate;
    }

    public LinkedList<Track> getTrackList() {
        return trackList;
    }
}
