class Solution {
    public double separateSquares(int[][] sq) {
        double lo = 1e18, hi = -1e18;
        double tot = 0;

        for (int[] s : sq) {
            double y = s[1], l = s[2];
            lo = Math.min(lo, y);
            hi = Math.max(hi, y + l);
            tot += (double) l * l;
        }

        double half = tot / 2.0;

        for (int i = 0; i < 60; i++) {
            double mid = (lo + hi) / 2.0;
            double b = 0;

            for (int[] s : sq) {
                double y = s[1], l = s[2];
                double h = Math.min(Math.max(mid - y, 0), l);
                b += h * l;
            }

            if (b < half) lo = mid;
            else hi = mid;
        }

        return lo;
    }
}
