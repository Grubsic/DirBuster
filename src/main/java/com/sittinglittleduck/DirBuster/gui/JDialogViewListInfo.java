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

/**
 * @author James
 */
public class JDialogViewListInfo extends javax.swing.JDialog {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaReport;


    /**
     * Creates new form JDialogViewReport
     */
    public JDialogViewListInfo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("DirBuster " + Config.version + " Brute Forcing List Information");
        jTextAreaReport.setCaretPosition(0);

        //JScrollBar sb = jScrollPane1.getVerticalScrollBar();
        //sb.setValue(sb.getMaximum());
        //jScrollPane1.getVerticalScrollBar().setValue(0);

        //JViewport view = jScrollPane1.getViewport();

        //Point p = new Point(0,0);
        //view.setViewPosition(p);
        //view.setLocation(p);


        //jScrollPane1.setViewport(view);
        //jScrollPane1.setViewportView(view);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaReport = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/gui/icons/fileclose.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 7, 10);
        getContentPane().add(jButton1, gridBagConstraints);

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 11));

        jTextAreaReport.setColumns(20);
        jTextAreaReport.setRows(5);
        jTextAreaReport.setText("The following lists are included with DirBuster:\n\napache-user-enum-1.0.txt  (8916 usernames) \nUsed for guessing system users on apache with the userdir module enabled, based on a \nusername list I had lying around (unordered)\n\napache-user-enum-2.0.txt  (10341 usernames) \nUsed for guessing system users on apache with the userdir module enabled, based \non ~XXXXX found during list generation (Ordered)\n\ndirectory-list-2.3-small.txt  (87650 words) \nDirectories/files that where found on at least 3 different hosts\n\ndirectory-list-2.3-medium.txt  (220546 words) \nDirectories/files that where found on at least 2 different hosts\n\ndirectory-list-lowercase-2.3-small.txt  (81629 words) \nCase insensitive version of directory-list-2.3-small.txt\n\ndirectory-list-lowercase-2.3-medium.txt  (207629 words) \nCase insensitive version of directory-list-2.3-medium.txt\n\ndirectory-list-1.0.txt  (141694 words)  \nOriginal unordered list \n\ndirectories.jbrofuzz (50000 words)\nCase sensitive list from the OWASP JbroFuzz Project.  Explicit words have been removed\n\nOld lists (not included, avalible from http://sourceforge.net/projects/dirbuster/)\n\ndirectory-list-2.3-big.txt  (1273819 words) \nAll directories/files that where found\n\ndirectory-list-lowercase-2.3-big.txt  (1185240 words) \nCase insensitive version of directory-list-2.3-big.txt");
        jTextAreaReport.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextAreaReport);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 357;
        gridBagConstraints.ipady = 227;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 617) / 2, (screenSize.height - 551) / 2, 617, 551);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    // End of variables declaration//GEN-END:variables

}
