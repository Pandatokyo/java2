package lesson5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public float[] reformat(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        reformat(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public void runTwoThreads() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(() -> {
            float[] a1 = reformat(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = reformat(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println((System.currentTimeMillis() - a));
    }

    public static void main(String[] s) {
        Main o = new Main();
        System.out.println("Время с использованием одного потока");
        o.runOneThread();
        System.out.println("Время с использованием двух потоков");
        o.runTwoThreads();
    }
}
