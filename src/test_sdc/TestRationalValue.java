package test_sdc;

import org.junit.Before;
import org.junit.Test;
import sdc.Exceptions.IncompatibleTypeException;
import sdc.Exceptions.StackException;
import sdc.Exceptions.SymbolNotFoundException;
import sdc.SDC;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestRationalValue {

    SDC sdc;

    @Before
    public void setUp() {
        this.sdc = new SDC();
    }

    @Test
    public void testRationalCreation() throws Exception {
        String[] test = {"12#2", "-12#1", "1#2", "0#2"};

        for (String expectedRes : test) {
            this.sdc.executeLine(expectedRes);
            assertThat(expectedRes, is(this.sdc.getLastResult()));
        }
    }

    @Test
    public void testRationalCreationFail() throws Exception{
        String[] test = {"12.0#2", "-12#a", "1a#2"};
        for (String expectedRes : test) {
            try {
                this.sdc.executeLine(expectedRes);
            }catch (StackException e) {
                assertThat(e.getMessage(), is("Empty stack --- aborting last operations"));
            }catch (SymbolNotFoundException e){
                assertThat(e.getMessage(), is("the token " + expectedRes + " has not been recognized. Abort"));
            }
        }
    }

    @Test
    public void testAddition() throws Exception{
        this.sdc.executeLine("2#2 2#2 +");
        String expectedRes = "4#2";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#1 +");
        expectedRes = "6#2";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testSubstraction() throws Exception {
        this.sdc.executeLine("6#2 2#2 -");
        String expectedRes = "4#2";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#1 -");
        expectedRes = "2#2";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testMultiply() throws Exception {
        this.sdc.executeLine("12#2 2#2 *");
        String expectedRes = "24#4";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#1 *");
        expectedRes = "24#4";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testDivide() throws Exception {
        this.sdc.executeLine("6#2 2#2 /");
        String expectedRes = "12#4";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#2 /");
        expectedRes = "24#4";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testComparison() throws Exception{
        this.sdc.executeLine("6#2 2#2 >");
        String expectedRes = "true";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("2#2 6#2 <");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("2#2 2#2 =");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("3#2 2#2 <");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#2 2#2 >");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("1#2 2#2 =");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("6#3 2#2 >");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("6#3 2#2 <");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("6#3 2#2 =");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testOperationFail() throws Exception{
        String[] test = {"+", "-", "/", "*", ">", "<", "="};
        for(String expectedRes : test){
            try{
                this.sdc.executeLine(String.format("12#2 2 %s", expectedRes));
            }catch (IncompatibleTypeException e){
                assertThat(e.getMessage(), is("Illegal operations: values must have the same type --- aborting last operations"));
            }
        }
    }
}