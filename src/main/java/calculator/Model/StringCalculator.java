package calculator.Model;

public class StringCalculator {

    public long add(String input) {
        validateInput(input);

        String customDelimiter = null;
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            validateDelimiterFormat(newlineIndex);
            customDelimiter = input.substring(2, newlineIndex);
            validateDelimiterContent(customDelimiter);
            numbers = input.substring(newlineIndex + 2);
        }

        numbers = replaceDelimitersWithSpace(numbers, customDelimiter);

        String[] tokens = numbers.split(" ");
        long sum = calculateSum(tokens);
        checkOverflow(sum);
        return sum;
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input is empty.");
        }
    }

    private void validateDelimiterFormat(int newlineIndex) {
        if (newlineIndex == -1) {
            throw new IllegalArgumentException("Missing \\n after custom delimiter.");
        }
    }

    private void validateDelimiterContent(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("Custom delimiter must be a single character.");
        }
        char ch = delimiter.charAt(0);
        if (Character.isDigit(ch) || ch == '\\') {
            throw new IllegalArgumentException("Invalid custom delimiter: digit or backslash not allowed.");
        }
    }

    private String replaceDelimitersWithSpace(String numbers, String customDelimiter) {
        StringBuilder sb = new StringBuilder(numbers);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == ',' || ch == ':' || (customDelimiter != null && ch == customDelimiter.charAt(0))) {
                sb.setCharAt(i, ' ');
            }
        }
        return sb.toString();
    }

    private long calculateSum(String[] tokens) {
        long sum = 0;
        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("Empty value is not allowed.");
            }
            try {
                long number = Long.parseLong(token.trim());
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number: " + token);
            }
        }
        return sum;
    }

    private void checkOverflow(long result) {
        if (result > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Overflow: sum exceeds Integer.MAX_VALUE.");
        }
    }
}