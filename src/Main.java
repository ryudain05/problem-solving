import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int buyPizza = 0;
        int buyHamburger = 0;
        int nothing = 0;
        int customer = 0;
        ArrayList<String> orderList = new ArrayList<>();
        Queue<String> foodList = new LinkedList<>();

        while (true) {
            // 입력
            String[] order = scanner.nextLine().split(" ");
            // 만약 입력이 E라면 종료
            if (order[0].equals("E")) {
                break;
            }

            // 주문 또는 음식 넣기
            if (order[0].equals("O")) {
                if (customer >= 2) {
                    nothing++;
                } else {
                    customer++;
                    orderList.add(order[1]);
                }
            } else if (order[0].equals("F")) {
                foodList.add(order[1]);
            }

            // 음식이 없으면 다음
            if (foodList.isEmpty()) {
                continue;
            }

            int index = 0;
            while (!foodList.isEmpty() && index < orderList.size()) {
                if (orderList.get(index).equals("Any")) {
                    orderList.remove(index);
                    String a = foodList.poll();
                    if (a.equals("Hamburger")) {
                        buyHamburger++;
                    } else {
                        buyPizza++;
                    }
                    customer--;
                } else if (orderList.get(index).equals("Pizza")) {
                    if (foodList.contains("Pizza")) {
                        orderList.remove(index);
                        foodList.remove("Pizza");
                        buyPizza++;
                        customer--;
                    } else {
                        index++;
                    }
                } else {
                    if (foodList.contains("Hamburger")) {
                        orderList.remove(index);
                        foodList.remove("Hamburger");
                        buyHamburger++;
                        customer--;
                    } else {
                        index++;
                    }
                }
            }
        }

        System.out.println("Pizza: " + buyPizza);
        System.out.println("Hamburger: " + buyHamburger);
        System.out.println("Nothing: " + (nothing + orderList.size()));
    }
}