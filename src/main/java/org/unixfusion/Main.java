package org.unixfusion;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] data1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        int [] result = dataReverse(data1);
        for (int a=0; a < result.length; a++) {
            System.out.print(result[a] + " ");
        }
    }
    public static int[] dataReverse(int[] data) {
        int chunkSize = 8;
        int chunks = data.length / chunkSize;
        int[][] arrays = new int[data.length/chunkSize][];
        for (int i = 0; i < chunks; i++) {
            arrays[i] = Arrays.copyOfRange(data, i * chunkSize, i * chunkSize + chunkSize);
        }
        Collections.reverse(Arrays.asList(arrays));
        return Arrays.stream(arrays).flatMapToInt(o -> Arrays.stream(o))
                .toArray();
    }
}