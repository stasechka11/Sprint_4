import java.util.Scanner;

public class Praktikum {
    public static String fullName = "Имя Фамилия ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(fullName);
        System.out.println(account.checkNameToEmboss());
    }
}
