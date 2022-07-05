
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckNameToEmbossParameterizedTest {
    Account account;
    boolean expected;

    public CheckNameToEmbossParameterizedTest(Account account, boolean expected) {
        this.account = account;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAccountData() {
        return new Object[][]{
                {new Account(RandomStringUtils.randomAlphabetic(3) + " " + RandomStringUtils.randomAlphabetic(5)), true},
                {new Account(RandomStringUtils.randomAlphabetic(1) + " " + RandomStringUtils.randomAlphabetic(1)), true},
                {new Account(RandomStringUtils.randomAlphabetic(8) + " " + RandomStringUtils.randomAlphabetic(10)), true},
                {new Account(RandomStringUtils.randomAlphabetic(2) + " "), false},
                {new Account(" " + RandomStringUtils.randomAlphabetic(18)), false},
                {new Account(RandomStringUtils.randomAlphabetic(2)), false},
                {new Account(RandomStringUtils.randomAlphabetic(4)), false},
                {new Account(" " + RandomStringUtils.randomAlphabetic(7)), false},
                {new Account(RandomStringUtils.randomAlphabetic(9) + " "), false},
                {new Account(" " + RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(4) + " "), false},
                {new Account(RandomStringUtils.randomAlphabetic(20)), false},
                {new Account(""), false},
                {new Account(" "), false},
                {new Account("   "), false},
        };
    }

    @Test
    @DisplayName("Check method nameToEmboss with different data")
    public void checkNameToEmbossTest(){
        Assert.assertEquals(account.checkNameToEmboss(), expected);
    }

    @Test
    @DisplayName("Check method nameToEmbossRegexp with different data")
    public void checkNameToEmbossRegexpTest(){
        Assert.assertEquals(account.checkNameToEmbossRegexp(), expected);
    }
}
