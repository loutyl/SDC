package test_sdc;

import org.junit.Before;
import org.junit.Test;
import sdc.Exceptions.UnknownVariableException;
import sdc.SDC;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestVariable {

    SDC sdc;

    @Before
    public void setUp() {
        this.sdc = new SDC();
    }

    @Test
    public void testVariableCreation() throws Exception {
        this.sdc.executeLine("3 => x");
        String expectedRes = "";
        String res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        this.sdc.executeLine("$x");
        expectedRes = "3";
        res = this.sdc.getLastResult();
        assertThat(expectedRes, is(res));

        try{
            this.sdc.executeLine("$unknownVariable");
        }catch (UnknownVariableException e){
            assertThat(e.getMessage(), is("Illegal operation: unknown variable. Ignore last command line"));
        }
    }
}