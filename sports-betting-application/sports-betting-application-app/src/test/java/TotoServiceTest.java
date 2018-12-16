import domain.*;
import main.TotoService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Random;

@RunWith(JUnitPlatform.class)
class TotoServiceTest {

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


    @AfterAll
    public static void teardown(){
        totoService = null;
        System.out.println("tierdown");
    }

    @org.junit.jupiter.api.Test
    void getResults_ThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> totoService.getResults(null));
    }

    @org.junit.jupiter.api.Test
    void getResults_FillBetWithResults() {
        totoService.setRandom(random);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            Assertions.assertNotNull(result.outcome);
        }
    }

    @org.junit.jupiter.api.Test
    void getResults_FillBetWithFirstOutcome() {
        totoService.setRandom(random);
        Mockito.when(random.nextInt(Matchers.anyInt())).thenReturn(0);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            System.out.println(result.outcome.value);
        }
    }

    @org.junit.jupiter.api.Test
    void calculateBalance_ThrowsException_ResultsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> totoService.calculateBalance(null, null));
    }

    @org.junit.jupiter.api.Test
    void createWager_ReturnsWager(){
       Wager wager = totoService.createWager(player, 20.0, bets.get(0).outcomes.get(0).odds.get(0));
       Assertions.assertEquals(Wager.class, wager.getClass());
    }

    @org.junit.jupiter.api.Test
    void createData_ReturnListBets(){
        List<Bet> betsList = totoService.createTestData();
        for (Bet bet: betsList){
            Assertions.assertEquals(bet.getClass(), Outcome.class);
        }
    }


}
