/*
 * JDialogViewReport.java
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

import com.sittinglittleduck.DirBuster.Config;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author James
 */
public class JDialogViewReport extends javax.swing.JDialog {
    private String saveLoc;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelSaveLoc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaCSVReport;
    private javax.swing.JTextArea jTextAreaReport;
    private javax.swing.JTextArea jTextAreaSimpleReport;
    private javax.swing.JTextArea jTextAreaXMLReport;
    /**
     * Creates new form JDialogViewReport
     */
    public JDialogViewReport(java.awt.Frame parent, boolean modal, String saveLoc) {
        super(parent, modal);
        initComponents();
        this.setTitle("DirBuster " + Config.version + " Report Viewer");
        this.saveLoc = saveLoc;
        this.jLabelSaveLoc.setText(saveLoc + ".txt");

        /*
         * Try and get the full text report
         */
        try {
            DataInputStream d = new DataInputStream(new FileInputStream(saveLoc + ".txt"));

            String line;
            String file = "";
            while ((line = d.readLine()) != null) {
                file = file + line + "\n";
            }


            jTextAreaReport.setText(file);
        } catch (FileNotFoundException ex) {
            jTextAreaReport.setText("Report not generated");
        } catch (Exception e) {
            jTextAreaReport.setText(e.getMessage());
        }

        /*
         * Try and get he simple list
         */
        try {
            DataInputStream d = new DataInputStream(new FileInputStream(saveLoc + "-simple.txt"));

            String line;
            String file = "";
            while ((line = d.readLine()) != null) {
                file = file + line + "\n";
            }


            jTextAreaSimpleReport.setText(file);
        } catch (FileNotFoundException ex) {
            jTextAreaSimpleReport.setText("Report not generated");
        } catch (Exception e) {
            jTextAreaSimpleReport.setText(e.getMessage());
        }

        /*
         * Try and get the xml report
         */
        try {
            DataInputStream d = new DataInputStream(new FileInputStream(saveLoc + ".xml"));

            String line;
            String file = "";
            while ((line = d.readLine()) != null) {
                file = file + line + "\n";
            }


            jTextAreaXMLReport.setText(file);
        } catch (FileNotFoundException ex) {
            jTextAreaXMLReport.setText("Report not generated");
        } catch (Exception e) {
            jTextAreaXMLReport.setText(e.getMessage());
        }

        /*
         * Try and get the CSV
         */
        try {
            DataInputStream d = new DataInputStream(new FileInputStream(saveLoc + ".csv"));

            String line;
            String file = "";
            while ((line = d.readLine()) != null) {
                file = file + line + "\n";
            }


            jTextAreaCSVReport.setText(file);
        } catch (FileNotFoundException ex) {
            jTextAreaCSVReport.setText("Report not generated");
        } catch (Exception e) {
            jTextAreaCSVReport.setText(e.getMessage());
        }

        this.jTextAreaReport.setLineWrap(true);
        this.jTextAreaReport.setWrapStyleWord(true);
        jTextAreaReport.setCaretPosition(0);

        this.jTextAreaSimpleReport.setLineWrap(true);
        this.jTextAreaSimpleReport.setWrapStyleWord(true);
        jTextAreaSimpleReport.setCaretPosition(0);

        this.jTextAreaCSVReport.setLineWrap(true);
        this.jTextAreaCSVReport.setWrapStyleWord(true);
        jTextAreaCSVReport.setCaretPosition(0);

        this.jTextAreaXMLReport.setLineWrap(true);
        this.jTextAreaXMLReport.setWrapStyleWord(true);
        jTextAreaXMLReport.setCaretPosition(0);

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelSaveLoc = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaReport = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSimpleReport = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaXMLReport = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaCSVReport = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/fileclose.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelSaveLoc.setText("jLabel1");

        jTabbedPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTabbedPane1PropertyChange(evt);
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        jTextAreaReport.setColumns(20);
        jTextAreaReport.setRows(5);
        jScrollPane1.setViewportView(jTextAreaReport);

        jTabbedPane1.addTab("Full Text", jScrollPane1);

        jTextAreaSimpleReport.setColumns(20);
        jTextAreaSimpleReport.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSimpleReport);

        jTabbedPane1.addTab("Simple List", jScrollPane2);

        jTextAreaXMLReport.setColumns(20);
        jTextAreaXMLReport.setRows(5);
        jScrollPane3.setViewportView(jTextAreaXMLReport);

        jTabbedPane1.addTab("XML", jScrollPane3);

        jTextAreaCSVReport.setColumns(20);
        jTextAreaCSVReport.setRows(5);
        jScrollPane4.setViewportView(jTextAreaCSVReport);

        jTabbedPane1.addTab("CSV", jScrollPane4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(jButton1)
                                                .addContainerGap())
                                        .add(layout.createSequentialGroup()
                                                .add(jLabelSaveLoc)
                                                .addContainerGap(591, Short.MAX_VALUE))))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabelSaveLoc)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                .add(11, 11, 11)
                                .add(jButton1)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 656) / 2, (screenSize.height - 529) / 2, 656, 529);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1PropertyChange(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_jTabbedPane1PropertyChange
    {//GEN-HEADEREND:event_jTabbedPane1PropertyChange


    }//GEN-LAST:event_jTabbedPane1PropertyChange

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jTabbedPane1StateChanged
    {//GEN-HEADEREND:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 0) {
            this.jLabelSaveLoc.setText(saveLoc + ".txt");
            ;
        } else if (jTabbedPane1.getSelectedIndex() == 1) {
            this.jLabelSaveLoc.setText(saveLoc + "-simple.txt");
        } else if (jTabbedPane1.getSelectedIndex() == 2) {
            this.jLabelSaveLoc.setText(saveLoc + ".xml");
        } else if (jTabbedPane1.getSelectedIndex() == 3) {
            this.jLabelSaveLoc.setText(saveLoc + ".csv");
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged
    // End of variables declaration//GEN-END:variables

}
