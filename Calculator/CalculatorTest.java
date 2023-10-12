package Calculator;

import org.assertj.core.api.Assertions;

public class CalculatorTest {

    public static void main(String[] args) {
        testCalculation();
        testSquareRootExtraction();
        testCalculateDiscount();
    }

    public static void testCalculation() {
        Assertions.assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        Assertions.assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        Assertions.assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);

        try {
            Calculator.calculation(10, 0, '/');
            System.out.println("Тест не пройден: Не было выброшено исключение деления на ноль");
        } catch (ArithmeticException e) {
            Assertions.assertThat(e.getMessage()).contains("Деление на ноль невозможно");
        }
    }

    public static void testSquareRootExtraction() {
        Assertions.assertThat(Calculator.squareRootExtraction(169)).isEqualTo(13.0, Assertions.offset(0.01));

        try {
            Calculator.squareRootExtraction(-9);
            System.out.println("Тест не пройден: Не было выброшено исключение для отрицательного числа");
        } catch (IllegalArgumentException e) {
            Assertions.assertThat(e.getMessage()).contains("Невозможно вычислить квадратный корень отрицательного числа");
        }
    }

    public static void testCalculateDiscount() {
        double purchaseAmount = 100.0;
        int discountPercentage = 20;
        double discountedAmount = Calculator.calculateDiscount(purchaseAmount, discountPercentage);
        Assertions.assertThat(discountedAmount).isEqualTo(80.0, Assertions.offset(0.01));

        double purchaseAmountWithoutDiscount = 75.0;
        int noDiscount = 0;
        double amountWithoutDiscount = Calculator.calculateDiscount(purchaseAmountWithoutDiscount, noDiscount);
        Assertions.assertThat(amountWithoutDiscount).isEqualTo(75.0, Assertions.offset(0.01));

        try {
            Calculator.calculateDiscount(-100, 20);
            System.out.println("Тест не пройден: Не было выброшено исключение для отрицательной суммы покупки");
        } catch (ArithmeticException e) {
            Assertions.assertThat(e.getMessage()).contains("Недопустимый ввод: сумма покупки и процент скидки должны быть неотрицательными, а процент скидки должен быть от 0 до 100.");
        }
    }
}
