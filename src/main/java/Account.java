public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkNameToEmboss() {

        if (name.isBlank()) {
            System.out.println("Введена пустая строка");
            return false;
        } else if (name.length() >= 3 && name.length() <= 19) {
            if (name.contains(" ")) {
                if (spacesCount(name) == 1 && !name.startsWith(" ") && !name.endsWith(" ")) {
                    System.out.println("Имя и фамилия заданы корректно");
                    return true;
                } else {
                    System.out.println("В строке не должно быть больше одного пробела. Пробел не должен быть в начале и в конце строки.");
                    return false;
                }
            }
            else {
                System.out.println("Строка должна содержать один пробел. Пробел не должен быть в начале и в конце строки.");
                return false;
            }
        } else {
            System.out.println("В строке должно быть не меньше 3 и не больше 19 символов");
            return false;
        }
    }

    public int spacesCount(String name) {
        int i = name.indexOf(" ");
        int count = 0;
        while (i != -1) {
            i = name.indexOf(" ", i + 1);
            count += 1;
        }
        return count;
    }
}
