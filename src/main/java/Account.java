import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String name;
    private static final String USERNAME_PATTERN = "(?=^.{3,19}$)([A-Za-z]{1,} [A-Za-z]{1,})";

    public Account(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Step("Check name with nameToEmboss method")
    public boolean checkNameToEmboss() {
        boolean isLengthValid;
        boolean isSpaceOne;
        boolean isEndSpacesNotExist;
        boolean isStartSpaceNotExist;
        try {
            isLengthValid = !name.isBlank() && name.length() <= 19 && name.length() >= 3;
            isSpaceOne = name.indexOf(' ') == name.lastIndexOf(' ');
            isEndSpacesNotExist = name.indexOf(' ') > 0 && name.indexOf(' ') + 1 != name.length();
            isStartSpaceNotExist = name.indexOf(' ') > 0 && name.indexOf(' ') != 0;
        } catch (NullPointerException exception) {
            return false;
        }
        return isLengthValid && isSpaceOne && isEndSpacesNotExist && isStartSpaceNotExist;
    }

    public boolean checkNameToEmbossRegexp() {
        final Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher;
        try {
            matcher = pattern.matcher(name);
        } catch (NullPointerException exception) {
            return false;
        }
        return matcher.matches();
    }
}
