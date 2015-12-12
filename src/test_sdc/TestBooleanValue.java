package test_sdc;

import org.junit.Before;
import org.junit.Test;
import sdc.SDC;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestBooleanValue {

    SDC sdc;

    @Before
    public void setUp() {
        this.sdc = new SDC();
    }

    @Test
    public void testBooleanValueCreation() throws Exception {
        this.sdc.executeLine("true");
        String expectedRes = "true";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("false");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testAnd() throws Exception {
        this.sdc.executeLine("true true &");
        String expectedRes = "true";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("false &");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("false &");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testOr() throws Exception {
        this.sdc.executeLine("false false |");
        String expectedRes = "false";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("true |");
        expectedRes = "true";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }

    @Test
    public void testNegate() throws Exception {
        this.sdc.executeLine("false ~");
        String expectedRes = "true";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("~");
        expectedRes = "false";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));
    }
}