class Solution {
    public int totalFruit(int[] fruits) {

        int start = 0;
        int len =1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {

            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);

                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }

            len = Math.max(len, i - start + 1);
        }

        return len;
    }
}
