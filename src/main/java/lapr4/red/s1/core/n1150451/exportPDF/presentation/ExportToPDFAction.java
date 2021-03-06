/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1150451.exportPDF.presentation;

import csheets.CleanSheets;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;

import java.awt.event.ActionEvent;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import lapr4.green.s2.core.n1150800.PDFStyle.domain.ExportStylePDFThread;
import lapr4.green.s2.core.n1150800.PDFStyle.presentation.ExportStylePDFUI;

/**
 * @author Sofia Silva [1150690@isep.ipp.pt]
 */
@SuppressWarnings("serial")
public class ExportToPDFAction extends FocusOwnerAction {

    /**
     * The CleanSheets application
     */
    protected CleanSheets app;

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * The file chooser to use when prompting the user for the destination path
     */
    protected FileChooser chooser;

    public ExportToPDFAction(CleanSheets app, UIController uiController, FileChooser chooser) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "PDF";
    }

    @Override
    protected void defineProperties() {
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/pdf.png")));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (focusOwner == null) {
            return;
        }
        
        new ExportStylePDFUI(uiController, chooser);
    }

}
