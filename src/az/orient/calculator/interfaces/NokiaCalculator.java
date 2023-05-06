package az.orient.calculator.interfaces;

public interface NokiaCalculator extends Calculator {
    double percentage(double num1,double num2);
    double round(double num);
    double roundFloor(double num);
    double roundCeil(double num);
}
