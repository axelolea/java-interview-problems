package Problem002;

import java.util.Stack;
import java.util.regex.Pattern;

public class ReversePolishNotation {


    // Operators
    private static final String plusOperator = "+";
    private static final String minusOperator = "-";
    private static final String multiplyOperator = "*";
    private static final String divideOperator = "/";

    private static final String operators = plusOperator + minusOperator + multiplyOperator + divideOperator;



    public static int evaluate (String[] values) {

        Stack<Integer> numbersStack = new Stack<>();
        Pattern numberPattern = Pattern.compile("^\\d+$");

        for (String value: values) {

            if(numberPattern.matcher(value).matches()){
                int numberValue = Integer.parseInt(value);
                numbersStack.push(numberValue);
                continue;
            }

            // Si es valor es de longitud 1 y esta en los operators
            if(value.length() == 1 && operators.contains(value)){

                if (numbersStack.size() < 2) {
                    throw new RuntimeException("Faltan valores numericos");
                }

                int valueA = numbersStack.pop();
                int valueB = numbersStack.pop();
                /*
                * Las operaciones estan al revez ya que al apilar los numeros,
                * se invierte el order de la opreacion
                *
                * Ejemplo:
                *
                * Stack:
                * [ValueC, ValueB, ValueA]
                *
                * Al envocar el metodo pop, retiramos el ultimo elemento en ingresar al stack
                *
                * ValueC + ValueB + ValueA
                *
                * */

                switch (value) {
                    case plusOperator:
                        numbersStack.push(valueB + valueA);
                        break;
                    case minusOperator:
                        numbersStack.push(valueB - valueA);
                        break;
                    case multiplyOperator:
                        numbersStack.push(valueB * valueA);
                        break;
                    case divideOperator:
                        numbersStack.push(valueB / valueA);
                        break;
                }

                continue;
            }

            // Si no se valida que es un numero o un operador, lanzar un error
            throw new IllegalArgumentException("El array contiene un valor invalido: [" + value + "]");
        }

        if (numbersStack.size() != 1){
            throw new RuntimeException("Sobran elementos en la pila de numeros");
        }

        return numbersStack.pop();

    }
}
