package Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Деление на ноль невозможно");
                }
            default:
                throw new IllegalStateException("Непредвиденное значение оператора: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Невозможно вычислить квадратный корень отрицательного числа");
        }
        return Math.sqrt(num);
    }

    public static double calculateDiscount(double purchaseAmount, int discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Недопустимый ввод: сумма покупки и процент скидки должны быть неотрицательными, а процент скидки должен быть от 0 до 100.");
        }

        double discountAmount = (purchaseAmount * discountPercentage) / 100.0;
        return purchaseAmount - discountAmount;
    }
}