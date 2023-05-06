package az.orient.calculator.classes;

import az.orient.calculator.interfaces.AppleCalculator;

public class AppleCalculatorImpl extends AbstractCalculator implements AppleCalculator {

    @Override
    public double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Menfi ededin kvadrat koku yoxdur\n");
        }
        return Math.sqrt(num);
    }

    @Override
    public double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}
