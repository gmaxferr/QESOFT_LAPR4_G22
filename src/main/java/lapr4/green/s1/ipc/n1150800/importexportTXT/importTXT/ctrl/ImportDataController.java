/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1150800.importexportTXT.importTXT.ctrl;

import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import eapli.framework.application.Controller;
import java.io.File;
import java.io.IOException;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;
import lapr4.green.s1.ipc.n1150800.importexportTXT.CellRange;
import lapr4.green.s1.ipc.n1150800.importexportTXT.FileData;

/**
 *
 * @author Pedro Chilro (1150800@isep.ipp.pt)
 */
public class ImportDataController implements Controller {

    /**
     * The UI Controller
     */
    private UIController uiController;

    /**
     * The file that contains the data to be imported
     */
    private FileData fileToRead;

    /**
     * The active spreadsheet in the current workbook
     */
    private Spreadsheet activeSpreadsheet;

    /**
     * Creates an ImportDataController instance with
     *
     * @param uiController - the UI Controller
     * @param fileToRead - the File containing the data
     * @param separatorCharacter - the character that separates the data by
     * columns in the file
     * @param cellRange - the range of cells that will be filled with the data
     *
     */
    public ImportDataController(UIController uiController, File fileToRead, char separatorCharacter, CellRange cellRange) {
        FileData fileData = new FileData(fileToRead, separatorCharacter, cellRange);
  
        this.uiController = uiController;
        this.fileToRead = fileData;
    }

    /**
     * This method reads the data from the file and fills a range of cells with
     * the given data
     *
     * @throws IOException
     * @throws FormulaCompilationException
     */
    public void readData() throws IOException, FormulaCompilationException {
        activeSpreadsheet = uiController.getActiveSpreadsheet();

        CellDTO cellList[][] = fileToRead.getFileData(activeSpreadsheet);

        fileToRead.fillCells(cellList);

    }
}
