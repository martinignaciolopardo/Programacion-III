package Backtracking.Ej4;

import java.util.ArrayList;
import java.util.List;

/**
 * Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición
 * en dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.
 */
public class ConjuntosDisjuntos {

    public static boolean canPartition(int[] nums) {
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            // Si la suma total es impar, no se puede hacer una partición equilibrada
            return false;
        }

        int targetSum = totalSum / 2;
        return backtrack(nums, 0, subset1, subset2, targetSum);
    }

    private static boolean backtrack(int[] nums, int currentIndex, List<Integer> subset1, List<Integer> subset2, int targetSum) {
        if (currentIndex == nums.length) {
            // Se recorrieron todos los elementos, se encontró una partición válida
            int sumSubset1 = sumOfElements(subset1);
            int sumSubset2 = sumOfElements(subset2);
            if (sumSubset1 == targetSum && sumSubset2 == targetSum) {
                System.out.println("Subset 1: " + subset1);
                System.out.println("Subset 2: " + subset2);
                return true;
            }
            return false;
        }

        // Incluir el elemento actual en el subset1
        subset1.add(nums[currentIndex]);
        if (backtrack(nums, currentIndex + 1, subset1, subset2, targetSum)) {
            return true;
        }
        subset1.remove(subset1.size() - 1); // Excluir el elemento actual de subset1

        // Incluir el elemento actual en el subset2
        subset2.add(nums[currentIndex]);
        if (backtrack(nums, currentIndex + 1, subset1, subset2, targetSum)) {
            return true;
        }
        subset2.remove(subset2.size() - 1); // Excluir el elemento actual de subset2

        return false;
    }

    private static int sumOfElements(List<Integer> subset) {
        int sum = 0;
        for (int num : subset) {
            sum += num;
        }
        return sum;
    }
}
