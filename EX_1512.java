// https://leetcode.com/problems/number-of-good-pairs/
public class EX_1512 {
    public int numIdenticalPairs(int[] nums) {

        // O(1), O(n), O(2n) .....

        int numeroDeBonsPares = 0;

        for (int i = 0; i < nums.length; i++) {

            int valorDeReferencia = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                int valorAtualSendoAnalisado = nums[j];

                if (valorDeReferencia == valorAtualSendoAnalisado) {
                    numeroDeBonsPares++;
                }
            }
        }

        return numeroDeBonsPares;
    }
}