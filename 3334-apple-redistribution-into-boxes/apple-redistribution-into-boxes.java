class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        quickSortDesc(capacity, 0, capacity.length - 1);


        int sum = Arrays.stream(apple).sum();

        int i = 0, count = 0;

        while(sum > 0){
            sum -= capacity[i];
            i++; count++;
        }

        return count;
    }
    private void quickSortDesc(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortDesc(arr, low, pivotIndex - 1);
            quickSortDesc(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) { 
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}