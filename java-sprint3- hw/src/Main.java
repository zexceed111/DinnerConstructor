import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DinnerConstructor dinnerConstructor = new DinnerConstructor();

        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                dinnerConstructor.addCustomDish();
            } else if (choice == 2) {
                dinnerConstructor.generateCombinations();
            } else if (choice == 3) {
                System.out.println("Выход из программы.");
                return;
            } else {
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

     public static void menu() {
        System.out.println("Выберите команду: ");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенирировать новобе людо");
        System.out.println("3 - Выход");
    }
}