package Backtracking.Ej10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando la técnica Backtraking, escriba un algoritmo que dado un conjunto de números
 * enteros, devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro),
 * cuyas sumas sean exactamente cero.
 * Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos que suman cero son:
 * {-7, -1, 8} y {-3, -2, 5}.
 */
public class ConjuntosDisjuntos {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> zeroSubsets(int[] nums) {
        ArrayList<Integer> subset1 = new ArrayList<>();
        ArrayList<Integer> subset2 = new ArrayList<>();

        backtrack(nums, 0, subset1, subset2);
        return result;
    }

    private void backtrack(int[] nums, int currentIndex, ArrayList<Integer> subset1, ArrayList<Integer> subset2) {
        if (currentIndex == nums.length) {
            // Se recorrieron todos los elementos
            int sumSubset1 = sumOfElements(subset1);
            int sumSubset2 = sumOfElements(subset2);

            if ((sumSubset1 - sumSubset2) == 0){
                result.add(subset1);
                result.add(subset2);
            }

        }

        // Incluir el elemento actual en el subset1
        subset1.add(nums[currentIndex]);
        backtrack(nums, currentIndex + 1, subset1, subset2);
        subset1.remove(subset1.size() - 1); // Excluir el elemento actual de subset1

        // Incluir el elemento actual en el subset2
        subset2.add(nums[currentIndex]);
        backtrack(nums, currentIndex + 1, subset1, subset2);
        subset2.remove(subset2.size() - 1); // Excluir el elemento actual de subset2

    }

    private static int sumOfElements(List<Integer> subset) {
        int sum = 0;
        for (int num : subset) {
            sum += num;
        }
        return sum;
    }
}
