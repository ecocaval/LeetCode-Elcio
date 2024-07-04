// https://leetcode.com/problems/concatenation-of-array/
public class EX_1929 {

    public static void main(String[] args) {

        for (int num : getConcatenationGenralizada(new int[] { 1, 2, 1 }, 5)) {
            System.out.print(num + ",");
        }
        System.out.println();
        // 1,2,1 -> 1,2,1,1,2,1,1,2,1
    }

    // [0,3,10] -> [0,3,10,0,3,10]
    // entrada -> nums [] de inteiros, de tamanho n, n = 2 ex: [1,2] [2,1]
    // saida -> ans [] de inteiros, de tamanho 2n, n = 2 ex: [1,2,1,2] [2,1,2,1]
    // ans[i] == nums[i] -> ans[0] == nums[0], ans[1] == nums[1]
    // ans[i + n] == nums[i] ->
    // i = 1 e n = 2, ans[1+2] == nums[1] .: ans[3] == nums[1]

    public static int[] getConcatenation(int[] nums) {

        // n = 2 -> nums[0], nums[1]
        int[] ans = new int[nums.length * 2];

        // nums = [1,2]
        // ans = [0,0,0,0]

        // 1a. interação: ans[1,0,1,0]
        // 1a. interação: ans[1,2,1,2]

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }

    public static int[] getConcatenationGenralizada(int[] nums, int numeroDeDuplicacoes) {

        // nums = [1,2]
        // numeroDeDuplicacoes = 3

        // n = 2
        int n = nums.length;

        // ans = [1,0,1,0,1,0]
        int[] ans = new int[numeroDeDuplicacoes * n];

        for (int contador1 = 0; contador1 < n; contador1++) {

            // ans[0] = nums[0]
            ans[contador1] = nums[contador1];

            // 3 > 1 = true
            if (numeroDeDuplicacoes > 1) {
                for (int contador2 = 1; contador2 < numeroDeDuplicacoes; contador2++) {
                    // 1a. interacao: ans[2] = nums[0]
                    // 2a. interacao: ans[4] = nums[0]
                    ans[contador1 + (contador2 * n)] = nums[contador1];
                }
            }

            // ans[i + (1 * nums.length)] = nums[i];
            // ans[i + (2 * nums.length)] = nums[i];
            // ans[i + (3 * nums.length)] = nums[i];
        }
        return ans;
    }
}