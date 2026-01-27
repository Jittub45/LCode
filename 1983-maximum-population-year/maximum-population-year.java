class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> event = new ArrayList<>();

        for(int[] log : logs){
            event.add(new int[]{log[0], 1});
            event.add(new int[]{log[1], -1});
        }
        Collections.sort(event, (a, b) ->{
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int curPop = 0;
        int maxPop = 0;
        int minYear = 2050;

        for(int[] eve: event){
            curPop += eve[1];
            if(curPop > maxPop){
                maxPop = curPop;
                minYear = eve[0];
            }
        }
        return minYear;
    }
}