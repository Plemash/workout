package practice;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoolNumbers.generateCoolNumbers();
        System.out.println(CoolNumbers.coolNumberResult.size());

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            } else {
// Вычисление среднего времени поиска в HashSet:
//                long averageTime = 0;
//                for (int i = 1; i <= 40; i++) {
//                    long time = System.nanoTime();
//                    long timeResult;
//                    CoolNumbers.searchInHashSet(CoolNumbers.hashSet, input);
//                    if (i > 20) {
//                    System.out.println(i + " - " + "Поиск занял: " + (timeResult = System.nanoTime() - time) + " нс.");
//                    averageTime += timeResult;
//                    if (i == 40) {
//                        long result = (averageTime / i);
//                        System.out.println(" Среднее время поиска занимает: " + result + " нс.");
//
//                    }
//                }
//            }
                CoolNumbers.bruteForceSearchInList(CoolNumbers.coolNumberResult, input);
                CoolNumbers.binarySearchInList(CoolNumbers.coolNumberResult, input);
                CoolNumbers.searchInHashSet(CoolNumbers.hashSet, input);
                CoolNumbers.searchInTreeSet(CoolNumbers.treeSet, input);
            }

        }
    }
}


