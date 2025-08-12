import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    @BeforeEach
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    static Stream<Arguments> ingredientProvider() {
        return Stream.of(
                Arguments.of(IngredientType.FILLING, TestDataCreator.getName(), TestDataCreator.getPrice()),
                Arguments.of(IngredientType.SAUCE, TestDataCreator.getName(), TestDataCreator.getPrice())
        );
    }

    @ParameterizedTest
    @MethodSource("ingredientProvider")
    @DisplayName("Проверка получения стоимости")
    void getPriceCheck(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.ingredientName = name;
        this.ingredientPrice = price;
        setUp();

        assertEquals(price, ingredient.getPrice(), 0);
    }

    @ParameterizedTest
    @MethodSource("ingredientProvider")
    @DisplayName("Проверка получения наименования")
    void getNameCheck(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.ingredientName = name;
        this.ingredientPrice = price;
        setUp();

        assertEquals(name, ingredient.getName());
    }

    @ParameterizedTest
    @MethodSource("ingredientProvider")
    @DisplayName("Проверка получения типа")
    void getTypeCheck(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.ingredientName = name;
        this.ingredientPrice = price;
        setUp();

        assertEquals(type, ingredient.getType());
    }
}
