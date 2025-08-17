
import com.github.javafaker.Faker;

import java.util.Random;

public class TestDataCreator {
    private static final Faker faker = new Faker();
    private static final Random rd = new Random();

    public static String getName() {
        return faker.funnyName().name();
    }

    public static float getPrice() {
        return rd.nextFloat();
    }
}