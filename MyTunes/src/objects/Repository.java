package objects;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.datatype.Artwork;

/**
 *
 * Repository.java
 * 
 * Klasse zum Erstellen eines Repository
 * 
 * Erstellt wird eine ArrayList aus Playlists. Bevor Tracks in die Playlist
 * geschrieben werden, werden die ID3Tags ausgelesen und im Trackobjekt ge-
 * speichert.
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class Repository {

    private String path;
    private MP3Player player;
    private String artist;
    private String album;
    private String title;
    private String lyrics;
    private ImageIcon cover;
    private Image image;
    private Image imageNewScale;
    private Artwork artwork;
    private int laenge = 0;
    private int id = 1;
    private Playlist playlist;
    private Track aktTrack;
    private ArrayList<Playlist> allePlaylists = new ArrayList<Playlist>();

    // Default Konstruktor
    public Repository() {
    }

    // Konstruktor
    public Repository(MP3Player player) {
        this.player = player;
    }

    // Konstruktor
    public Repository(String path, Playlist playlist) {
        this.path = path;
        this.playlist = playlist;
    }

    // Erstellen eines neuen Tracks mittels aller MP3Tag-Informationen
    public Track createTrack(String path) {
        aktTrack = new Track(id, title, laenge, album, artist, path, cover, lyrics);
        id++;
        return aktTrack;
    }

    // Erstellen der Playlist
    public void createPlaylist(String path, Playlist playlist) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        getID3Tags(path);
        playlist.addTrack(createTrack(path));
    }

    // ID3Tags aus dem MP3File herauslesen
    public void getID3Tags(String path) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {

        File aktFile = new File(path);
        AudioFile myAudioFile = AudioFileIO.read(aktFile);
        Tag myTag = myAudioFile.getTag();
        AudioHeader myHeader = myAudioFile.getAudioHeader();

        // Allegemeine Tags auslesen
        laenge = myHeader.getTrackLength();
        artist = myTag.getFirst(FieldKey.ARTIST);
        album = myTag.getFirst(FieldKey.ALBUM);
        title = myTag.getFirst(FieldKey.TITLE);
        lyrics = myTag.getFirst(FieldKey.LYRICS);

        // Cover auslesen
        artwork = myTag.getFirstArtwork();
        artwork.createArtworkFromFile(aktFile);

        try {
            // Cover auf entsprechende Groesse zuschneiden
            image = toImage(artwork.getImage());
            imageNewScale = image.getScaledInstance(150, 150, 150);
            cover = new ImageIcon(imageNewScale);

        } catch (Exception e) {
            // Wenn kein Artwork vorhanden ist, MyTunes Bild verwenden
            System.out.print("Kein Artwork vorhanden!\n");
            cover = new ImageIcon(getClass().getResource("/data/pics/mytunes150.jpg"));
        }
    }

    // Namenscheck, damit nicht zwei gleiche Playlists erstellt werden koennen
    public String playlistNameCheck(String playlistName) {

        try {
            if (!allePlaylists.isEmpty()) {
                for (Playlist aktPlaylist : allePlaylists) {
                    if (playlistName.equalsIgnoreCase(aktPlaylist.getPTitle())) {
                        playlistName = playlistName + "_new";
                    }
                }
            }
        } catch (Exception e) {
            System.out.print("Namecheck nicht möglich\n");
        }
        return playlistName;
    }

    // Umwandlung eines BufferedImage in ein Image
    public static Image toImage(BufferedImage bufferedImage) {
        return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
    }

    public ArrayList<Playlist> getAllePlaylists() {
        return allePlaylists;
    }

    public String getLyrics() {
        return lyrics;
    }

    public Playlist getPlaylistByIndex(int index) {
        return allePlaylists.get(index);
    }

    public void allPlaylistsAdd(Playlist newPlaylist) {
        allePlaylists.add(newPlaylist);
    }

    public boolean isEmpty() {
        return allePlaylists.isEmpty();
    }
}
