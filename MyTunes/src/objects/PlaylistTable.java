package objects;

import exceptions.TrackNotFoundEx;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objects.MP3Player;
import objects.Playlist;
import objects.Track;

/**
 *
 * PlaylistTable.java
 * 
 * Angepasste TableModell zum Erstellen der JTable playlistTable in der GUI mit den Methoden zum:
 * - Erstellen von Spalten
 * - Erstellen von Reihen
 * - Festlegen von Spaltenbreite
 * - Loeschen von Reihen
 * - Aktueller TableInhalt ausgeben
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class PlaylistTable implements Serializable {

    private DefaultTableModel myModel;
    private JTable table;
    private Playlist playlist;
    private int idCounter = 1;

    // Konstruktor
    public PlaylistTable(DefaultTableModel myModel, JTable table, Playlist playlist) throws TrackNotFoundEx {
        this.myModel = myModel;
        this.table = table;
        this.playlist = playlist;
        createColumn();
    }

    /*
     * Erstellen der Spalten Nr, Name, Interpret, Album, Dauer
     */
    public void createColumn() throws TrackNotFoundEx {
        int size = myModel.getRowCount();
        Vector newDatas = createDataVector("column", size);
        myModel.addColumn("Nr", newDatas);
        myModel.addColumn("Name", newDatas);
        myModel.addColumn("Interpret", newDatas);
        myModel.addColumn("Album", newDatas);
        myModel.addColumn("Dauer", newDatas);
    }

    /*
     * Zum Loeschen von Reihen
     */
    public void deleteRow() {
        myModel.getDataVector().removeAllElements();
    }

    /*
     * Zum Festlegen der Breite bei Spalte 1-3
     */
    public void createPlaylistTable() throws TrackNotFoundEx {
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public static Vector createDataVector(String prefix, int size) {
        Vector vector = new Vector(size);
        for (int i = 0; i < size; i++) {
            vector.add(prefix + " : " + size + " : " + i);
        }
        return vector;
    }

    /*
     * Um bei Auswahl der Playlist jeweils den aktuellen Inhalt dargstellt zu bekommen
     */
    public void updateRows(Playlist aktPlaylist, JList playlistList, MP3Player player) {
        if (myModel.getRowCount() > 0) {
            playlistList.repaint();
            deleteRow();
        }
        int trackID = 0;
        // Erstellen der einzelnen Reihen aller Tracks in der Playlist
        for (Track aktTrack : aktPlaylist.getTrackList()) {
            trackID++;
            myModel.addRow(new String[]{Integer.toString(trackID), aktTrack.getTTitle(), aktTrack.getBand(), aktTrack.getAlbumTitle(), player.formatLength(aktTrack.getTLength())});
        }
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }
}
