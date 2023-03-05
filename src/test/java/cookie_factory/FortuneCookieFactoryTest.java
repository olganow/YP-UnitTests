package cookie_factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

public class FortuneCookieFactoryTest {
    FortuneCookieFactory fortuneCookieFactory;
    FortuneConfig config = new FortuneConfig(false);

    @BeforeEach
    public void beforeEach() {
        fortuneCookieFactory = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        );

    }
    ///shouldIncrementCountByOneAfterOneCookieBaked проверит,
    // что счётчик печенек в фабрике увеличивается на единицу после одной испечённой печеньки.

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {

        int firstCookie = 0;
        int secondCookie = fortuneCookieFactory.getCookiesBaked();
        assertEquals(firstCookie, secondCookie);

    }

    //shouldIncrementCountByTwoAfterTwoCookiesBaked проверит, что после двух испечённых печенек счёт увеличится на два.
    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();
        int secondCookie = fortuneCookieFactory.getCookiesBaked();
        assertEquals(2, secondCookie);

    }
    //shouldSetCounterToZeroAfterResetCookieCreatedCall проверит,
    // что после вызова resetCookiesCreated счётчик станет равным нулю.
    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookieFactory.resetCookiesCreated();
        int secondCookie = fortuneCookieFactory.getCookiesBaked();
        assertEquals(0, secondCookie);

    }

}
