import Calculator.HashCalculator;
import org.junit.Assert;
import org.junit.Test;

public class TestHashCalculator {

    HashCalculator hashCalc = new HashCalculator();

    @Test
    public void Test1(){
        String actual = hashCalc.hash("Hello");
        String expected = "8b1a9953c4611296a827abf8c47804d7";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test2(){
        String actual = hashCalc.hash("Hello");
        String expected = "04063d1d97b3dc99595786095f62a14c";
        Assert.assertNotEquals(expected, actual);
    }


}
