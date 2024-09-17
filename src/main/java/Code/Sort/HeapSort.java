package Code.Sort;

//堆排序
public class HeapSort {
        public static void heapSort(int[] arr){
        int n = arr.length;
        // 构建大根堆，从最后一个非叶子开始向上调整：n / 2 - 1
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for(int i = n - 1; i > 0; i--){
            // 开始堆排序，每次取出堆顶数据，调整堆
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int lagest = i, l = 2 * i + 1, r = 2 * i + 2;
        // 从左右子树找更大的哪个数交换
        if(l < n && arr[l] > arr[lagest]){
            lagest = l;
        }
        if(r < n && arr[r] > arr[lagest]){
            lagest = r;
        }
        if(lagest != i){
            // 左右子树有更大的 交换
            int tmp = arr[i];
            arr[i] = arr[lagest];
            arr[lagest] = tmp;
            // 更小的数下沉到子树后，还需要继续调整子树
            heapify(arr, n, lagest);
        }
    }
}
