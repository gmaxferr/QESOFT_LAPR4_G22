/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.lang.n1140822.beanshellwindow;

import bsh.EvalError;
import csheets.CleanSheets;
import csheets.core.IllegalValueTypeException;
import csheets.ui.ctrl.UIController;
import java.util.LinkedList;
import lapr4.blue.s1.lang.n1151159.macros.compiler.MacroCompilationException;
import lapr4.red.s2.lang.n1150385.beanshell.Instruction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class BeanShellInstanceTest {

    public BeanShellInstanceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of executeScript method, of class BeanShellInstance.
     */
    @Test(expected = EvalError.class)
    public void  ensureBeanShellScriptFailsIfBadCode() throws EvalError, MacroCompilationException, IllegalValueTypeException {
        System.out.println("ensureBeanShellScriptFailsIfBadCode");
        LinkedList<Instruction> list = new LinkedList<>();
        list.add(new Instruction("print(\"test\")asd;", Instruction.Type.BEANSHELL));
        BeanShellInstance instance = new BeanShellInstance(list, null, null);
        instance.executeScript();
    }

     public void  ensureBeanShellScriptExecutes() throws EvalError, MacroCompilationException, IllegalValueTypeException {
        System.out.println("ensureBeanShellScriptExecutes");
         LinkedList<Instruction> list = new LinkedList<>();
         list.add(new Instruction("print(\"test\");", Instruction.Type.BEANSHELL));
         BeanShellInstance instance = new BeanShellInstance(list, null, null);
        instance.executeScript();
        //if no exception then its sucessfull
    }

}
