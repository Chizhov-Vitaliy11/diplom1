import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private static String name = TestDataCreator.getName();
    private static float price = TestDataCreator.getPrice();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    private Burger burger;

    @BeforeEach
    public void before() {
        burger = new Burger();
    }

    @Test
    @Description("Проверка установки параметров для булочки")
    public void setBunCheck() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    @Description("Проверка добавления ингридиента")
    public void addIngredientCheck() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    @Description("Проверка удаления ингридиента")
    public void removeIngridientCheck() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    @Description("Проверка перемещения ингридиента")
    public void testMoveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.FILLING, name, price));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, name, price));
        burger.moveIngredient(1, 0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    @Description("Проверка получения стоимости бургера")
    public void getBurgerPriceCheck() {
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        Mockito.when(bun.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = price * 3;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    @Description("Проверка получения чека")
    public void getReceiptCheck() {
        Mockito.when(bun.getName()).thenReturn(name);
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(name);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = price * 3;
        String expectedReceipt = String.format("(==== %s ====)\r\n= sauce %s =\r\n(==== %s ====)\r\n\r\nPrice: %.6f\r\n", name, name, name, expectedPrice);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
