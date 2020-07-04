package cli;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import picocli.CommandLine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertEquals;

public class CommandLineInterfaceTest {

    private CommandLine cl = new CommandLine(new CommandLineInterface());
    private PrintStream oldOut = System.out;
    private ByteArrayOutputStream out;

    @BeforeMethod
    private void prepare() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    private void test1() {
        String[] args = "--transportation-method medium-diesel-car --distance 15 --unit-of-distance km".split(" ");
        int exitCode = cl.execute(args);
        assertEquals(0, exitCode);
        assertEquals(out.toString().trim(), "Your trip caused 2.6kg of CO2-equivalent.");
    }

    @Test
    private void test2() {
        String[] args = "--distance 1800.5 --transportation-method large-petrol-car".split(" ");
        int exitCode = cl.execute(args);
        assertEquals(0, exitCode);
        assertEquals(out.toString().trim(), "Your trip caused 507.7kg of CO2-equivalent.");
    }

    @Test
    private void test3() {
        String[] args = "--transportation-method train --distance 14500 --unit-of-distance m".split(" ");
        int exitCode = cl.execute(args);
        assertEquals(0, exitCode);
        assertEquals(out.toString().trim(), "Your trip caused 87g of CO2-equivalent.");
    }

    @Test
    private void test4() {
        String[] args = "--transportation-method train --distance 14500 --unit-of-distance m --output kg".split(" ");
        int exitCode = cl.execute(args);
        assertEquals(0, exitCode);
        assertEquals(out.toString().trim(), "Your trip caused 0.1kg of CO2-equivalent.");
    }

    @Test
    private void test5() {
        String[] args = "--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car".split(" ");
        int exitCode = cl.execute(args);
        assertEquals(0, exitCode);
        assertEquals(out.toString().trim(), "Your trip caused 2.6kg of CO2-equivalent.");
    }

    @AfterMethod
    private void reassignsStandardOutputStream() {
        System.setOut(oldOut);
    }

    @AfterClass
    private void finish() {
        out = null;
        oldOut = null;
        cl = null;
    }
}
