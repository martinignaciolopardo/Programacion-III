package Backtracking.Ej10;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilizando la técnica Backtraking, escriba un algoritmo que dado un conjunto de números
 * enteros, devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro),
 * cuyas sumas sean exactamente cero.
 * Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos que suman cero son:
 * {-7, -1, 8} y {-3, -2, 5}.
 */
public class ZeroSumSubsets {

    ArrayList<ArrayList<Integer>> result;
    private int[] nums;
    private int targetSize;

    public ZeroSumSubsets(int[] nums, int targetSize) {
        this.nums = nums;
        this.result = new ArrayList<>();
        this.targetSize = targetSize;
    }

    public ArrayList<ArrayList<Integer>> findSubsets() {
        ArrayList<Integer> currentSubset = new ArrayList<>();
        backtrack(0, currentSubset);
        return result;
    }

    private void backtrack(int currentIndex, ArrayList<Integer> currentSubset) {
        if (currentSubset.size() == targetSize) {
            if (sumOfElements(currentSubset) == 0) {
                result.add(new ArrayList<>(currentSubset));
            }
            return;
        }
        if (currentIndex >= nums.length) {
            return;
        }

        // Incluir el elemento actual en el subset1
        currentSubset.add(nums[currentIndex]);
        backtrack(currentIndex + 1, currentSubset);
        currentSubset.remove(currentSubset.size() - 1); // Excluir el elemento actual de subset1

        backtrack(currentIndex + 1, currentSubset);
    }

    private static int sumOfElements(List<Integer> subset) {
        int sum = 0;
        for (int num : subset) {
            sum += num;
        }
        return sum;
    }
}
