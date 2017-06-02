/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1150800.importexportTXT.exportTXT.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import lapr4.green.s1.ipc.n1150800.importexportTXT.CellRange;
import lapr4.green.s1.ipc.n1150800.importexportTXT.exportTXT.ctrl.ExportDataController;
import lapr4.green.s1.ipc.n1150800.importexportTXT.importTXT.ctrl.ImportDataController;

/**
 *
 * @author Pedro Chilro (1150800@isep.ipp.pt)
 */
public class ExportDataUI extends JFrame {
    
    /**
     * 
     */
    private UIController uiController;
    
    /**
     * 
     */
    private File fileToWrite;
    
    /**
     * 
     * @param uiController
     * @param fileToWrite 
     */
    public ExportDataUI(UIController uiController, File fileToWrite) {
        this.uiController = uiController;
        this.fileToWrite = fileToWrite;
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createComponents();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    /**
     * 
     */
    private void createComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel subPanelCharacter = new JPanel();

        JLabel labelCharacter = new JLabel("Choose the separator character:");
        JTextField txtFieldCharacter = new JTextField(2);

        subPanelCharacter.add(labelCharacter);
        subPanelCharacter.add(txtFieldCharacter);

        JPanel subPanelRange = new JPanel();

        JLabel labelFirstCell = new JLabel("First Cell:");
        JTextField txtFieldFirstCell = new JTextField(5);

        JLabel labelLastCell = new JLabel("Last Cell:");
        JTextField txtFieldLastCell = new JTextField(5);

        subPanelRange.add(labelFirstCell);
        subPanelRange.add(txtFieldFirstCell);
        subPanelRange.add(labelLastCell);
        subPanelRange.add(txtFieldLastCell);

        JPanel subPanelRadioButtons = new JPanel();

        JLabel labelFirstLine = new JLabel("The first line of the file represents:");
        JRadioButton radioButtonColumnHeader = new JRadioButton("Column headers");
        JRadioButton radioButtonNormalRow = new JRadioButton("Normal row");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonColumnHeader);
        group.add(radioButtonNormalRow);

        subPanelRadioButtons.add(labelFirstLine);
        subPanelRadioButtons.add(radioButtonColumnHeader);
        subPanelRadioButtons.add(radioButtonNormalRow);

        JPanel subPanelButtons = new JPanel();

        JButton buttonConfirm = new JButton("Confirm");
        buttonConfirm.addActionListener((ActionEvent e) -> {
            try {
                /* SEPARATOR CHARACTER */
                char separatorCharacter = txtFieldCharacter.getText().charAt(0);

                /* CELL RANGE */
                String addressStrFirstCell = txtFieldFirstCell.getText();
                String addressStrLastCell = txtFieldLastCell.getText();

                CellRange cellRange = new CellRange(addressStrFirstCell, addressStrLastCell, uiController);

                ExportDataController controller = new ExportDataController(uiController, fileToWrite, separatorCharacter, cellRange);
                controller.writeData();

                dispose();
            } catch (IllegalArgumentException | IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.addActionListener((ActionEvent e) -> {
            dispose();
        });

        subPanelButtons.add(buttonConfirm);
        subPanelButtons.add(buttonCancel);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(subPanelCharacter, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(subPanelRadioButtons, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(subPanelRange, c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(subPanelButtons, c);

        add(panel);

    }
}
