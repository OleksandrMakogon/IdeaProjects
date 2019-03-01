import domain.*;
import totoBetApp.TotoService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Random;


public class TotoServiceTest {

    private static TotoService totoService;
    private static List<Bet> bets;
    private static Player player;
    @Mock
    Random random;

    @Before
    public void setup() {
        totoService = new TotoService();
        bets = totoService.createData();
        player = new Player("TestPlayer", "111", 50.0, Currency.EUR, true);
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void teardown(){
        totoService = null;
        System.out.println("tierdown");
    }

    @Test(expected=NullPointerException.class)
    public void getResults_ThrowsException() {
        totoService.getResults(null);
    }

    @Test
    public void getResults_FillBetWithResults() {
        totoService.setRandom(random);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            Assert.assertNotNull(result.outcome);
        }
    }

    @Test
    public void getResults_FillBetWithFirstOutcome() {
        totoService.setRandom(random);
        Mockito.when(random.nextInt(Matchers.anyInt())).thenReturn(0);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            System.out.println(result.outcome.value);
        }
    }

    @Test
    public void createWager_ReturnsWager(){
       Wager wager = totoService.createWager(player, 20.0, bets.get(0).outcomes.get(0).odds.get(0));
       Assert.assertEquals(Wager.class, wager.getClass());
    }

    @Test
    public void createData_ReturnListBets(){
        List<Bet> betsList = totoService.createTestData();
        for (Bet bet: betsList){
            Assert.assertEquals(bet.getClass(), Bet.class);
        }
    }


}
