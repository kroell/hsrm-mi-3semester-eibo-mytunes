package controller;

import javazoom.jlgui.basicplayer.BasicPlayerException;
import objects.MP3Player;
import exceptions.TrackNotFoundEx;
import gui.MyGUI;
import objects.Repository;

/**
 *
 * Controller.java
 * 
 * MyTunes - MP3 Player
 * 
 * ENTWICKLER-KOMMENTAR:
 * Dieses Programm und vor allem die GUI wurden auf einem Mac (Mac OS X Lion) 
 * konzeptiert bzw. geschrieben und nicht an das Windows Look and Feel angepasst. 
 * Daher kann es in Windows zu einer deutlich unterschiedlichen Darstellung kommen. 
 * Volle Funktionsfaehigkeit und Aussehen kann daher nur auf Mac OS X Lion 
 * sichergestellt werden!
 * 
 * 
 * Das Programm beinhaltet folgende Funktionen:
 * - Abspielen, skippen, stoppen, pausieren von MP3 Files
 * - Anzeigen der ID3Tags Kuenstler, Band, Album, Songlaenge, Artwork
 * - Anzeigen der aktuellen Trackposition mittels ProgressBar
 * - Bedienung mit Keyboard Shortcuts
 * - Erstellen von Playlists mit individuellem Namen
 * - Hinzufuegen von Tracks in die erstellte Playlist
 * - Anzeigen der Playlists und des Playlistinhalts
 *   (durch einfaches Klicken auf den Playlisttitel)
 * - Track starten durch Doppelklick innerhalb der Playlist
 * - Ersten Track der Playlist starten durch Doppelklick auf den Playlisttitel
 * - Anzeigen der Tracklyrics durch einfachen Klick auf den Song in der Playlist,
 *   sofern Lyrics vorhanden sind
 *  * - Anpassen der Lautstaerke
 * - Mute schalten bzw. Mute wieder aufheben
 * 
 * Aufgeteilt ist das Programm in folgende Klassen:
 * - Controller: Erzeugen des Players, des Repositorys, der GUI
 * - MyGUI: Darstellung des MP3 Players und der Haupt-GUI Elemente
 * - AboutFrame: Darstellung der allgemeinen Programminformationen
 * - LyricsFrame: Darstellung der Lyrics in einem seperatem Fenster
 * - PlaylistTable: TableModell zur Darstellung des Playlistinhalts in einem JTable
 * - Growl: Implementierung der Growl-Funktion zum Anzeigen von Growl Messages
 * - GrowlMessage: Zum Erzeugen von angepassten Growl Messages
 * - MP3Filter: Filter um nur MP3 Files auswaehlen zu koennen
 * - MP3Player: Hauptklasse mit allen Funktionen des MP3 Players, wie play(),skip(),...
 * - Playlist: Klasse zum Erstellen von Playlistobjekten
 * - Track: Klasse zum Erstelln von Trackobjekten
 * - Repository: Erstellen und Organisieren von hinzufuegbaren Files, Tracks, Playlisten
 * - TrackNotFoundException: Exception zum Abfangen, falls ein Track nicht gefunden wurde
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class Controller {

    public static void main(String[] args) throws TrackNotFoundEx, BasicPlayerException {
        
        // MP3Player erzeugen
        MP3Player player = new MP3Player();
        
        // Repository initialisieren
        Repository rep = new Repository (player);

        // GUI starten        
        Controller application = new Controller();
        MyGUI myGUI = new MyGUI(application, player, rep);
        myGUI.setVisible(true);
    }  
}