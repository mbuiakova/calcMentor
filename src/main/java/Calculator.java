import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<String, Integer> romanNum = new HashMap<>();

    static {
        romanNum.put("I", 1);
        romanNum.put("II", 2);
        romanNum.put("III", 3);
        romanNum.put("IV", 4);
        romanNum.put("V", 5);
        romanNum.put("VI", 6);
        romanNum.put("VII", 7);
        romanNum.put("VIII", 8);
        romanNum.put("IX", 9);
        romanNum.put("X", 10);
    }

    public void parseAndCalculate(String[] array, String line) throws WrongNumberException {
        if (array.length < 2) {
            throw new WrongNumberException("You entered the wrong number, use 1 - 10 numbers");
        }
        if (isNumeric(array[0]) && isNumeric(array[1])) {
            parseArabicAndCalculate(array, line);
        } else if (isRome(line)) {
            parseRomanAndCalculate(array, line);
        } else {
            throw new WrongNumberException("You entered incorrect data, use numbers 1 - 10");
        }
    }

    private void parseRomanAndCalculate(String[] array, String line) throws WrongNumberException {
        String operator;
        int secondNum;
        int firstNum;
        operator = line.replaceAll("\\w", "");
        if (romanNum.containsKey(array[0]) && romanNum.containsKey(array[1])) {
            firstNum = romanNum.get(array[0]);
            secondNum = romanNum.get(array[1]);
        } else {
            throw new WrongNumberException("You entered the wrong number, use 1 - 10 numbers");
        }
        int a = calculate(firstNum, secondNum, operator);
        if (a == 0) {
            System.out.println("zero");
        } else if (a < 0) {
            System.out.println("Greeks didn't have negative numbers");
        } else {
            System.out.println(RomanNumber.convertToRoman(a));
        }
    }

    private void parseArabicAndCalculate(String[] array, String line) throws WrongNumberException {
        int secondNum;
        String operator;
        int firstNum;
        operator = line.replaceAll("\\d", "");
        firstNum = Integer.parseInt(array[0]);
        secondNum = Integer.parseInt(array[1]);
        if (firstNum < 1 || firstNum > 10 || secondNum < 1 || secondNum > 10) {
            throw new WrongNumberException("You entered the wrong number, use 1 - 10 numbers");
        }
        System.out.println(calculate(firstNum, secondNum, operator));
//        if (calculate(firstNum, secondNum, operator) > 0) {
//            System.out.println(calculate(firstNum, secondNum, operator));
//        }
    }

    public boolean isNumeric(String s) {
        try {
            int a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isRome(String s) {
        String regex = "([IVX]*)([-+*/]{1})([IVX]*)";
        return s.matches(regex);
    }

    public int calculate(int firstNum, int secondNum, String operator) throws WrongNumberException {
        if (operator.equals("+")) {
            return firstNum + secondNum;
        } else if (operator.equals("-")) {
            return firstNum - secondNum;
        } else if (operator.equals("*")) {
            return firstNum * secondNum;
        } else if (operator.equals("/")) {
            return firstNum / secondNum;
        } else {
            throw new WrongNumberException("You entered the wrong sign operation. Please, try again using +, -, *, /");
        }
    }
}
