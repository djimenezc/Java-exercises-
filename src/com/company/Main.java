package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] A = {1, 5, 2, 1, 4, 0};


        int l = A.length;

        long[] A1 = new long[l];
        long[] A2 = new long[l];

        for (int i = 0; i < l; i++) {
            A1[i] = (long) A[i] + i;
            A2[i] = -((long) A[i] - i);
        }

        Arrays.sort(A1);
        Arrays.sort(A2);

        long cnt = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(A2, A1[i]);
            if (pos >= 0) {
                while (pos < A.length && A2[pos] == A1[i]) {
                    pos++;
                }
                cnt += pos;
            } else { // element not there
                int insertionPoint = -(pos + 1);
                cnt += insertionPoint;
            }

        }

        long sub = (long) l * ((long) l + 1) / 2;
        cnt = cnt - sub;

        if (cnt > 1e7) cnt = -1;

        System.out.print("Hello " + cnt);

        //return (int) cnt;
    }
}
