class Solution {
    public int maximizeSquareArea(int m, int n, int[] h, int[] v) {
        int mod = 1_000_000_007;

        int[] a = new int[h.length + 2];
        a[0] = 1;
        a[a.length - 1] = m;
        for (int i = 0; i < h.length; i++) a[i + 1] = h[i];

        int[] b = new int[v.length + 2];
        b[0] = 1;
        b[b.length - 1] = n;
        for (int i = 0; i < v.length; i++) b[i + 1] = v[i];

        Arrays.sort(a);
        Arrays.sort(b);

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                s.add(a[j] - a[i]);

        int x = -1;
        for (int i = 0; i < b.length; i++)
            for (int j = i + 1; j < b.length; j++) {
                int d = b[j] - b[i];
                if (s.contains(d)) x = Math.max(x, d);
            }

        if (x == -1) return -1;
        return (int)((long)x * x % mod);
    }
}
