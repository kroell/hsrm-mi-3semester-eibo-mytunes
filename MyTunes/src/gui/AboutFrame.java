package gui;

/**
 *
 * AboutFrame.java
 * 
 * Klasse zum Erstellen eines JFrames zur Darstellung allgemeinen
 * Informationen zum Programm
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class AboutFrame extends javax.swing.JFrame {

    // Konstruktor
    public AboutFrame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myTunesLogo = new javax.swing.JLabel();
        myTunesHeadline = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        writtenLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();

        setTitle("About MyTunes");
        setBackground(new java.awt.Color(255, 255, 255));

        myTunesLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/myTunesAbout.png"))); // NOI18N

        myTunesHeadline.setFont(new java.awt.Font("Lucida Grande", 1, 24));
        myTunesHeadline.setText("MyTunes");

        versionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        versionLabel.setText("Version 27.01.2012");

        writtenLabel.setForeground(new java.awt.Color(153, 153, 153));
        writtenLabel.setText("Written by");

        authorLabel.setForeground(new java.awt.Color(153, 153, 153));
        authorLabel.setText("S. Kroell, A. Hasselbach, N. Emmel");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(myTunesLogo)
                .add(32, 32, 32)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(myTunesHeadline)
                    .add(versionLabel)
                    .add(writtenLabel)
                    .add(authorLabel))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(myTunesLogo)
                .addContainerGap(29, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .add(myTunesHeadline)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(versionLabel)
                .add(26, 26, 26)
                .add(writtenLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(authorLabel)
                .add(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel myTunesHeadline;
    private javax.swing.JLabel myTunesLogo;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JLabel writtenLabel;
    // End of variables declaration//GEN-END:variables
}
