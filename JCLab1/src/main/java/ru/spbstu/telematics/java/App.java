package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("Разложение числа на простые множители. \nВведите число");

        Scanner in = new Scanner(System.in);

        boolean flag = false;
        int number = 0;
        while(!flag) {
            try {
                number = Integer.parseInt(in.nextLine());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Число введено некорректно, попробуйте снова");
            }
        }

        ArrayList<Integer> multiplyers = getMultipliers(number);

        System.out.println("Список множителей числа " + number);
        System.out.println(multiplyers);
    }

    private static ArrayList<Integer> getMultipliers(int number) {
        ArrayList<Integer> multiplyers = new ArrayList<>();

        double sqrt = Math.sqrt(number);
        int currentValue = number;
        int multiplier = 2;
        while (currentValue > 1 && multiplier <= sqrt)
        {
            if (currentValue % multiplier == 0)
            {
                multiplyers.add(multiplier);
                currentValue /= multiplier;
            }
            else if (multiplier == 2)
            {
                multiplier++;
            }
            else
            {
                multiplier += 2;
            }
        }
        if (currentValue != 1)
        {
            multiplyers.add(currentValue);
        }
        return multiplyers;
    }
}
