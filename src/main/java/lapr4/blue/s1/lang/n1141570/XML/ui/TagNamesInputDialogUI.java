package lapr4.blue.s1.lang.n1141570.XML.ui;

import csheets.ui.ctrl.UIController;
import lapr4.blue.s1.lang.n1141570.XML.application.ExportXMLController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Represents a dialog to input the chosen the tag names.
 *
 * @author Eric
 */
public class TagNamesInputDialogUI extends JDialog {

    /**
     * The controller of the user interface.
     */
    private UIController uiController;

    /**
     * The macro controller.
     */
    private ExportXMLController exportXMLController = new ExportXMLController(uiController);

    /* UI Components */
    private JTextField workbookTagTextField;
    private JTextField spreadsheetTagTextField;
    private JTextField cellTagTextField;
    private final Dimension BUTTON_SIZE = new Dimension(115, 30);

    private LinkedList<String> tagNames = new LinkedList<>();

    /**
     * Creates an instance of export xml dialog.
     *
     * @param uiController the user interface controller
     */
    public TagNamesInputDialogUI(UIController uiController) {
        setLocationRelativeTo(null);
        this.uiController = uiController;
        createComponents();
        pack();
    }

    /**
     * Obtains the tag names list.
     *
     * @return the tag names.
     */
    public LinkedList<String> tagNamesDefinedByUser() {
        return tagNames;
    }

    /**
     * Creates the user interface components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout());
        componentsPanel.add(createLabelsAndTextFieldPanel(), BorderLayout.NORTH);
        componentsPanel.add(createButtonsPanel(), BorderLayout.CENTER);

        add(componentsPanel);
    }

    /**
     * Creates the labels and text fields panel.
     *
     * @return the labels and text fields panel.
     */
    private JPanel createLabelsAndTextFieldPanel() {
        JPanel labelsAndTextFieldPanel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new FlowLayout());
        JPanel southPanel = new JPanel(new FlowLayout());

        this.workbookTagTextField = new JTextField();
        this.workbookTagTextField.setPreferredSize(BUTTON_SIZE);

        this.spreadsheetTagTextField = new JTextField();
        this.spreadsheetTagTextField.setPreferredSize(BUTTON_SIZE);

        this.cellTagTextField = new JTextField();
        this.cellTagTextField.setPreferredSize(BUTTON_SIZE);

        JLabel workbookLabel = new JLabel("workbook tag");
        workbookLabel.setVisible(true);

        JLabel spreadsheetLabel = new JLabel("spreadsheet tag");
        spreadsheetLabel.setVisible(true);

        JLabel cellLabel = new JLabel("cell tag");
        cellLabel.setVisible(true);

        northPanel.add(workbookLabel);
        northPanel.add(workbookTagTextField);

        centerPanel.add(spreadsheetLabel);
        centerPanel.add(spreadsheetTagTextField);

        southPanel.add(cellLabel);
        southPanel.add(cellTagTextField);

        labelsAndTextFieldPanel.add(northPanel, BorderLayout.NORTH);
        labelsAndTextFieldPanel.add(centerPanel, BorderLayout.CENTER);
        labelsAndTextFieldPanel.add(southPanel, BorderLayout.SOUTH);

        return labelsAndTextFieldPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(createSaveButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the save button.
     *
     * @return save button
     */
    private JButton createSaveButton() {
        JButton saveButton = new JButton("Save");
        saveButton.setPreferredSize(BUTTON_SIZE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String workbookTagText = workbookTagTextField.getText().toLowerCase();
                String spreadsheetTagText = spreadsheetTagTextField.getText().toLowerCase();
                String cellTagText = cellTagTextField.getText().toLowerCase();

                tagNames.add(workbookTagText);
                tagNames.add(spreadsheetTagText);
                tagNames.add(cellTagText);
                dispose();
            }
        });

        return saveButton;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(BUTTON_SIZE);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        return cancelButton;
    }
}
