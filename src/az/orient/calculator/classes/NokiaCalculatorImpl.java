package az.orient.calculator.classes;

import az.orient.calculator.interfaces.NokiaCalculator;

public class NokiaCalculatorImpl extends AbstractCalculator implements NokiaCalculator {
     {
        System.out.println("Nokia runs");
        System.out.println("Emeliyyatlardan birini secin.");
        System.out.println("1- Add \n2- Subtract \n3- Multiply \n4- Divide \n5- Percentage \n6- Round \n7- Round Floor" +
                "\n8- Round Ceil");
    }

    @Override
    public double percentage(double num1, double num2) {
        return (num1 * num2) / 100;
    }

    @Override
    public double round(double num) {
        return Math.round(num);
    }

    @Override
    public double roundFloor(double num) {
        return Math.floor(num);
    }

    @Override
    public double roundCeil(double num) {
        return Math.ceil(num);
    }
}
