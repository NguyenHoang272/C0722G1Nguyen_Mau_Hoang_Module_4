package caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculate(String operation, double number1, double number2) {
        switch (operation) {
            case "add":
                return number1 + number2;
            case "sub":
                return number1 - number2;
            case "mul":
                return number1 * number2;
            case "div":
                if(number2!=0) {
                    return number1 / number2;
                }
        }
        return 0;
    }
}
