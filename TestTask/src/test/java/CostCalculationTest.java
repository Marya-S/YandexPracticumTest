import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CostCalculationTest {
    //Дистанция, габариты, хрупкость, загруженность доставки
    @ParameterizedTest
    @CsvSource(
            {
                    "2, true, false, VERY_HIGH, 480",
                    "2, false, true, HIGH, 700",
                    "2, true, false, OTHER, 400",
                    "2, false, false, ELEVATED,400 ",
                    "8, true, false, HIGH, 420",
                    "8, false, true, VERY_HIGH, 800",
                    "8, false, false, OTHER, 400",
                    "8, true, true, ELEVATED, 720",
                    "10, false, true, HIGH, 840",
                    "10, true, false, OTHER, 400",
                    "10, false, true, ELEVATED, 720",
                    "10, false, false, HIGH, 420",
                    "30, true, false, OTHER, 500",
                    "30, false, false, ELEVATED, 480",
                    "30, false, false, OTHER, 400",
                    "30, false, false, HIGH, 560",
                    "1, false, false, HIGH, 400",
                    "1, true, true, ELEVATED, 660",
                    "1, false, false, OTHER, 400",
                    "1, true, true, VERY_HIGH, 880",
                    "15, false, false, ELEVATED, 400",
                    "15, false, true, OTHER, 600",
                    "15, true, true, HIGH, 980",
                    "15, false, false, VERY_HIGH, 480",
                    "32, false, false, VERY_HIGH, 640",
                    "32, false, false, HIGH, 560",
                    "32, true, false, OTHER, 500",
                    "32, false, false, ELEVATED, 480"
            })
    public void positiveTest(int distance, boolean size, boolean fragility, Load load,String sum) throws Exception {
        System.out.println(CostCalculationClass.calcCost(distance, size, fragility, load));
        assertEquals(Integer.parseInt(sum), CostCalculationClass.calcCost(distance, size, fragility, load), "Сумма неверна");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0, true, true, VERY_HIGH, Введена некорректная дистанция",
                    "0, false, false, HIGH, Введена некорректная дистанция",
                    "32, true, true, VERY_HIGH, Нельзя доставить хрупкий товар дальше 30 км.",
                    "-1, false, false, ELEVATED, Введена некорректная дистанция"
            })
    public void negativeTest(int distance, boolean size, boolean fragility, Load load, String expectedMessage) throws Exception {
       Throwable exception = assertThrows(Exception.class, () -> {CostCalculationClass.calcCost(distance, size, fragility, load);});
       String message = exception.getMessage();
       assertTrue(message.contains(expectedMessage));
    }
}
