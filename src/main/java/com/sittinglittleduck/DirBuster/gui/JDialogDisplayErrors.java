/*
 * JDialogDisplayErrors.java
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

import java.util.Vector;

/**
 * @author James
 */
public class JDialogDisplayErrors extends javax.swing.JDialog {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonOK;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JList jListErrors;
    public javax.swing.JScrollPane jScrollPane1;
    private Vector errors;
    /**
     * Creates new form JDialogDisplayErrors
     */
    public JDialogDisplayErrors(java.awt.Frame parent, boolean modal, Vector errors) {
        super(parent, modal);
        initComponents();
        this.setTitle("DirBuster " + Config.version + " - You have Errors!");
        this.errors = errors;
        jListErrors.setListData(this.errors);

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListErrors = new javax.swing.JList();
        jButtonOK = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("The following errors have been detected, you must correct these before brute forcing can start");

        jListErrors.setBackground(new java.awt.Color(224, 223, 227));
        jListErrors.setFont(new java.awt.Font("Dialog", 1, 11));
        jScrollPane1.setViewportView(jListErrors);

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                                        .add(jButtonOK, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .add(org.jdesktop.layout.GroupLayout.CENTER, layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 510, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(10, 10, 10))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(13, 13, 13)
                                .add(jLabel2)
                                .add(15, 15, 15)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .add(33, 33, 33)
                                .add(jButtonOK)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 542) / 2, (screenSize.height - 299) / 2, 542, 299);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonOKActionPerformed
    {//GEN-HEADEREND:event_jButtonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed
    // End of variables declaration//GEN-END:variables

}
