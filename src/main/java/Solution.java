import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter two numbers from 1 till 10 with math operator +, -, *, /");
            String line = reader.readLine().replaceAll(" ", "");
            String[] array = line.split("\\W+");

            Calculator calculator = new Calculator();
            calculator.parseAndCalculate(array, line);

        } catch (IOException | WrongNumberException e) {
            e.printStackTrace();
        }
    }
}
