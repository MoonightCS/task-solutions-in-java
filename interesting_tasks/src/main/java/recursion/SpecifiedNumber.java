package recursion;

/*
Реализуй метод createExpression(int number).
Метод createExpression вызывается с одним параметром number. Этот параметр — число от 1 до 3000 включительно.
Нужно вывести арифметическое выражение, результатом которого является число number.
Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
Можно использовать знаки: «+» и «—» любое количество раз.
Обрати внимание, что перед каждым числом в искомой строке обязательно должен быть знак плюс или минус.
Перед выражением выведи [переданное число] =. (Смотри примеры вывода ниже).

Пример1:
Переданное число:
74
Ожидаемый вывод:
74 = - 1 + 3 - 9 + 81

Пример2:
Переданное число:
1234
Ожидаемый вывод:
1234 = + 1 - 9 + 27 - 243 - 729 + 2187

При выводе выражения используй числа ТОЛЬКО В ВОЗРАСТАЮЩЕМ порядке!
Переданное число:
2
Ожидаемый вывод:
2 = - 1 + 3 //правильно
Ожидаемый вывод:
2 = + 3 - 1 //НЕ правильно
 */

import java.util.*;

public class SpecifiedNumber {
    List<Integer> expression = new ArrayList<>();

    public static void main(String[] args) {
        SpecifiedNumber specifiedNumber = new SpecifiedNumber();
        specifiedNumber.createExpression(1234);
    }

    private void createExpression(int number) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187));
        findExpression(number, 0, 0, numbers, new Stack<>());
        Collections.reverse(expression);
        System.out.print(number + " =");
        for (int i = 0; i < expression.size(); i++) {
            int n = expression.get(i);
            if (n < 0) {
                System.out.printf(" - %d", Math.abs(n));
            } else System.out.printf(" + %d", n);
        }

    }

    private boolean findExpression(int number, int ourNumber, int index, List<Integer> numbers, Stack<Integer> stack) {
        if (number == ourNumber) {
            while (!stack.isEmpty()) {
                expression.add(stack.pop());
            }
            return true;
        }
        if (numbers.size() == index) {
            return false;
        }

        int integer = numbers.get(index);
        stack.push(integer);
        if (findExpression(number, ourNumber + integer, index + 1, numbers, stack)) {
            return true;
        }
        stack.pop();
        integer = -integer;
        stack.push(integer);

        if (findExpression(number, ourNumber + integer, index + 1, numbers, stack)) {
            return true;
        }
        stack.pop();

        if (findExpression(number, ourNumber, index + 1, numbers, stack)) {
            return true;
        } else {
            return false;
        }
    }
}
