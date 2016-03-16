package me.jrkr;

import javax.swing.*;
import java.text.DecimalFormat;

public class GuiCalculate {
    public static final double CONV = 4.184;

    public static void main(String args[]) {
        Object[] possibleValues = {"Calories to Kilojoules", "Kilojoules to Calories"};
        Object selectedValue = JOptionPane.showInputDialog(null, "What do you want to do?", "Calculator", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        if (selectedValue == null) {
            System.exit(0);
        }

        boolean cont = false;
        double number1 = 0;
        while (cont != true) {
            cont = true;
            String firstNumber = "";
            if (selectedValue == "Calories to Kilojoules") {
                firstNumber = JOptionPane.showInputDialog("How many Calories to convert");
            } else {
                firstNumber = JOptionPane.showInputDialog("How many Kilojoules to convert");
            }
            if (firstNumber == null) {
                System.exit(0);
            }

            try {
                number1 = Double.parseDouble(firstNumber);
                String a = Double.toString(number1);
                if (number1 <= 0) {
                    cont = false;
                    JOptionPane.showMessageDialog(null, "Can't enter values equal to or less than 0.\nPlease try again", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                } else if (a.length() > 7) {
                    cont = false;
                    JOptionPane.showMessageDialog(null, "To many numbers entered.\nPlease try again", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                    number1 = 0;
                }

            } catch (NumberFormatException e) {
                cont = false;
                JOptionPane.showMessageDialog(null, "A fatal error has occured when trying\nto convert your entry to a integer.\nPlease try again", "Fatal Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        double total = 0;
        DecimalFormat fmt = new DecimalFormat("0.000");
        fmt.setMinimumFractionDigits(3);
        fmt.setMinimumIntegerDigits(1);
        if (selectedValue == "Calories to Kilojoules") {
            total = number1 * CONV;
            String printResult = fmt.format(total);
            String number2 = fmt.format(number1);
            JOptionPane.showMessageDialog(null, "You entered: " + number2 + " Calories" + "\nThe converted total is: " + printResult + " Kilojoules", "Calories converted to Kilojoules", JOptionPane.PLAIN_MESSAGE);
        } else {
            total = number1 / CONV;
            String printResult = fmt.format(total);
            JOptionPane.showMessageDialog(null, "You entered: " + number1 + " Kilojoules" + "\nThe converted total is: " + printResult + " Calories", "Kilojoules converted to Calories", JOptionPane.PLAIN_MESSAGE);
        }

    }
}
