/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1150623.labelsForContacts.presentation;

import eapli.util.DateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author guima
 */
public class ChooseEndDateEventsUI extends javax.swing.JFrame {

    private ExportDetailsController ctrl;
    private Calendar chosenDate;
    /**
     * Creates new form ChooseEndDateEventsDialog1
     * @param ctrl
     */
    public ChooseEndDateEventsUI(ExportDetailsController ctrl) {
        initComponents();
        this.ctrl = ctrl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        buttonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Set the date to limit the list of events:");

        jLabel2.setText("Date: (dd-mm-yyyy)");

        dateField.setText("");

        buttonOK.setText("OK");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonOK)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(buttonOK)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        onOK();
    }//GEN-LAST:event_buttonOKActionPerformed

    
    private void onOK() {
        int day = 0, month = 0, year = 0;
        boolean validDate = true;

        String date = dateField.getText().trim();

        String[] splitedDate = date.split("-");
        if (splitedDate.length != 3) {
            validDate = false;
        } else {
            try {
                day = Integer.parseInt(splitedDate[0].trim());
                month = Integer.parseInt(splitedDate[1].trim());
                year = Integer.parseInt(splitedDate[2].trim());
            } catch (NumberFormatException e) {
                validDate = false;
            }
        }

        if (validDate) {

            chosenDate = Calendar.getInstance();

            chosenDate.set(Calendar.DAY_OF_MONTH, day);
            chosenDate.set(Calendar.MONTH, month);
            chosenDate.set(Calendar.YEAR, year);

            chosenDate = DateTime.newCalendar(year, month-1, day);
            if (chosenDate == null || chosenDate.compareTo(DateTime.now())==-1) {
                JOptionPane.showMessageDialog(null, "Invalid Date!", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                ctrl.setDate(chosenDate);
                dispose();
                ctrl.runPathChooser();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Date!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOK;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
