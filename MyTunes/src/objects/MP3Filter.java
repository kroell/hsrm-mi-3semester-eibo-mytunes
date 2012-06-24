package objects;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * MP3Filter.java
 * 
 * Klasse zum Erstellen eines MP3 File Filter, so dass im FileChooser
 * ausschliesslich MP3 Files ausgewaehlt und geladen werden koennen
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class MP3Filter extends FileFilter {

    private String[] extensions;
    private String description;

    // Konstruktor
    public MP3Filter(String description, String[] extensions) {
        this.description = description;
        this.extensions = extensions;

        // Um Gross- und Kleinschreibungsprobleme zu umgehen
        for (int i = 0, len = extensions.length; i < len; i++) {
            extensions[i].toLowerCase();
        }
    }

    // Abgleich um ein File akzeptiert wird oder nicht    
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        } else {
            String path = f.getAbsolutePath().toLowerCase();
            for (int i = 0, len = extensions.length; i < len; i++) {
                if ((path.endsWith(extensions[i]))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
