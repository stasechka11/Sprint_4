import java.util.Scanner;

public class Praktikum {
    public static String fullName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя и фамилию владельца." +
                "- В строке должно быть не меньше 3 и не больше 19 символов" +
                "- В строке есть только один пробел" +
                "- Пробел стоит не в начале и не в конце строки");
        fullName = scanner.nextLine();
        Account account = new Account(fullName);
        System.out.println(account.checkNameToEmboss());
    }
}
