package practice;

import java.util.*;

public class CoolNumbers {
    static ArrayList<String> coolNumber = new ArrayList<>();
    static ArrayList<String> coolNumberResult = new ArrayList<>();
    static HashSet<String> hashSet;
    static TreeSet<String> treeSet;
    static String[] chars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х",};
    static String firstLetter;
    static String secondLetter;
    static String thirdLetter;
    static String numberplate = "";
    static String numberRegion = "";


    public static List<String> generateCoolNumbers() {
        for (int number = 111; number <= 999; number += 111) {
            for (String aChar : chars) {
                firstLetter = aChar;
                for (String s : chars) {
                    secondLetter = s;
                    for (String value : chars) {
                        thirdLetter = value;
                        numberplate = String.format("%s%d%s%s", firstLetter, number, secondLetter, thirdLetter);
                        coolNumber.add(numberplate);
                    }
                }
            }
        }
        for (String fullNumber : coolNumber) {
            for (int z = 1; z < 200; z++) {
                if (coolNumberResult.size() == 2000001) {
                    break;
                } else {
                    if (z < 10) {
                        numberRegion = String.format("%s0%d", fullNumber, z);
                    } else {
                        numberRegion = String.format("%s%d", fullNumber, z);
                    }
                    coolNumberResult.add(numberRegion);
                }
            }

        }
        treeSet = new TreeSet<>(coolNumberResult);
        hashSet = new HashSet<>(coolNumberResult);
        return coolNumberResult;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long time = System.nanoTime();
        if (list.contains(number)) {
            System.out.println("Поиск перебором: номер найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return true;
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return false;
        }
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        long time = System.nanoTime();
        if (Collections.binarySearch(sortedList, number) < 0) {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return false;
        } else {
            System.out.println("Бинарный поиск: номер найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return true;
        }
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long time = System.nanoTime();
        if (hashSet.contains(number)) {
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return true;
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return false;
        }
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        long time = System.nanoTime();
        if (treeSet.contains(number)) {
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return true;
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (System.nanoTime() - time) + " нс.");
            return false;

        }
    }

}
