package feb16;

import java.util.Random;

public class FKS {
    private static int getMaxIndex(int[] w, int[] v) {
        int maxI = 0;
        float max = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i]!= 0 && ( v[i]/w[i] > max ) ) {
                max = v[i] / w[i];
                maxI = i;
            }
        }
        return maxI;
    }
    private static float getOptimalValue(int cpty, int[] v, int[] w) {
        float value = 0;
        for (int i = 0; i < w.length; i++) {
            if (cpty == 0)
                return value;
            int index = getMaxIndex(w, v);
            int a = Math.min(cpty, w[index]);
            value += a *v[index] / w[index];
            w[index] -= a;
            cpty -= a;
        }
        return value;
    }
    public static void main(String args[]) {
        Random rand = new Random();
        int n = 4;
        int cpty = 20;
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = rand.nextInt(100);
            w[i] = rand.nextInt(10);
            System.out.println(w[i]+" "+v[i]);
        }
        System.out.println(getOptimalValue(cpty, v, w));
    }
}