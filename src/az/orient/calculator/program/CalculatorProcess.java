package az.orient.calculator.program;

import az.orient.calculator.classes.*;
import az.orient.calculator.interfaces.*;

import java.util.Scanner;

public class CalculatorProcess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ashaqidaki 4 kalkulyatordan birini secin.");
        System.out.println("1- Apple Kalkulyatoru (Add,Subtract,Multiply,Divide,Square Root,Power)");
        System.out.println("2- Samsung Kalkulyatoru (Add,Subtract,Multiply,Divide,Log10,LogE,Loqarifm)");
        System.out.println("3- Nokia Kalkulyatoru (Add,Subtract,Multiply,Divide,Percentage,Round,Round Floor,Round Ceil)");
        System.out.println("4- Lg Kalkulyatoru (Add,Subtract,Multiply,Divide,Sin,Cos)");
        try {
            switch (sc.nextInt()) {
                case 1: {
                    System.out.println("Apple runs");
                    while (true) {
                        System.out.println("1 to continue, 2 to log out");
                        switch (sc.nextInt()) {
                            case 1: {
                                System.out.println("Emeliyyatlardan birini secin.");
                                System.out.println("1- Add \n2- Subtract \n3- Multiply \n4- Divide \n5- Square Root \n6- Power");
                                AppleCalculator appleCalculator = new AppleCalculatorImpl();
                                switch (sc.nextInt()) {
                                    case 1: {
                                        System.out.println("Ededleri daxil edin");
                                        System.out.println("Ededlerin cemi: " + appleCalculator.add(sc.nextDouble(), sc.nextDouble()));
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Ededleri daxil edin");
                                        System.out.println("Ededlerin ferqi: " + appleCalculator.subtract(sc.nextDouble(), sc.nextDouble()));
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Ededleri daxil edin");
                                        System.out.println("Ededlerin hasili: " + appleCalculator.multiply(sc.nextDouble(), sc.nextDouble()));
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Ededleri daxil edin");
                                        System.out.println("Ededlerin bolunmesi: " + appleCalculator.divide(sc.nextDouble(), sc.nextDouble()));
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Ededi daxil edin");
                                        System.out.println("Ededin kvadrat koku: " + appleCalculator.squareRoot(sc.nextDouble()));
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Ededleri daxil edin");
                                        System.out.println("Ededin quvveti: " + appleCalculator.power(sc.nextDouble(), sc.nextDouble()));
                                        break;
                                    }
                                    default:
                                        System.err.println("Zehmet olmasa 1-6 araliqinda tam eded secin");
                                        break;
                                }
                                break;
                            }
                            case 2:
                                System.exit(0);
                        }
                    }
                }
                case 2: {
                    SamsungCalculator samsungCalculator = new SamsungCalculatorImpl();
                    switch (sc.nextInt()) {
                        case 1: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin cemi: " + samsungCalculator.add(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 2: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin ferqi: " + samsungCalculator.subtract(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 3: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin hasili: " + samsungCalculator.multiply(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 4: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin bolunmesi: " + samsungCalculator.divide(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 5: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin 10luq loqarifmasi: " + samsungCalculator.log10(sc.nextDouble()));
                            break;
                        }
                        case 6: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin natural loqarifmasi: " + samsungCalculator.logE(sc.nextDouble()));
                            break;
                        }
                        case 7: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededin loqarifmasi: " + samsungCalculator.logarithm(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        default:
                            System.err.println("Zehmet olmasa 1-7 araliqinda tam eded secin");
                            break;
                    }
                    break;
                }
                case 3: {
                    NokiaCalculator nokiaCalculator = new NokiaCalculatorImpl();
                    switch (sc.nextInt()) {
                        case 1: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin cemi: " + nokiaCalculator.add(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 2: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin ferqi: " + nokiaCalculator.subtract(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 3: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin hasili: " + nokiaCalculator.multiply(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 4: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin bolunmesi: " + nokiaCalculator.divide(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 5: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededin faizi: " + nokiaCalculator.percentage(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 6: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin yuvarlaqi: " + nokiaCalculator.round(sc.nextDouble()));
                            break;
                        }
                        case 7: {
                            System.out.println("Ededi daxl edin");
                            System.out.println("Ededin yuvarlaqi: " + nokiaCalculator.roundFloor(sc.nextDouble()));
                            break;
                        }
                        case 8: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin yuvarlaqi: " + nokiaCalculator.roundCeil(sc.nextDouble()));
                            break;
                        }
                        default:
                            System.err.println("Zehmet olmasa 1-8 araliqinda eded secin");
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Lg runs");
                    System.out.println("Emeliyyatlardan birini secin.");
                    System.out.println("1- Add \n2- Subtract \n3- Multiply \n4- Divide \n5- Sin \n6- Cos");
                    LgCalculator lgCalculator = new LgCalculatorImpl();
                    switch (sc.nextInt()) {
                        case 1: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin cemi: " + lgCalculator.add(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 2: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin ferqi: " + lgCalculator.subtract(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 3: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin hasili: " + lgCalculator.multiply(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 4: {
                            System.out.println("Ededleri daxil edin");
                            System.out.println("Ededlerin bolunmesi: " + lgCalculator.divide(sc.nextDouble(), sc.nextDouble()));
                            break;
                        }
                        case 5: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin sinusu: " + lgCalculator.sin(sc.nextDouble()));
                            break;
                        }
                        case 6: {
                            System.out.println("Ededi daxil edin");
                            System.out.println("Ededin kosinusu: " + lgCalculator.cos(sc.nextDouble()));
                            break;
                        }
                        default:
                            System.err.println("Zehmet olmasa 1-6 araliqinda tam eded secin");
                            break;
                    }
                    break;
                }
                default: {
                    System.err.println("Zehmet omasa 1-4 araliqinda tam eded secin\n");
                    main(args);
                    break;
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            main(args);
        } catch (Exception ex) {
            System.err.println("Xeta bash verdi\n");
            main(args);
        }
    }
}