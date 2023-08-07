package task1;


public class CircularArray {
    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        int current = 0;
        do {
            System.out.print(arr[current]);
            current = (current + m - 1) % n;
        } while (current != 0);
    }
}

