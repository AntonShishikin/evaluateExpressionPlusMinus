public class Finder {
    private static int evaluateExpression(String expression) {
        int total = 0;
        int currentNumber = 0;
        int sign = 1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                total += sign * currentNumber;
                currentNumber = 0;

                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
            }
        }
        total += sign * currentNumber;
        return total;
    }

    private static void findExpression(String digits, int target, String expression, int pos) {
        if (pos == digits.length()) {
            if (evaluateExpression(expression) == target) {
                System.out.println(expression + " = " + target);
            }
            return;
        }

        findExpression(digits, target, expression + digits.charAt(pos), pos + 1);
        findExpression(digits, target, expression + "+" + digits.charAt(pos), pos + 1);
        findExpression(digits, target, expression + "-" + digits.charAt(pos), pos + 1);
    }

    public static void main(String[] args) {
        String digits = "9876543210";
        int target = 200;

        findExpression(digits, target, String.valueOf(digits.charAt(0)), 1);
    }
}
