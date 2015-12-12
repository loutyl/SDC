package test_sdc;

import org.junit.Before;
import org.junit.Test;
import sdc.SDC;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestIntegerValue {

    SDC sdc;

    @Before
    public void setUp() {
        this.sdc = new SDC();
    }

    @Test
    public void testIntegerCreation() throws Exception {
        this.sdc.executeLine("12");
        String expectedRes = "12";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("-23");
        expectedRes = "-23";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testAddition() throws Exception{
        this.sdc.executeLine("12 2 +");
        String expectedRes = "14";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("-2 +");
        expectedRes = "12";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testSubstraction() throws Exception {
        this.sdc.executeLine("12 2 -");
        String expectedRes = "10";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("-2 -");
        expectedRes = "12";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testMultiply() throws Exception{
        this.sdc.executeLine("12 2 *");
        String expectedRes = "24";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("-2 *");
        expectedRes = "-48";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testDivide() throws Exception {
        this.sdc.executeLine("12 2 /");
        String expectedRes = "6";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("-2 /");
        expectedRes = "-3";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testComparison() throws Exception{
        this.sdc.executeLine("6 2 >");
        String expectedRes = "true";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("2 6 <");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("2 2 =");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }
}