package az.orient.calculator.classes;

import az.orient.calculator.interfaces.SamsungCalculator;

public class SamsungCalculatorImpl extends AbstractCalculator implements SamsungCalculator {
     {
        System.out.println("Samsung runs");
        System.out.println("Emeliyyatlardan birini secin.");
        System.out.println("1- Add \n2- Subtract \n3- Multiply \n4- Divide \n5- Log10 \n6- LogE \n7- Logarithm");
    }

    @Override
    public double log10(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Loqarifmanin usdu 0 dan kicik beraber ola bilmez\n");
        }
        return Math.log10(num);
    }

    @Override
    public double logE(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Loqarifmanin usdu 0 dan kicik beraber ola bilmez\n");
        }
        return Math.log(num);
    }

    @Override
    public double logarithm(double num1, double num2) {
        if (num2 <= 0 || num1 == 1 || num1 <= 0) {
            throw new IllegalArgumentException("Loqarifmik xeta\n");
        }
        return Math.log(num2) / Math.log(num1);
    }
}
