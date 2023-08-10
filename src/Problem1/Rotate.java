package Problem1;

/*
* Problem 1
*
* You may have been using Java for a while. Do you think a simple Java array
* question can be a challenge? Let’s use the following problem to test.
* Problem: Rotate an array of n elements to the right by k steps. For example,
* with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
* How many different ways do you know to solve this problem?
* */

public class Rotate {

    // TODO: Aplicar generico en la funcion

    public static int[] rotateArray (int[] arrayValues, int nSteps) {

        // Variables frecuentes

        int arrLength = arrayValues.length;

        // Validaciones previas

        // Array con elementos
        if (arrLength == 0) {
            throw new IllegalArgumentException("El array esta sin elementos.");
        }

        // Numero de pasos a rotar es negativo
        if (nSteps < 0) {
            throw new IllegalArgumentException("El parametro nSteps debe ser mayor o igual a 0");
        }
        /*
        Si los paso son mayores a la longitud del array
        Debemos modularizar en nSteps y hacer el menor numero de iteraciones para
        rotar el array
         */
        else if (nSteps >= arrLength) {
            nSteps %= arrLength;
        }

        // No hay cambios en el array, se devuelve el array original
        if(nSteps == 0){
            return arrayValues;
        }

        int[] rotateArray = new int[arrLength];

        int pos;

        for (int i = 0; i < arrLength; i++) {
            pos = (i + nSteps) % arrLength;
            rotateArray[pos] = arrayValues[i];
        }

        return rotateArray;

    }
}
