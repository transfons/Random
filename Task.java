import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите два числа (диапазон): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] numArr = InputValidator.parseAndValidateRange(input);

        int result = RandomNumberGenerator.generate(numArr[0], numArr[1]);
        System.out.println("Сгенерированное число = " + result + " в диапазоне от " + numArr[0] + " до " + numArr[1]);
        }
    }


class InputValidator {
    public static int[] parseAndValidateRange(String input) {
        int[] numArr;
        numArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = numArr.length;

        if (length > 2) {
            System.out.println("Неверно заданный диапазон: количество введенных чисел = " + length);
            System.exit(0);
        }
        if (numArr[0] < 0) {
            System.out.println("Число должно  быть положительным: " + numArr[0]);
            System.exit(0);
        } else if (numArr[0] > 1000000) {
            System.out.println("Неверно заданный диапазон");
            System.exit(0);
        }
        if (numArr[1] < 1) {
            System.out.println("Число должно  быть положительным: " + numArr[1]);
            System.exit(0);
        } else if (numArr[1] > 1000000) {
            System.out.println("Неверно заданный диапазон");
            System.exit(0);
        }
        if (numArr[0] > numArr[1]) {
            System.out.println("Верхняя граница должна быть больше нижней: нижняя граница = " + numArr[0] + ", верхняя граница = " + numArr[1]);
            System.exit(0);
        }
        return numArr;
    }
}


class RandomNumberGenerator {
    public static int generate(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
