/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.lang.n1150657.XML.Export.UI;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import javax.swing.JOptionPane;
import lapr4.green.s3.lang.n1150657.XML.Export.ExportXMLController;
import lapr4.green.s3.lang.n1150657.XML.Export.Path;

/**
 *
 * @author Sofia
 */
public class ExportSelectedCellsUI {

    private UIController uiController;

    private Cell selectedCells[][];

    public ExportSelectedCellsUI(UIController uiController, Cell selectedCells[][]) {
        this.uiController = uiController;
        this.selectedCells = selectedCells;
        initialize();
    }

    private void initialize() {
        int result = JOptionPane.showConfirmDialog(null, "You have selected the Workbook export option. Do you want to export?");

        boolean exported = false;

        if (result == JOptionPane.YES_OPTION) {
            final Path path = new Path();
            String selectedPath = Path.DEFAULT_PATH;
            try {
                selectedPath = path.path();
                ExportXMLController exportXMLController = new ExportXMLController(uiController, selectedPath);
                TagNamesInputDialogUI exportXMLDialog = new TagNamesInputDialogUI(exportXMLController);
                exportXMLDialog.setModal(true);
                exportXMLDialog.setVisible(true);

                //Export Selected workbook
                exported = exportXMLController.exportSelectedCell(selectedCells);
                JOptionPane.showMessageDialog(null, "Workbook exported successfully.", "Export XML", JOptionPane.PLAIN_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Failed path", JOptionPane.ERROR_MESSAGE);
            }

            if (!exported) {
                JOptionPane.showMessageDialog(null, "Failed to export Workbook.", "Export XML", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Unable to read file.",
                    "Import",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
