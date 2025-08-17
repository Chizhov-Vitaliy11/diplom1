import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BunTest extends BurgerTest {
    private static String name = TestDataCreator.getName();
    private static float price = TestDataCreator.getPrice();
    Bun bun = new Bun(name,price);

    @Test
    @Description("Проверка присвоения имени")
    public void getNameCheck() {
        assertEquals(name, bun.getName());
    }

    @Test
    @Description("Проверка присвоения цены")
    public void getPriceCheck() {
        assertEquals(price, bun.getPrice(), 0);
    }
}
