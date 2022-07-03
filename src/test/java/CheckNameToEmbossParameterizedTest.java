
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
                {new Account("\n"), false},
                {new Account("\n" + " " + "\n"), false},
                {new Account(RandomStringUtils.randomAlphabetic(6) + "\n" + " " + RandomStringUtils.randomAlphabetic(4)), true},
        };
    }

    @Test
    public void checkNameToEmbossTest(){
        System.out.println(account.getName() + " " + account.getName().length());

        Assert.assertEquals(account.checkNameToEmboss(), expected);
    }
}
