package main;

import domain.*;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(JUnitPlatform.class)
public class TotoServiceTest {

    private static TotoService totoService;
    private static List<Bet> bets;
    private static Player player;
    @Mock
    Random random;

    @BeforeAll
    public static void setup() {
        totoService = new TotoService();
        bets = totoService.createData();
        player = new Player("TestPlayer", "111", 50.0, Currency.EUR, true);
    }

    @BeforeEach
    public void mockSetup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkBalanceReturnsTrueFalse() {
        Player player = new Player("a", "1", 10.0, Currency.EUR, true);
        Assertions.assertTrue(totoService.checkBalance(player, 10.0));
        Assertions.assertFalse(totoService.checkBalance(player, 10.01));
    }

    @Test
    public void checkBalanceThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{totoService.checkBalance(null, 10.0);});
    }

    @AfterAll
    public static void teardown(){
        totoService = null;
    }

    @Test
    void getResults_ThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{totoService.getResults(null);});
    }

    @Test
    void getResults_FillBetWithResults() {
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            Assertions.assertNotNull(result.outcome);
        }
    }

    @Test
    void getResults_FillBetWithFirstOutcome() {
        totoService.setRandom(random);
        when(random.nextInt(bets.get(0).outcomes.size())).thenReturn(new Integer(0));

        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            System.out.println(result.outcome.value);
        }
    }

    @Test
    void calculateBalance_ThrowsException_ResultsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            totoService.calculateBalance(null, null);
        });
    }

    @Test
    void createWager_ReturnsWager(){
       Wager wager = totoService.createWager(player, 20.0, bets.get(0).outcomes.get(0).odds.get(0));
       Assertions.assertEquals(Wager.class, wager.getClass());
    }

    @Test
    void createData_ReturnListBets(){
        List<Bet> betsList = totoService.createData();
        for (Bet bet: betsList){
            Assertions.assertEquals(bet.getClass(), Bet.class);
        }
    }


}