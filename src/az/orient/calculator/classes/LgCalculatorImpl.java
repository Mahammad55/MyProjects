package az.orient.calculator.classes;

import az.orient.calculator.interfaces.LgCalculator;

public class LgCalculatorImpl extends AbstractCalculator implements LgCalculator {

    @Override
    public double sin(double num) {
        return Math.sin(num);
    }

    @Override
    public double cos(double num) {
        return Math.cos(num);
    }
}
