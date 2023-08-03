package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MinMoves {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }

        String filename = args[0];
        int[] nums = readIntegersFromFile(filename);

        int moves = 0;
        int target = (int) Math.round(Arrays.stream(nums).average().getAsDouble());

        for (int num : nums) {
            int diff = num - target;
            moves += Math.abs(diff);
        }
        System.out.println(moves);
    }

    private static int[] readIntegersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            return new int[0];
        }
    }
}