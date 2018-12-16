package main;

import domain.*;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

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

    @Test
    void getResults_ThrowsException() {
        Assertions.assertThrows(NullPointerException.class, ()-> totoService.getResults(null));
    }

    @Test
    void getResults_FillBetWithResults() {
        totoService.setRandom(random);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            Assertions.assertNotNull(result.outcome);
        }
    }

    @Test
    void getResults_FillBetWithFirstOutcome() {
        totoService.setRandom(random);
        when(random.nextInt(anyInt())).thenReturn(0);
        List<Result> res = totoService.getResults(bets);
        for (Result result: res) {
            System.out.println(result.outcome.value);
        }
    }

    @Test
    void calculateBalance_ThrowsException_ResultsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> totoService.calculateBalance(null, null));
    }

    @Test
    void createWager_ReturnsWager(){
       Wager wager = totoService.createWager(player, 20.0, bets.get(0).outcomes.get(0).odds.get(0));
       Assertions.assertEquals(Wager.class, wager.getClass());
    }

    @Test
    void createData_ReturnListBets(){
        List<Bet> betsList = totoService.createTestData();
        for (Bet bet: betsList){
            Assertions.assertEquals(bet.getClass(), Bet.class);
        }
    }


}
