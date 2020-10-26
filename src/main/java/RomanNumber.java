import java.util.TreeMap;

/**
 * Class contains a method for converting arabic number to roman number
 * between 1 and 100.
 */

public class RomanNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    /**
     * The method converts an integer to a String containing a corresponding Roman number.
     *
     * @param num an arabic number
     * @return A String containing Roman number or an empty string if the corresponding value isn't found.
     */
    public static String convertToRoman(int num) {
        if (num > 100 || num < 1) {
            return "";
        }
        int a = map.floorKey(num); //return keyOrNull(getFloorEntry(key));
        if (num == a) {
            return map.get(num);
        }
        return map.get(a) + convertToRoman(num - a);
    }
}

class Test {
    public static void main(String[] args) {
        int a = 50;
//        System.out.println(RomanNumber.convertToRoman(a));
        assert RomanNumber.convertToRoman(a).equals("L");
    }
}
