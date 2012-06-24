package gui;

import javax.swing.JTextArea;

/**
 *
 * LyricsFrame.java
 * 
 * Klasse zum Erstellen eines JFrames zur Darstellung der Tracklyrics,
 * sofern diese im MP3 File hinterlegt sind.
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class LyricsFrame extends javax.swing.JFrame {
    
    // Konstruktor
    public LyricsFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lyricsField = new javax.swing.JTextArea();
        headPlaylist = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(47, 47, 47));
        getContentPane().setLayout(null);

        lyricsField.setColumns(20);
        lyricsField.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        lyricsField.setRows(5);
        jScrollPane1.setViewportView(lyricsField);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 44, 336, 351);

        headPlaylist.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        headPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        headPlaylist.setText("LYRICS:");
        getContentPane().add(headPlaylist);
        headPlaylist.setBounds(20, 20, 49, 16);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/bg.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 390, 420);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-377)/2, (screenSize.height-437)/2, 377, 437);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel headPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lyricsField;
    // End of variables declaration//GEN-END:variables

    public JTextArea getLyricsField(){
        return lyricsField;
    }
}
