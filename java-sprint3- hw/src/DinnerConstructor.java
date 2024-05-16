import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

    public class DinnerConstructor {
        HashMap<String, ArrayList<String>> dish = new HashMap<>();

        public DinnerConstructor() {
            ArrayList<String> drink = new ArrayList<>();
            drink.add("Яблочный сок");
            drink.add("Апельсиновый сок");
            drink.add("Персиковый сок");
            dish.put("Напиток", drink);

            ArrayList<String> garnish = new ArrayList<>();
            garnish.add("Гречка");
            garnish.add("Картофельное пюре");
            garnish.add("Рис");
            dish.put("Гарнир", garnish);

            ArrayList<String> meat = new ArrayList<>();
            meat.add("Котлета пожарская");
            meat.add("Поджарка мясная");
            meat.add("Шашлык");
            dish.put("Мясо", meat);
        }

        public void generateCombinations() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество комбинаций:");
            int numCombinations = scanner.nextInt();
            scanner.nextLine();

            ArrayList<String> types = new ArrayList<>();
            System.out.println("Введите типы блюд, которые должны входить в комбинации (для завершения ввода нажмите Enter):");
            String type;
            while (!(type = scanner.nextLine()).isEmpty()) {
                if (dish.containsKey(type)) {
                    types.add(type);
                } else {
                    System.out.println("Такого типа блюда нет. Попробуйте снова.");
                }
            }

            Random random = new Random();
            for (int i = 1; i <= numCombinations; i++) {
                System.out.println("Комбинация " + i + ":");
                for (String t : types) {
                    ArrayList<String> dishes = dish.get(t);
                    String dish = dishes.get(random.nextInt(dishes.size()));
                    System.out.println(dish);
                }
                System.out.println();
            }
        }

        public void addCustomDish() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите тип блюда, которое хотите добавить:");
            for (String key : dish.keySet()) {
                System.out.println(key);
            }
            String type = scanner.nextLine();
            System.out.println("Введите название нового блюда:");
            String newDish = scanner.nextLine();

            if (dish.containsKey(type)) {
                ArrayList<String> dishes = dish.get(type);
                dishes.add(newDish);
                System.out.println("Блюдо добавлено в категорию " + type);
            } else {
                ArrayList<String> newDishes = new ArrayList<>();
                newDishes.add(newDish);
                dish.put(type, newDishes);
                System.out.println("Блюдо добавлено в новую категорию " + type);
            }
        }
    }


