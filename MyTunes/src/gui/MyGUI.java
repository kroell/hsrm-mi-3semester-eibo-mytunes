package gui;

import controller.Controller;
import exceptions.TrackNotFoundEx;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import objects.MP3Filter;
import objects.MP3Player;
import objects.Playlist;
import objects.Repository;
import objects.PlaylistTable;

/**
 * 
 * MyGUI.java
 * 
 * Klasse zum Darstellen der MP3Player GUI
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class MyGUI extends javax.swing.JFrame implements Observer {

    private Controller application;
    private MP3Player player;
    private Repository rep;
    private DefaultListModel listModell = new DefaultListModel();
    private DefaultListModel titelInList = new DefaultListModel();
    private String playlistName;
    private Playlist newPlaylist;
    private DefaultTableModel myModel = new DefaultTableModel();
    private File selectedfile;
    private PlaylistTable pT;
    private LyricsFrame lF = new LyricsFrame();
    private Object o;
    private int playlistCounter = 0;
    private boolean mute = false;

    // Default Konstruktor
    public MyGUI() {
        initComponents();
    }

    // Angepasster Konstruktor
    public MyGUI(Controller application, MP3Player player, Repository rep) throws TrackNotFoundEx {
        this.application = application;
        this.player = player;
        this.rep = rep;
        player.addObserver(this);
        initComponents();
        // neues Tabellenmodell zur Darstellung des Playlistinhalt
        pT = new PlaylistTable(myModel, playlistTable, newPlaylist);
        pT.createPlaylistTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jDialog1 = new javax.swing.JDialog();
        jFileChooser3 = new javax.swing.JFileChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        jOptionPane2 = new javax.swing.JOptionPane();
        jLabel5 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        volSlider = new javax.swing.JSlider();
        coverLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        skipBackButton = new javax.swing.JButton();
        skipButton = new javax.swing.JButton();
        textPlaylist = new javax.swing.JLabel();
        playPositionTotal = new javax.swing.JLabel();
        playPosition = new javax.swing.JLabel();
        text = new javax.swing.JLabel();
        albumTitle = new javax.swing.JLabel();
        bandName = new javax.swing.JLabel();
        plusButton = new javax.swing.JButton();
        makePlaylistButton = new javax.swing.JButton();
        lyricsButton = new javax.swing.JButton();
        playlistLabel = new javax.swing.JLabel();
        byLabel = new javax.swing.JLabel();
        albumLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        playlistList = new javax.swing.JList();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        playlistTable = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        muteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        minimizeItem = new javax.swing.JMenu();
        aboutMyTunes = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        addTrackItemMenu = new javax.swing.JMenu();
        createNewPlaylistItem = new javax.swing.JMenuItem();
        addTrackMenuItem = new javax.swing.JMenuItem();
        showLyricsMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        playTrackItem = new javax.swing.JMenuItem();
        pauseTrackItem = new javax.swing.JMenuItem();
        skipTrackItem = new javax.swing.JMenuItem();
        skipBackItem = new javax.swing.JMenuItem();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 11));
        jLabel5.setForeground(new java.awt.Color(180, 180, 180));
        jLabel5.setText("Playlist");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyTunes - MP3 Player");
        setBackground(new java.awt.Color(46, 46, 46));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(progressBar);
        progressBar.setBounds(190, 150, 160, 20);

        volSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volSliderStateChanged(evt);
            }
        });
        getContentPane().add(volSlider);
        volSlider.setBounds(170, 440, 190, 40);

        coverLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/mytunes150.jpg"))); // NOI18N
        getContentPane().add(coverLabel);
        coverLabel.setBounds(20, 20, 150, 150);

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/play_button3.png"))); // NOI18N
        playButton.setBorder(null);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton);
        playButton.setBounds(220, 100, 50, 50);

        pauseButton.setBackground(new java.awt.Color(47, 47, 46));
        pauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/pause_button.png"))); // NOI18N
        pauseButton.setBorder(null);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pauseButton);
        pauseButton.setBounds(260, 100, 50, 50);

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/stop_button.png"))); // NOI18N
        stopButton.setBorder(null);
        stopButton.setPreferredSize(new java.awt.Dimension(50, 50));
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(300, 100, 50, 50);

        skipBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/skipback_button.png"))); // NOI18N
        skipBackButton.setBorder(null);
        skipBackButton.setMaximumSize(new java.awt.Dimension(50, 50));
        skipBackButton.setMinimumSize(new java.awt.Dimension(50, 50));
        skipBackButton.setPreferredSize(new java.awt.Dimension(50, 50));
        skipBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(skipBackButton);
        skipBackButton.setBounds(180, 100, 50, 50);

        skipButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/skipforward_button.png"))); // NOI18N
        skipButton.setBorder(null);
        skipButton.setPreferredSize(new java.awt.Dimension(50, 50));
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(skipButton);
        skipButton.setBounds(340, 100, 50, 50);

        textPlaylist.setFont(new java.awt.Font("Lucida Grande", 2, 12));
        textPlaylist.setForeground(new java.awt.Color(160, 160, 160));
        textPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textPlaylist.setText("Playlist");
        getContentPane().add(textPlaylist);
        textPlaylist.setBounds(490, 90, 140, 20);

        playPositionTotal.setFont(new java.awt.Font("Lucida Grande", 0, 7));
        playPositionTotal.setForeground(new java.awt.Color(255, 255, 255));
        playPositionTotal.setText("0:00");
        getContentPane().add(playPositionTotal);
        playPositionTotal.setBounds(500, 160, 14, 9);

        playPosition.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        playPosition.setForeground(new java.awt.Color(255, 255, 255));
        playPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        playPosition.setText("0:00");
        getContentPane().add(playPosition);
        playPosition.setBounds(350, 150, 30, 20);

        text.setFont(new java.awt.Font("Lucida Grande", 1, 16));
        text.setForeground(new java.awt.Color(255, 255, 255));
        text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text.setText("Track");
        getContentPane().add(text);
        text.setBounds(188, 22, 200, 20);

        albumTitle.setFont(new java.awt.Font("Lucida Grande", 2, 12));
        albumTitle.setForeground(new java.awt.Color(160, 160, 160));
        albumTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        albumTitle.setText("Album");
        getContentPane().add(albumTitle);
        albumTitle.setBounds(240, 70, 140, 15);

        bandName.setFont(new java.awt.Font("Lucida Grande", 2, 12));
        bandName.setForeground(new java.awt.Color(160, 160, 160));
        bandName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bandName.setText("Band");
        getContentPane().add(bandName);
        bandName.setBounds(210, 50, 170, 15);

        plusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/plus_button.png"))); // NOI18N
        plusButton.setBorder(null);
        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(plusButton);
        plusButton.setBounds(50, 440, 50, 40);

        makePlaylistButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/list_button3.png"))); // NOI18N
        makePlaylistButton.setBorder(null);
        makePlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePlaylistButtonActionPerformed(evt);
            }
        });
        getContentPane().add(makePlaylistButton);
        makePlaylistButton.setBounds(20, 440, 40, 40);

        lyricsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/lyrics_button2.png"))); // NOI18N
        lyricsButton.setBorder(null);
        lyricsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lyricsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(lyricsButton);
        lyricsButton.setBounds(90, 440, 40, 40);

        playlistLabel.setFont(new java.awt.Font("Lucida Grande", 1, 12));
        playlistLabel.setForeground(new java.awt.Color(180, 180, 180));
        playlistLabel.setText("Playlist");
        getContentPane().add(playlistLabel);
        playlistLabel.setBounds(490, 70, 50, 16);

        byLabel.setFont(new java.awt.Font("Lucida Grande", 1, 12));
        byLabel.setForeground(new java.awt.Color(180, 180, 180));
        byLabel.setText("By");
        getContentPane().add(byLabel);
        byLabel.setBounds(190, 50, 30, 15);

        albumLabel.setFont(new java.awt.Font("Lucida Grande", 1, 12));
        albumLabel.setForeground(new java.awt.Color(180, 180, 180));
        albumLabel.setText("Album");
        getContentPane().add(albumLabel);
        albumLabel.setBounds(190, 70, 41, 15);

        playlistList.setBackground(new java.awt.Color(46, 46, 46));
        playlistList.setForeground(new java.awt.Color(255, 255, 255));
        playlistList.setModel(listModell);
        playlistList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        playlistList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(playlistList);

        jScrollPane1.setBounds(10, 0, 330, 180);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("PLAYLISTS", jLayeredPane1);

        playlistTable.setModel(myModel);
        playlistTable.getTableHeader().setReorderingAllowed(false);
        playlistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(playlistTable);

        jScrollPane3.setBounds(10, 0, 330, 180);
        jLayeredPane2.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("TITEL IN PLAYLIST", jLayeredPane2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 211, 370, 239);

        muteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/mute.png"))); // NOI18N
        muteButton.setBorder(null);
        muteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(muteButton);
        muteButton.setBounds(350, 440, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/schatten.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 180, 200);

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/pics/bg.jpg"))); // NOI18N
        getContentPane().add(backgroundImage);
        backgroundImage.setBounds(0, 0, 460, 570);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 11));
        jLabel3.setForeground(new java.awt.Color(180, 180, 180));
        jLabel3.setText("Playlist");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 80, 41, 16);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 11));
        jLabel4.setForeground(new java.awt.Color(180, 180, 180));
        jLabel4.setText("Playlist");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 80, 41, 16);

        menuBar.setBackground(new java.awt.Color(46, 46, 46));

        minimizeItem.setBackground(new java.awt.Color(46, 46, 46));
        minimizeItem.setText("MyTunes");

        aboutMyTunes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        aboutMyTunes.setText("About MyTunes");
        aboutMyTunes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMyTunesMouseClicked(evt);
            }
        });
        aboutMyTunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMyTunesActionPerformed(evt);
            }
        });
        minimizeItem.add(aboutMyTunes);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Exit MyTunes");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        minimizeItem.add(exitItem);

        menuBar.add(minimizeItem);

        addTrackItemMenu.setBackground(new java.awt.Color(46, 46, 46));
        addTrackItemMenu.setText("File");

        createNewPlaylistItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        createNewPlaylistItem.setText("New Playlist");
        createNewPlaylistItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewPlaylistItemActionPerformed(evt);
            }
        });
        addTrackItemMenu.add(createNewPlaylistItem);

        addTrackMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        addTrackMenuItem.setText("Add Track");
        addTrackMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrackMenuItemActionPerformed(evt);
            }
        });
        addTrackItemMenu.add(addTrackMenuItem);

        showLyricsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        showLyricsMenuItem.setText("Show Lyrics");
        showLyricsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLyricsMenuItemActionPerformed(evt);
            }
        });
        addTrackItemMenu.add(showLyricsMenuItem);

        menuBar.add(addTrackItemMenu);

        jMenu1.setBackground(new java.awt.Color(46, 46, 46));
        jMenu1.setText("Track");

        playTrackItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.ALT_MASK));
        playTrackItem.setText("Play Track");
        playTrackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playTrackItemActionPerformed(evt);
            }
        });
        jMenu1.add(playTrackItem);

        pauseTrackItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.ALT_MASK));
        pauseTrackItem.setText("Pause Track");
        pauseTrackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseTrackItemActionPerformed(evt);
            }
        });
        jMenu1.add(pauseTrackItem);

        skipTrackItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.ALT_MASK));
        skipTrackItem.setText("Skip Track");
        skipTrackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipTrackItemActionPerformed(evt);
            }
        });
        jMenu1.add(skipTrackItem);

        skipBackItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.ALT_MASK));
        skipBackItem.setText("Skipback Track");
        skipBackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBackItemActionPerformed(evt);
            }
        });
        jMenu1.add(skipBackItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-402)/2, (screenSize.height-532)/2, 402, 532);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Pausieren des aktuell spielenden Tracks initialisieren
     */
    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        new Thread() {

            public void run() {
                try {
                    player.pause();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BasicPlayerException ex) {
                    Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }//GEN-LAST:event_pauseButtonActionPerformed

    /**
     * Stoppen des aktuell spielenden Songs initialisieren
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Reset der ProgressBar und der Darstellung der aktuellen Position
        progressBar.setValue(0);
        playPosition.setText("0:00");
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * Skip Back der Tracks innerhalb der Playlist initialisieren
     */
    private void skipBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBackButtonActionPerformed
        try {
            player.skipBack();
        } catch (TrackNotFoundEx ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Autakes Aktualisieren der GUI Informationen
        new Thread() {

            public void run() {
                updateGUI();
            }
        }.start();

    }//GEN-LAST:event_skipBackButtonActionPerformed

    /**
     * Skip Forward der Tracks innerhalb der Playlist initialisieren
     */
    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed

        try {
            player.skip();
        } catch (TrackNotFoundEx ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Autakes Aktualisieren der GUI Informationen
        new Thread() {

            public void run() {
                updateGUI();
            }
        }.start();
    }//GEN-LAST:event_skipButtonActionPerformed

    /**
     * Festlegen der aktuellen Lautstaerke des Players, wenn der Player am Spielen ist
     */
    private void volSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volSliderStateChanged
        if (player.getIsPlaying() == true) {
            new Thread() {

                public void run() {
                    try {
                        player.volume((double) volSlider.getValue() / 100);

                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
    }//GEN-LAST:event_volSliderStateChanged

    /**
     * Hinzufuegen eines neuen Tracks zur Playlist mit Hilfe eines JFileChooser
     */
    private void plusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButtonActionPerformed

        try {
            // aktuelle Selektion als Index verwenden
            int index = playlistList.getSelectedIndex();
            o = playlistList.getModel().getElementAt(index);

            // Initialisieren des FileChoosers
            final JFileChooser fc = new JFileChooser();
            // Filter erzeugen, so dass nur .mp3 Files geladen werden koennen
            MP3Filter mp3Filter = new MP3Filter("MP3 Files", new String[]{".mp3"});
            fc.setFileFilter(mp3Filter);
            fc.setMultiSelectionEnabled(false);
            // Current Pfad festlegen
            fc.setCurrentDirectory(new File("/Users/"));

            int retVal = fc.showOpenDialog(jDialog1);
            if (retVal == JFileChooser.APPROVE_OPTION) {

                selectedfile = fc.getSelectedFile();

                Playlist aktPlaylist = rep.getPlaylistByIndex(index);

                // wenn die markierte Playlist innerhalb der ArrayList mit allen Playlists vorhanden ist
                if (aktPlaylist.getPTitle().equals(o.toString())) {

                    // Mit ausgewaehltem File Tracks im Repository erstellen
                    rep.createPlaylist(selectedfile.getPath(), aktPlaylist);

                    player.insert(aktPlaylist);
                    pT.setPlaylist(aktPlaylist);

                    // Aktualisiere das JTable playlistTable mit den Inhalten der markierten Playlist
                    pT.updateRows(aktPlaylist, playlistList, player);
                }
            }
        } catch (Exception e) {
            // Wenn ein Track hinzugefuegt werden soll, aber keine Playlist vorhanden ist
            // wird eine Warnmeldung angezeigt
            JOptionPane.showMessageDialog(null, "Bitte legen Sie zuerst eine Playlist an!", "Warnhinweis", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/data/pics/mytunes_50.png"));
        }
    }//GEN-LAST:event_plusButtonActionPerformed

    /**
     * Abspielen des aktuellen Tracks bzw. Resume wenn der Song pausiert ist initialisieren
     * 
     */
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed

        if (!player.getIsPaused()) {
            try {
                player.play();
            } catch (TrackNotFoundEx ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                player.resume();
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Autakes Aktualisieren der GUI Informationen
        new Thread() {

            public void run() {
                updateGUI();
            }
        }.start();



    }//GEN-LAST:event_playButtonActionPerformed

    /**
     * Erstellt eine neue Playlist mit dem eingegebenen Namen und zeigt diesen
     * in der Liste an
     * 
     */
    private void makePlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePlaylistButtonActionPerformed
        // PlaylistName ergibt sich aus der Eingabe im JDialog Fenster
        playlistName = JOptionPane.showInputDialog("Playlistnamen eingeben");

        // Namenscheck, damit nicht zweimal der gleiche Playlistname verwendet werden kann
        if (rep.isEmpty()) {
            newPlaylist = new Playlist(playlistName);
        } else {
            playlistName = rep.playlistNameCheck(playlistName);
            newPlaylist = new Playlist(playlistName);
        }

        rep.allPlaylistsAdd(newPlaylist);
        // Es kann immer nur eine Playlist ausgewaehlt werden, nicht mehrere
        playlistList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Playlistname in die Liste schreiben
        listModell.addElement(newPlaylist.getPTitle());

        // Inhalt der PlaylistTable loeschen, wenn mindestens ein Element vorhanden ist
        if (myModel.getRowCount() > 0) {
            pT.deleteRow();
        }
        // Track ID wieder auf 0 setzen, da die Track ID in der neuen Darstellung der Tabelle
        // wieder bei 1 beginnen soll
        pT.setIdCounter(0);

        // Das zuletzt erstelle Element wird markiert
        playlistList.setSelectedIndex(playlistCounter);
        playlistCounter++;
    }//GEN-LAST:event_makePlaylistButtonActionPerformed

    /**
     * Bei einmaligem Klicken wird der Inhalt der playlistTable auf den Inhalt der Playlist aktualisiert
     * 
     * Bei zweimaligem Klicken wird der ausgewaehlte Track abgespielt und die dazugehoerige Playlist in
     * den Player geladen
     * 
     */
    private void playlistListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistListMouseClicked

        // Aktuell ausgewaehltes Element
        int index = playlistList.locationToIndex(evt.getPoint());
        //Objekt o entspricht Playlistname
        o = playlistList.getModel().getElementAt(index);

        // Beim Auswaehlen anzeigen des Playlistinhalts
        // Aktualisieren des Playlistinhalts in der playlistTable
        if (evt.getClickCount() == 1) {

            if (index >= 0) {

                for (Playlist aktPlaylist : rep.getAllePlaylists()) {

                    try {
                        // wenn die markierte Playlist innerhalb der ArrayList mit allen Playlists vorhanden ist
                        if (aktPlaylist.getPTitle().equals(o.toString())) {

                            player.insert(aktPlaylist);
                            pT.setPlaylist(aktPlaylist);

                            // Aktualisiere das JTable playlistTable mit den Inhalten der markierten Playlist
                            pT.updateRows(aktPlaylist, playlistList, player);
                        }
                    } catch (Exception e) {
                        System.out.print("Stringvergleich-Fehler\n");
                    }
                }
            }
        }

        // Beim Doppelklick auf Playlist abspielen des ersten Songs der Playlist
        if (evt.getClickCount() == 2) {

            if (index >= 0) {

                for (Playlist aktPlaylist : rep.getAllePlaylists()) {
                    try {
                        // wenn die markierte Playlist innerhalb der ArrayList mit allen Playlists vorhanden ist
                        if (aktPlaylist.getPTitle().equals(o.toString())) {
                            player.insert(aktPlaylist);
                            pT.setPlaylist(aktPlaylist);
                        }
                    } catch (Exception e) {
                        System.out.print("Stringvergleich-Fehler\n");
                    }
                }
                // Abspielen, wenn der Player nicht am spielen ist
                if (!player.getIsPlaying()) {
                    try {
                        player.play();
                    } catch (TrackNotFoundEx ex) {
                        Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } // Sonst vorher das Spielen stoppen und dann den Track abspielen
                else {
                    try {
                        player.stop();
                        player.play();
                    } catch (TrackNotFoundEx ex) {
                        Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_playlistListMouseClicked

    /**
     * Bei einmaligem Klicken eines Elements werden die LyricInformationen in das LyricFrame geschrieben
     * 
     * Bei zweimaligem Klicken wird der ausgewaehlte Track abgespielt und die dazugehoerige Playlist in
     * den Player geladen
     *  
     */
    private void playlistTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistTableMouseClicked

        // Auswahl des aktuellen Trackelements
        int row = playlistTable.getSelectedRow();
        String aktTrackNr = (String) playlistTable.getValueAt(row, 0);
        int aktuelleTrackNr = Integer.parseInt(aktTrackNr);

        // Einmal anklicken
        // Zum Befuellen des LyricFrames, sofern diese im MP3File vorhanden sind
        if (evt.getClickCount() == 1) {

            try {
                lF.getLyricsField().setText(newPlaylist.getTrackByIndex(aktuelleTrackNr - 1).getLyrics());
            } catch (TrackNotFoundEx ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Zweimal anklicken
        // Angelickter Song wird abgespielt und die dazugehoerige Playlist in den Player geladen
        if (evt.getClickCount() == 2) {

            try {
                // Setze den aktuellen Track auf die Auswahl
                player.setAtkTrackNr(aktuelleTrackNr - 1);

                // Abspielen, wenn der Player nicht am spielen ist
                if (!player.getIsPlaying()) {
                    player.play();
                } // Sonst vorher das Spielen stoppen und dann den Track abspielen
                else {
                    player.stop();
                    player.play();
                }
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TrackNotFoundEx ex) {
                Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_playlistTableMouseClicked

    /**
     * Beim Klicken des Lyric Buttons wird das Fenster LyricFrame geoeffnet
     * und beim ausgwaehlten Track, sofern vorhanden, die LyricInformationen
     * angezeigt
     */
    private void lyricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lyricsButtonActionPerformed
        // LyricFrame anzeigen
        lF.setVisible(true);
    }//GEN-LAST:event_lyricsButtonActionPerformed

    private void aboutMyTunesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMyTunesMouseClicked
    }//GEN-LAST:event_aboutMyTunesMouseClicked

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void createNewPlaylistItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewPlaylistItemActionPerformed
        makePlaylistButtonActionPerformed(evt);
    }//GEN-LAST:event_createNewPlaylistItemActionPerformed

    private void showLyricsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLyricsMenuItemActionPerformed
        lyricsButtonActionPerformed(evt);
    }//GEN-LAST:event_showLyricsMenuItemActionPerformed

    private void playTrackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playTrackItemActionPerformed
        playButtonActionPerformed(evt);
    }//GEN-LAST:event_playTrackItemActionPerformed

    private void pauseTrackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseTrackItemActionPerformed
        pauseButtonActionPerformed(evt);
    }//GEN-LAST:event_pauseTrackItemActionPerformed

    private void skipTrackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipTrackItemActionPerformed
        skipButtonActionPerformed(evt);
    }//GEN-LAST:event_skipTrackItemActionPerformed

    private void skipBackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBackItemActionPerformed
        skipBackButtonActionPerformed(evt);
    }//GEN-LAST:event_skipBackItemActionPerformed

    private void addTrackMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrackMenuItemActionPerformed

        plusButtonActionPerformed(evt);     }//GEN-LAST:event_addTrackMenuItemActionPerformed

    private void muteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteButtonActionPerformed
        try {
            if (player.getIsPlaying() == true) {
                // Mute einschalten
                if (mute == false) {
                    player.volume(0);
                    volSlider.setValue(0);
                    mute = true;
                } // Mute ausschalten und Volume auf 0.5 setzen
                else {
                    player.volume(0.5);
                    volSlider.setValue(50);
                    mute = false;
                }
            }
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_muteButtonActionPerformed

    /**
     * Darstellen des AboutFrame mit den Informationen zum Programm
     */
    private void aboutMyTunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMyTunesActionPerformed
        AboutFrame aF = new AboutFrame();
        aF.setVisible(true);
    }//GEN-LAST:event_aboutMyTunesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMyTunes;
    private javax.swing.JMenu addTrackItemMenu;
    private javax.swing.JMenuItem addTrackMenuItem;
    private javax.swing.JLabel albumLabel;
    private javax.swing.JLabel albumTitle;
    private javax.swing.JLabel backgroundImage;
    private javax.swing.JLabel bandName;
    private javax.swing.JLabel byLabel;
    private javax.swing.JLabel coverLabel;
    private javax.swing.JMenuItem createNewPlaylistItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JFileChooser jFileChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lyricsButton;
    private javax.swing.JButton makePlaylistButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu minimizeItem;
    private javax.swing.JButton muteButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JMenuItem pauseTrackItem;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel playPosition;
    private javax.swing.JLabel playPositionTotal;
    private javax.swing.JMenuItem playTrackItem;
    private javax.swing.JLabel playlistLabel;
    private javax.swing.JList playlistList;
    private javax.swing.JTable playlistTable;
    private javax.swing.JButton plusButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem showLyricsMenuItem;
    private javax.swing.JButton skipBackButton;
    private javax.swing.JMenuItem skipBackItem;
    private javax.swing.JButton skipButton;
    private javax.swing.JMenuItem skipTrackItem;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel text;
    private javax.swing.JLabel textPlaylist;
    private javax.swing.JSlider volSlider;
    // End of variables declaration//GEN-END:variables

    // Ueberschrieben Observer Update Methode
    public void update(Observable o, Object o1) {

        // ProgressBar mittels der Timerinformationen befuellen
        int value = (Integer) o1;
        progressBar.setValue(value);

        // Beschriftung neben der ProgressBar mit der aktuellen Spielzeit
        int minutePos = value / 60;
        int sekundePos = value % 60;

        String minString = String.valueOf(minutePos);
        String sekString = String.valueOf(sekundePos);

        if (sekundePos < 10) {
            playPosition.setText(minString + ":0" + sekString);
        } else {
            playPosition.setText(minString + ":" + sekString);
        }

        // GUI Elemente parallel erneuern
        new Thread() {

            public void run() {
                updateGUI();
            }
        }.start();
    }

    /**
     * Zum Aktualisieren aller GUI Elemente
     * 
     */
    public void updateGUI() {

        try {
            // Aktueller Playlisttitel
            textPlaylist.setText(player.playlistInfo());
            // Aktuelles Cover
            coverLabel.setIcon(player.getAktTrack().getCoverFile());
            // Aktueller Tracktitel
            text.setText(player.getAktTrack().getTTitle());
            // Aktueller Albumtitel
            albumTitle.setText(player.getAktTrack().getAlbumTitle());
            // Aktueller Bandname
            bandName.setText(player.getAktTrack().getBand());
            // Zeile mit dem aktuellen Song in der playlistTable markieren
            playlistTable.setRowSelectionInterval(player.getAktTrack().getTId() - 1, player.getAktTrack().getTId() - 1);

            if (player.getAktTrack() != null) {
                // Maximum der progressBar mittels der Laenge des aktuellen Tracks festlegen
                progressBar.setMaximum(player.getAktTrack().getTLength());
                int aktVol = (int) (player.getVolume() * 100);
                volSlider.setValue(aktVol);
            }
        } catch (Exception ex) {
            System.out.print("Kein Track ausgewählt!\n");
        }
    }
}
