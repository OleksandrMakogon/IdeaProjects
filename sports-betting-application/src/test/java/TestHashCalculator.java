import Calculator.HashCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHashCalculator {

    HashCalculator hashCalc = new HashCalculator();

    @Test
    public void StringToHash_StringInput(){
        String actual = hashCalc.hash("Hello");
        String expected = "8b1a9953c4611296a827abf8c47804d7";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void StringToHash_IntegerInput(){
        String actual = hashCalc.hash("1213");
        String expected = "33ceb07bf4eeb3da587e268d663aba1a";
        Assertions.assertEquals(expected, actual);
    }


}
