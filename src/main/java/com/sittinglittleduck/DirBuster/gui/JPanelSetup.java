/*
 * NewJPanelSetup.java
 *
 * Copyright 2007 James Fisher
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA
 */
package com.sittinglittleduck.DirBuster.gui;

import com.sittinglittleduck.DirBuster.ExtToCheck;
import com.sittinglittleduck.DirBuster.Manager;
import com.sittinglittleduck.DirBuster.gui.documentListeners.DirStartDocumentListener;
import com.sittinglittleduck.DirBuster.gui.documentListeners.FileExtDocumentListener;
import com.sittinglittleduck.DirBuster.gui.documentListeners.TargetDocumentListener;
import com.sittinglittleduck.DirBuster.gui.documentListeners.UrlFuzzDocumentListener;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

public class JPanelSetup extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroupStartPointConfig;
    public javax.swing.ButtonGroup buttonGroupWorkMethod;
    public javax.swing.JButton jButtonBrowse;
    public javax.swing.JButton jButtonExit;
    public javax.swing.JButton jButtonListInfo;
    public javax.swing.JButton jButtonStart;
    public javax.swing.JCheckBox jCheckBoxDoFiles;
    public javax.swing.JCheckBox jCheckBoxGoFast;
    public javax.swing.JCheckBox jCheckBoxRecursive;
    public javax.swing.JCheckBox jCheckBoxUseBlankExt;
    public javax.swing.JCheckBox jCheckBoxdoDirs;
    public javax.swing.JComboBox jComboBoxCharSet;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelFuzzTitle;
    public javax.swing.JLabel jLabelList;
    public javax.swing.JLabel jLabelPureBrute1;
    public javax.swing.JLabel jLabelPureBrute2;
    public javax.swing.JLabel jLabelPureBrute3;
    public javax.swing.JLabel jLabelThreadsDisplay;
    public javax.swing.JRadioButton jRadioButtonAuto;
    public javax.swing.JRadioButton jRadioButtonGET;
    public javax.swing.JRadioButton jRadioButtonListBased;
    public javax.swing.JRadioButton jRadioButtonPureBrute;
    public javax.swing.JRadioButton jRadioButtonStandardStart;
    public javax.swing.JRadioButton jRadioButtonURLFuzz;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JSeparator jSeparator4;
    public javax.swing.JSlider jSliderThreads;
    public javax.swing.JTextField jTextFieldDirToStart;
    public javax.swing.JTextField jTextFieldFile;
    public javax.swing.JTextField jTextFieldFileExtention;
    public javax.swing.JTextField jTextFieldMaxLength;
    public javax.swing.JTextField jTextFieldMin;
    public javax.swing.JTextField jTextFieldTarget;
    public javax.swing.JTextField jTextFieldURLFuzz;
    StartGUI parent;
    private String host;
    private int port;
    private String protocol;
    private String startPoint;
    private String[] charSet1 =
            {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            };
    private String[] charSet0 =
            {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                    "%20", "-", "_"
            };
    private String[] charSet2 =
            {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            };
    private String[] charSet3 =
            {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            };
    private boolean fileExtChanged = false;
    private boolean dirToStartWithChanged = false;
    private boolean urlFuzzChanged = false;
    private String fuzzStart = "";
    private String fuzzEnd = "";
    private Manager manager;
    /**
     * Creates new form NewJPanelSetup
     */
    public JPanelSetup(StartGUI Parent) {
        parent = Parent;
        initComponents();
        jTextFieldTarget.getDocument().addDocumentListener(new TargetDocumentListener(this));
        jTextFieldDirToStart.getDocument().addDocumentListener(new DirStartDocumentListener(this));
        jTextFieldFileExtention.getDocument().addDocumentListener(new FileExtDocumentListener(this));
        jTextFieldURLFuzz.getDocument().addDocumentListener(new UrlFuzzDocumentListener(this));

        manager = Manager.getInstance();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroupWorkMethod = new javax.swing.ButtonGroup();
        buttonGroupStartPointConfig = new javax.swing.ButtonGroup();
        jButtonStart = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTarget = new javax.swing.JTextField();
        jRadioButtonListBased = new javax.swing.JRadioButton();
        jRadioButtonPureBrute = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonGET = new javax.swing.JRadioButton();
        jRadioButtonAuto = new javax.swing.JRadioButton();
        jSliderThreads = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabelThreadsDisplay = new javax.swing.JLabel();
        jCheckBoxGoFast = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButtonStandardStart = new javax.swing.JRadioButton();
        jRadioButtonURLFuzz = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelPureBrute1 = new javax.swing.JLabel();
        jComboBoxCharSet = new javax.swing.JComboBox();
        jLabelPureBrute2 = new javax.swing.JLabel();
        jTextFieldMin = new javax.swing.JTextField();
        jLabelPureBrute3 = new javax.swing.JLabel();
        jTextFieldMaxLength = new javax.swing.JTextField();
        jTextFieldFile = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jButtonListInfo = new javax.swing.JButton();
        jLabelList = new javax.swing.JLabel();
        jCheckBoxdoDirs = new javax.swing.JCheckBox();
        jCheckBoxDoFiles = new javax.swing.JCheckBox();
        jCheckBoxRecursive = new javax.swing.JCheckBox();
        jCheckBoxUseBlankExt = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDirToStart = new javax.swing.JTextField();
        jTextFieldFileExtention = new javax.swing.JTextField();
        jLabelFuzzTitle = new javax.swing.JLabel();
        jTextFieldURLFuzz = new javax.swing.JTextField();

        jButtonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/media-playback-start.png"))); // NOI18N
        jButtonStart.setText("Start");
        jButtonStart.setToolTipText("Start DirBuster");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/door_out.png"))); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.setToolTipText("Exit DirBuster");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel3.setText("Target URL (eg http://example.com:80/)");

        jTextFieldTarget.setToolTipText("Enter target as a URL");

        buttonGroup1.add(jRadioButtonListBased);
        jRadioButtonListBased.setSelected(true);
        jRadioButtonListBased.setText("List based brute force");
        jRadioButtonListBased.setToolTipText("Select tp perform a list based brute force attack");
        jRadioButtonListBased.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonListBased.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonListBasedActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPureBrute);
        jRadioButtonPureBrute.setText("Pure Brute Force");
        jRadioButtonPureBrute.setToolTipText("Select to perform a pure brute force attack");
        jRadioButtonPureBrute.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButtonPureBrute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPureBruteActionPerformed(evt);
            }
        });

        jLabel5.setText("Work Method");

        buttonGroupWorkMethod.add(jRadioButtonGET);
        jRadioButtonGET.setText("Use GET requests only");
        jRadioButtonGET.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroupWorkMethod.add(jRadioButtonAuto);
        jRadioButtonAuto.setSelected(true);
        jRadioButtonAuto.setText("Auto Switch (HEAD and GET)");
        jRadioButtonAuto.setToolTipText("Enable auto switching between HEAD and GET requests");
        jRadioButtonAuto.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jSliderThreads.setMinimum(1);
        jSliderThreads.setMinorTickSpacing(5);
        jSliderThreads.setToolTipText("Set the number of threads to use");
        jSliderThreads.setValue(10);
        jSliderThreads.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderThreadsStateChanged(evt);
            }
        });

        jLabel6.setText("Number Of Threads");

        jLabelThreadsDisplay.setText("10 Threads");

        jCheckBoxGoFast.setText("Go Faster");
        jCheckBoxGoFast.setToolTipText("Enable this to use above 100 threads");
        jCheckBoxGoFast.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxGoFast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGoFastActionPerformed(evt);
            }
        });

        jLabel7.setText("Select scanning type:");

        jLabel4.setText("Select starting options:");

        buttonGroupStartPointConfig.add(jRadioButtonStandardStart);
        jRadioButtonStandardStart.setSelected(true);
        jRadioButtonStandardStart.setText("Standard start point");
        jRadioButtonStandardStart.setToolTipText("Scan using a standard start point");
        jRadioButtonStandardStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStandardStartActionPerformed(evt);
            }
        });

        buttonGroupStartPointConfig.add(jRadioButtonURLFuzz);
        jRadioButtonURLFuzz.setText("URL Fuzz");
        jRadioButtonURLFuzz.setToolTipText("Scan by performing a URL fuzz");
        jRadioButtonURLFuzz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonURLFuzzActionPerformed(evt);
            }
        });

        jLabelPureBrute1.setText("Char set");
        jLabelPureBrute1.setEnabled(false);

        jComboBoxCharSet.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"a-zA-Z0-9%20-_", "a-zA-Z0-9", "a-z0-9", "0-9"}));
        jComboBoxCharSet.setToolTipText("Select the char set to use for the bruteforce");
        jComboBoxCharSet.setEnabled(false);

        jLabelPureBrute2.setText("Min length");
        jLabelPureBrute2.setEnabled(false);

        jTextFieldMin.setText("1");
        jTextFieldMin.setToolTipText("Minium length for brute force");
        jTextFieldMin.setEnabled(false);

        jLabelPureBrute3.setText("Max Length");
        jLabelPureBrute3.setEnabled(false);

        jTextFieldMaxLength.setText("8");
        jTextFieldMaxLength.setToolTipText("Maximum length for brute force");
        jTextFieldMaxLength.setEnabled(false);

        jButtonBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/system-search.png"))); // NOI18N
        jButtonBrowse.setText("Browse");
        jButtonBrowse.setToolTipText("Browse for a list to be used");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jButtonListInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/information.png"))); // NOI18N
        jButtonListInfo.setText("List Info");
        jButtonListInfo.setToolTipText("Display information about the lists supplied with DirBuster");
        jButtonListInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListInfoActionPerformed(evt);
            }
        });

        jLabelList.setText("File with list of dirs/files");

        jCheckBoxdoDirs.setSelected(true);
        jCheckBoxdoDirs.setText("Brute Force Dirs");
        jCheckBoxdoDirs.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBoxDoFiles.setSelected(true);
        jCheckBoxDoFiles.setText("Brute Force Files");
        jCheckBoxDoFiles.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBoxDoFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDoFilesActionPerformed(evt);
            }
        });

        jCheckBoxRecursive.setSelected(true);
        jCheckBoxRecursive.setText("Be Recursive");
        jCheckBoxRecursive.setToolTipText("Continue brute forcing into all found directories");
        jCheckBoxRecursive.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBoxUseBlankExt.setText("Use Blank Extension");
        jCheckBoxUseBlankExt.setToolTipText("eg /test/index");
        jCheckBoxUseBlankExt.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel8.setText("Dir to start with");

        jLabel9.setText("File extension");
        jLabel9.setToolTipText("multiple extention can be added html,css,aspx,....");

        jTextFieldDirToStart.setText("/");
        jTextFieldDirToStart.setToolTipText("Select the start directory");

        jTextFieldFileExtention.setText("php");
        jTextFieldFileExtention.setToolTipText("multiple extention can be added html,css,aspx,....");

        jLabelFuzzTitle.setLabelFor(jTextFieldURLFuzz);
        jLabelFuzzTitle.setText("URL to fuzz - /test.html?url={dir}.asp");
        jLabelFuzzTitle.setEnabled(false);

        jTextFieldURLFuzz.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabelFuzzTitle)
                                                        .add(layout.createSequentialGroup()
                                                                .add(jLabelPureBrute1)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jComboBoxCharSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jLabelPureBrute2)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jTextFieldMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jLabelPureBrute3)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jTextFieldMaxLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                        .add(jSeparator2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                                                        .add(layout.createSequentialGroup()
                                                                .add(jLabel6)
                                                                .add(12, 12, 12)
                                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(layout.createSequentialGroup()
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                                .add(jRadioButtonGET)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                                .add(jRadioButtonAuto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 333, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                        .add(layout.createSequentialGroup()
                                                                                .add(jSliderThreads, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                                .add(jLabelThreadsDisplay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                                                .add(jCheckBoxGoFast, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                                .add(122, 122, 122))
                                                        .add(layout.createSequentialGroup()
                                                                .add(jLabel4)
                                                                .add(32, 32, 32)
                                                                .add(jRadioButtonStandardStart)
                                                                .add(18, 18, 18)
                                                                .add(jRadioButtonURLFuzz))
                                                        .add(layout.createSequentialGroup()
                                                                .add(jLabel7)
                                                                .add(48, 48, 48)
                                                                .add(jRadioButtonListBased)
                                                                .add(18, 18, 18)
                                                                .add(jRadioButtonPureBrute))
                                                        .add(jLabelList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 227, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(layout.createSequentialGroup()
                                                                .add(jTextFieldFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 525, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jButtonBrowse)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jButtonListInfo))
                                                        .add(jButtonExit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jTextFieldURLFuzz, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                                                        .add(jSeparator3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                                                        .add(jSeparator4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                                                        .add(layout.createSequentialGroup()
                                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(jCheckBoxdoDirs)
                                                                        .add(jCheckBoxDoFiles))
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 143, Short.MAX_VALUE)
                                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                                        .add(layout.createSequentialGroup()
                                                                                .add(1, 1, 1)
                                                                                .add(jCheckBoxRecursive, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                        .add(jCheckBoxUseBlankExt))
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 57, Short.MAX_VALUE)
                                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                                                .add(jLabel8)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                                .add(jTextFieldDirToStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                                                .add(jLabel9)
                                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                                .add(jTextFieldFileExtention, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jButtonStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(12, 12, 12))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .add(layout.createSequentialGroup()
                                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(770, Short.MAX_VALUE))
                                        .add(layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jTextFieldTarget, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                                                        .add(jLabel3))
                                                .addContainerGap())))
        );

        layout.linkSize(new java.awt.Component[]{jButtonExit, jButtonStart}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[]{jTextFieldMaxLength, jTextFieldMin}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldTarget, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel5)
                                        .add(jRadioButtonGET)
                                        .add(jRadioButtonAuto))
                                .add(22, 22, 22)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(jLabel6)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(jLabelThreadsDisplay)
                                                        .add(jCheckBoxGoFast)))
                                        .add(jSliderThreads, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jRadioButtonListBased)
                                        .add(jLabel7)
                                        .add(jRadioButtonPureBrute))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabelList)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jTextFieldFile, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jButtonBrowse)
                                        .add(jButtonListInfo))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabelPureBrute1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jComboBoxCharSet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabelPureBrute2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTextFieldMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabelPureBrute3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTextFieldMaxLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(12, 12, 12)
                                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel4)
                                        .add(jRadioButtonURLFuzz)
                                        .add(jRadioButtonStandardStart))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                                .add(jCheckBoxdoDirs)
                                                .add(15, 15, 15)
                                                .add(jCheckBoxDoFiles)
                                                .add(16, 16, 16)
                                                .add(jLabelFuzzTitle))
                                        .add(layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(jCheckBoxRecursive)
                                                        .add(jTextFieldDirToStart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jLabel8))
                                                .add(11, 11, 11)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                                .add(jLabel9)
                                                                .add(jCheckBoxUseBlankExt))
                                                        .add(jTextFieldFileExtention, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldURLFuzz, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(jSeparator4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jButtonExit)
                                        .add(jButtonStart))
                                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[]{jButtonExit, jButtonStart}, org.jdesktop.layout.GroupLayout.VERTICAL);

        layout.linkSize(new java.awt.Component[]{jButtonBrowse, jButtonListInfo}, org.jdesktop.layout.GroupLayout.VERTICAL);

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListInfoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonListInfoActionPerformed
    {//GEN-HEADEREND:event_jButtonListInfoActionPerformed
        new JDialogViewListInfo(parent, true).setVisible(true);
    }//GEN-LAST:event_jButtonListInfoActionPerformed

    private void jRadioButtonListBasedActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonListBasedActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonListBasedActionPerformed
        if (jRadioButtonListBased.isSelected()) {


            jLabelPureBrute1.setEnabled(false);
            jLabelPureBrute2.setEnabled(false);
            jLabelPureBrute3.setEnabled(false);
            jTextFieldMaxLength.setEnabled(false);
            jTextFieldMin.setEnabled(false);
            jComboBoxCharSet.setEnabled(false);

            jLabelList.setEnabled(true);
            jTextFieldFile.setEnabled(true);
            jButtonBrowse.setEnabled(true);
            jButtonListInfo.setEnabled(true);
            this.updateUI();
        }
    }//GEN-LAST:event_jRadioButtonListBasedActionPerformed

    private void jRadioButtonPureBruteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonPureBruteActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonPureBruteActionPerformed
        if (jRadioButtonPureBrute.isSelected()) {


            jLabelPureBrute1.setEnabled(true);
            jLabelPureBrute2.setEnabled(true);
            jLabelPureBrute3.setEnabled(true);
            jTextFieldMaxLength.setEnabled(true);
            jTextFieldMin.setEnabled(true);
            jComboBoxCharSet.setEnabled(true);

            jLabelList.setEnabled(false);
            jTextFieldFile.setEnabled(false);
            jButtonBrowse.setEnabled(false);
            jButtonListInfo.setEnabled(false);
            this.updateUI();
        }
    }//GEN-LAST:event_jRadioButtonPureBruteActionPerformed

    private void jCheckBoxGoFastActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxGoFastActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxGoFastActionPerformed
        if (jCheckBoxGoFast.isSelected()) {
            jSliderThreads.setMaximum(500);
            jSliderThreads.setValue(200);
        } else {
            jSliderThreads.setMaximum(100);
            jSliderThreads.setValue(10);
        }
    }//GEN-LAST:event_jCheckBoxGoFastActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonExitActionPerformed
    {//GEN-HEADEREND:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jCheckBoxDoFilesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxDoFilesActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxDoFilesActionPerformed
        if (jCheckBoxDoFiles.isSelected()) {
            jTextFieldFileExtention.setEnabled(true);
            jCheckBoxUseBlankExt.setEnabled(true);
        } else {
            jTextFieldFileExtention.setEnabled(false);
            jCheckBoxUseBlankExt.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxDoFilesActionPerformed

    private void jSliderThreadsStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSliderThreadsStateChanged
    {//GEN-HEADEREND:event_jSliderThreadsStateChanged
        jLabelThreadsDisplay.setText(jSliderThreads.getValue() + " Threads");
    }//GEN-LAST:event_jSliderThreadsStateChanged

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonBrowseActionPerformed
    {//GEN-HEADEREND:event_jButtonBrowseActionPerformed
        File dir = new File(System.getProperty("user.dir"));
        JFileChooser fc = new JFileChooser(dir);
        fc.setDialogTitle("Please Select The Directory/File List You Wish To Use");
        int returnVal = fc.showDialog(this, "Select List");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTextFieldFile.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonStartActionPerformed
    {//GEN-HEADEREND:event_jButtonStartActionPerformed

        /*
         * reset the error tab title
         */
        parent.jPanelRunning.jTabbedPaneViewResults.setTitleAt(3, "Errors: 0");
        manager.resetConErrorCounter();
        parent.jPanelRunning.jPanelScanInfoBase.removeAll();
        /*
         * Process any errors that we find
         */
        Vector errors = new Vector(0, 1);

        //check target URL is correctly formed
        try {
            URL targetURL = new URL(jTextFieldTarget.getText());
            processTarget();
        } catch (MalformedURLException ex) {
            errors.addElement("Your target is not a valid URL");
        }

        //check the host
        //host will be set by processTarget()
        if (host != null && !host.equalsIgnoreCase("")) {
            try {
                if (!manager.isUseProxy()) {
                    InetAddress tempAddress = InetAddress.getByName(host);
                } else {
                    InetAddress temAddress = InetAddress.getByName(manager.getProxyHost());
                }

            } catch (UnknownHostException e) {
                errors.addElement("Invalid or Unknown Host.  In other words the hostname does not resolve!");
            }
        } else {
            errors.addElement("You must include a host.");
        }

        //check the port
        //port will be set by processTarget()
        try {
            //port = Integer.parseInt(jTextFieldPort.getText());
            if (port < 1 || port > 65535) {
                errors.addElement("Port number must be between 1 and 65535.");
            }
        } catch (NumberFormatException e) {
            errors.addElement("Port number must be a number.");
        }

        String fileToRead = "";
        String[] charSet = charSet0;
        int maxLen = 8;
        int minLen = 1;
        if (jRadioButtonListBased.isSelected()) {
            //check the file
            fileToRead = jTextFieldFile.getText();
            if (fileToRead != null && !fileToRead.equalsIgnoreCase("")) {
                try {
                    FileInputStream test = new FileInputStream(new File(fileToRead));
                } catch (FileNotFoundException e) {
                    errors.addElement("Sorry can't open the file with the directory list in.");
                }
            } else {
                errors.addElement("You must supply a file/directory list to read from.");
            }
        } else {
            if (jComboBoxCharSet.getSelectedIndex() == 0) {
                charSet = charSet0;
            } else {
                if (jComboBoxCharSet.getSelectedIndex() == 1) {
                    charSet = charSet1;
                } else {
                    if (jComboBoxCharSet.getSelectedIndex() == 2) {
                        charSet = charSet2;
                    } else {
                        if (jComboBoxCharSet.getSelectedIndex() == 3) {
                            charSet = charSet3;
                        }
                    }
                }
            }

            try {
                minLen = Integer.parseInt(jTextFieldMin.getText());
                if (minLen < 1) {
                    errors.addElement("Min Length must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                errors.addElement("Min length must be a number.");
            }

            try {
                maxLen = Integer.parseInt(jTextFieldMaxLength.getText());
                if (maxLen < minLen) {
                    errors.addElement("Your max length must be less than your min length.");
                }
            } catch (NumberFormatException e) {
                errors.addElement("Max length must be a number.");
            }


        }

        //check the dir to start with, and make any nessary changes

        String dirToStartWith = jTextFieldDirToStart.getText();
        if (dirToStartWith.length() == 0) {
            dirToStartWith = "/";
        }
        if (!dirToStartWith.startsWith("/")) {
            dirToStartWith = "/" + dirToStartWith;
        }
        if (!dirToStartWith.endsWith("/")) {
            dirToStartWith = dirToStartWith + "/";
        }


        String fileExtention = "";
        Vector fileExts = new Vector(10, 5);

        if (jCheckBoxDoFiles.isSelected()) {
            fileExtention = jTextFieldFileExtention.getText();

            //see if there are multiple extentions

            if (fileExtention.trim().length() == 0 && !jCheckBoxUseBlankExt.isSelected()) {
                errors.addElement("If you are going to brute force files then you must say what the file extenetion is.");
            } else {
                /*
                 * all the blank ext
                 */
                if (jCheckBoxUseBlankExt.isSelected()) {
                    //fileExts.addElement(new ExtToCheck(ExtToCheck.BLANK_EXT, true));
                    fileExts.addElement(new ExtToCheck("", true));
                }

                //parse all the file extentions and add them to a vector
                StringTokenizer st = new StringTokenizer(fileExtention, ",", false);
                while (st.hasMoreTokens()) {

                    //System.out.println("ext = " + st.nextToken().trim());
                    fileExts.addElement(new ExtToCheck(st.nextToken().trim(), true));
                }
            }

        }


        int threadsNumber = jSliderThreads.getValue();


        //check the protcol
        if (protocol != null) {
            if (protocol.equals("")) {
                errors.addElement("Protocol is missing.  Can be either http or https");
            } else {
                if (!protocol.equalsIgnoreCase("http") && !protocol.equalsIgnoreCase("https")) {
                    errors.addElement("Protocol can be either http or https");
                }
            }
        } else {
            errors.addElement("Protocol is missing.  Can be either http or https");
        }

        if (!jCheckBoxdoDirs.isSelected() && !jCheckBoxDoFiles.isSelected()) {
            errors.addElement("You cant not chose to brute force nither files and dirs, as you wont attack anything!");
        }

        //checks if we are doing a url fuzzing
        if (jRadioButtonURLFuzz.isSelected()) {
            if (jTextFieldURLFuzz.getText().length() > 0) {
                String urlFuzz = jTextFieldURLFuzz.getText();

                /*
                 * does the fuzz string start with a /
                 */
                if (!urlFuzz.startsWith("/")) {
                    errors.addElement("The URL you have chosen to fuzz does not start with a /");
                }


                /*
                 * has a fuzz point been added
                 */
                if (urlFuzz.indexOf("{dir}") > 0) {
                    //split the fuzz string!
                    int startLoc = urlFuzz.indexOf("{dir}");
                    fuzzStart = urlFuzz.substring(0, startLoc);
                    fuzzEnd = urlFuzz.substring(startLoc + 5, urlFuzz.length());
                } else {
                    errors.addElement("No fuzz point within the URL to fuzz. You are missing a {dir}");
                }

            } else {
                errors.addElement("You must provide a URL to fuzz");
            }
        }

        //test to see if the host is up before we start
        try {
            if (manager.isUseProxy()) {
                Socket s = new Socket(manager.getProxyHost(), manager.getProxyPort());
                s.close();
            } else {
                Socket s = new Socket(host, port);
                s.close();
            }
        } catch (UnknownHostException ex) {
            //Do nothing as this error will be caught else where!
        } catch (IOException ex) {

            if (!manager.isUseProxy()) {
                errors.addElement("Can't connect to target! " + host + ":" + port);
            } else {
                errors.addElement("Can't connect to proxy! " + host + ":" + port);
            }
        }


        if (errors.size() == 0) {
            parent.jPanelRunning.jButtonBack.setEnabled(false);
            parent.jPanelRunning.jToggleButtonPause.setSelected(false);
            parent.jPanelRunning.jButtonStop.setEnabled(true);
            parent.jPanelRunning.jButtonReport.setEnabled(false);

            //set the target to the running screen
            parent.jPanelRunning.setShowTarget(protocol + "://" + host + ":" + port + dirToStartWith);


            boolean auto = jRadioButtonAuto.isSelected();
            //Gentelmen start your engines
            parent.showRunning();
            //if list and normal
            if (jRadioButtonListBased.isSelected() && jRadioButtonStandardStart.isSelected()) {
                parent.startBruteForceFile(dirToStartWith,
                        fileToRead,
                        protocol,
                        host,
                        port,
                        fileExtention,
                        threadsNumber,
                        jCheckBoxdoDirs.isSelected(),
                        jCheckBoxDoFiles.isSelected(),
                        jCheckBoxRecursive.isSelected(),
                        auto,
                        jCheckBoxUseBlankExt.isSelected(),
                        fileExts);
            }
            //if list and fuzz
            else if (jRadioButtonListBased.isSelected() && jRadioButtonURLFuzz.isSelected()) {
                /*
                String inputFile,
                String protocol,
                String host,
                int port,
                int threadNumber,
                String urlFuzzStart,
                String urlFuzzEnd,
                boolean auto)
                 */
                parent.startListBasedFuzz(fileToRead, protocol, host, port, threadsNumber, fuzzStart, fuzzEnd, auto);
            }
            //if brute and normal
            else if (jRadioButtonPureBrute.isSelected() && jRadioButtonStandardStart.isSelected()) {
                parent.startBruteForcePure(dirToStartWith,
                        charSet,
                        minLen,
                        maxLen,
                        protocol,
                        host,
                        port,
                        fileExtention,
                        threadsNumber,
                        jCheckBoxdoDirs.isSelected(),
                        jCheckBoxDoFiles.isSelected(),
                        jCheckBoxRecursive.isSelected(),
                        auto,
                        jCheckBoxUseBlankExt.isSelected(),
                        fileExts);
            }
            //if brute and fuzz
            else if (jRadioButtonPureBrute.isSelected() && jRadioButtonURLFuzz.isSelected()) {
                parent.startBruteForceFuzz(charSet,
                        minLen,
                        maxLen,
                        protocol,
                        host,
                        port,
                        threadsNumber,
                        auto,
                        fuzzStart,
                        fuzzEnd);
            } else {
                //We should never get to this state!
            }

        } else {
            new JDialogDisplayErrors(parent, true, errors).setVisible(true);
        }


    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jRadioButtonStandardStartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonStandardStartActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonStandardStartActionPerformed
        if (jRadioButtonStandardStart.isSelected()) {
            jLabel8.setEnabled(true);
            jLabel9.setEnabled(true);
            jCheckBoxDoFiles.setEnabled(true);
            jCheckBoxdoDirs.setEnabled(true);
            jCheckBoxRecursive.setEnabled(true);
            jCheckBoxUseBlankExt.setEnabled(true);
            jTextFieldDirToStart.setEnabled(true);
            jTextFieldFileExtention.setEnabled(true);

            jLabelFuzzTitle.setEnabled(false);
            jTextFieldURLFuzz.setEnabled(false);

        }
    }//GEN-LAST:event_jRadioButtonStandardStartActionPerformed

    private void jRadioButtonURLFuzzActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonURLFuzzActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonURLFuzzActionPerformed
        if (jRadioButtonURLFuzz.isSelected()) {
            jLabel8.setEnabled(false);
            jLabel9.setEnabled(false);
            jCheckBoxDoFiles.setEnabled(false);
            jCheckBoxdoDirs.setEnabled(false);
            jCheckBoxRecursive.setEnabled(false);
            jCheckBoxUseBlankExt.setEnabled(false);
            jTextFieldDirToStart.setEnabled(false);
            jTextFieldFileExtention.setEnabled(false);

            jLabelFuzzTitle.setEnabled(true);
            jTextFieldURLFuzz.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonURLFuzzActionPerformed

    /*
     * Process the target url, and extract all the required information
     */
    public void processTarget() {
        try {
            String target = jTextFieldTarget.getText();
            URL targetURL = new URL(target);

            protocol = targetURL.getProtocol();
            host = targetURL.getHost();
            port = targetURL.getPort();

            if (port == -1) {
                port = targetURL.getDefaultPort();
            }
            startPoint = targetURL.getPath();

            /*
            if(jTextFieldDirToStart.getText().length() < 1)
            {
            jTextFieldDirToStart.setText(startPoint);
            }
             */


            if (startPoint.endsWith("/")) {
                if (!dirToStartWithChanged) {
                    jTextFieldDirToStart.setText(startPoint);
                }
            } else {
                //split the string into an array to determine if there is a file name
                String array[] = startPoint.split("/");


                if (array.length > 1) {
                    if (!dirToStartWithChanged) {
                        int chopPoint = (startPoint.length()) - (array[array.length - 1].length());
                        jTextFieldDirToStart.setText(startPoint.substring(0, chopPoint));
                    }

                }


                String file = array[array.length - 1];
                int loc = file.indexOf(".");
                if (loc != -1) {
                    if (!fileExtChanged) {
                        jTextFieldFileExtention.setText(file.substring(loc + 1));
                    }
                }
            }

            if (!urlFuzzChanged) {
                jTextFieldURLFuzz.setText(targetURL.getFile());
            }

        } catch (MalformedURLException ex) {
            //do nothing at this stage as the URL will be wrong, while it is typed in
            //System.out.println("target malformed");
        }
    }

    public void fileExtUpdated() {
        fileExtChanged = true;
    }

    public void dirToStartWithUpdated() {
        dirToStartWithChanged = true;
    }

    public void urlFuzzUpdated() {
        urlFuzzChanged = true;
    }
    // End of variables declaration//GEN-END:variables
}
