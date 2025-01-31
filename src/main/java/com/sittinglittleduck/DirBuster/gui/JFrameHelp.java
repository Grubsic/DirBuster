/*
 * JFrameHelp.java
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
 *
 * Created on 16 January 2008, 23:18
 */

package com.sittinglittleduck.DirBuster.gui;

import javax.help.JHelp;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author James
 */
public class JFrameHelp extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.help.JHelp jHelp1;
    private javax.help.JHelp jHelp2;
    private javax.help.JHelp jHelp3;

    /**
     * Creates new form jFrameHelp
     */
    public JFrameHelp(JHelp help) {
        try {
            //TODO does not work under linux!


            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


            initComponents();
            setIconImage(new ImageIcon(getClass().getResource("/com/sittinglittleduck/DirBuster/images/duck.gif")).getImage());
            add(help);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFrameHelp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFrameHelp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFrameHelp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrameHelp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new jFrameHelp().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jHelp1 = new javax.help.JHelp();
        jHelp2 = new javax.help.JHelp();
        jHelp3 = new javax.help.JHelp();

        javax.swing.GroupLayout jHelp1Layout = new javax.swing.GroupLayout(jHelp1);
        jHelp1.setLayout(jHelp1Layout);
        jHelp1Layout.setHorizontalGroup(
                jHelp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jHelp1Layout.setVerticalGroup(
                jHelp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DirBuster Help");
        setAlwaysOnTop(true);

        javax.swing.GroupLayout jHelp3Layout = new javax.swing.GroupLayout(jHelp3);
        jHelp3.setLayout(jHelp3Layout);
        jHelp3Layout.setHorizontalGroup(
                jHelp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jHelp3Layout.setVerticalGroup(
                jHelp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jHelp2Layout = new javax.swing.GroupLayout(jHelp2);
        jHelp2.setLayout(jHelp2Layout);
        jHelp2Layout.setHorizontalGroup(
                jHelp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jHelp2Layout.createSequentialGroup()
                                .addContainerGap(263, Short.MAX_VALUE)
                                .addComponent(jHelp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(376, 376, 376))
        );
        jHelp2Layout.setVerticalGroup(
                jHelp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jHelp2Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jHelp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(252, Short.MAX_VALUE))
        );

        getContentPane().add(jHelp2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 747) / 2, (screenSize.height - 563) / 2, 747, 563);
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables

}
