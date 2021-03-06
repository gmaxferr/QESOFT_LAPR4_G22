/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1150613.workbookSearch;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.core.n1150613.workbookSearch.ui.UIExtensionSearch;


/**
 * An extension to support search.
 * 
 * @author Diogo Guedes
 */
public class SearchExtension extends Extension {

	/** The name of the extension */
    public static final String NAME = "Workbook Search";
    
    /**
     * The description of the extension
     */
    public static final String DESCRIPTION = "An extension to support search.";
    
    /**
     * The first version of the search extension.
     */
    public static final int VERSION = 1;

	/**
	 * Creates a new Example extension.
	 */
	public SearchExtension() {
            super(NAME,VERSION,DESCRIPTION);
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
            return new UIExtensionSearch(this, uiController);
        }
        
        @Override
        public String metadata() {
            return String.format("This is %s with version %d\n"
                    + "This extension has the follow description: %s\n"
                    + "This extension was made by Diogo Guedes in Sprint 1 and it is in the package %s",
                    getName(), getVersion(), getDescription(),getClass().getName());
        }
}