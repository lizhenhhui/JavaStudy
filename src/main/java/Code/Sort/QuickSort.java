package Code.Sort;

//快速排序
public class QuickSort {
    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIdx = partition(arr, left, right);
            sort(arr, 0, pivotIdx - 1);
            sort(arr, pivotIdx + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int idx = left + 1;
        for (int i = idx; i <= right; i++) {
            if (arr[left] > arr[i]) {
                swap(arr, i, idx++);
            }
        }
        swap(arr, left, idx - 1);
        return idx - 1;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
