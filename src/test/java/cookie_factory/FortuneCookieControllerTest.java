package cookie_factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FortuneCookieControllerTest {
    FortuneCookieController fortuneCookieController ;
    FortuneConfig config = new FortuneConfig(false);

    @BeforeEach
    public void beforeEach() {
        fortuneCookieController = new FortuneCookieController( new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        )
        );
    }

    //shouldReturnPositiveFortune должен проверять, что фабрика может испечь печеньку с хорошим предсказанием.
    @Test
    public void shouldReturnPositiveFortune() {
        config = new FortuneConfig(true);
        fortuneCookieController = new FortuneCookieController( new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        )
        );
        // fortuneCookieController.tellFortune().getFortuneText();
        assertTrue(fortuneCookieController.tellFortune().getFortuneText().equals("positive"));
    }


    //shouldReturnNegativeFortune проверит, что фабрика также умеет печь печеньки с негативными предсказаниями.

    @Test
    public void shouldReturnNegativeFortune() {
        assertTrue(fortuneCookieController.tellFortune().getFortuneText().equals("negative"));
    }

}
