package quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class QuickSort implements Callable<List<Integer>> {
   private List<Integer> list;

    QuickSort(List<Integer> list){
        this.list = list;
    }

    void sort(List<Integer> list,int start, int end){
        if(start < end)
        {
            int pi = partition(list,start,end);

            sort(list,start,pi-1);
            sort(list,pi+1,end);
        }
    }

    private int partition(List<Integer> list, int start, int end) {
        int pivot = list.get(end);

        // pointer for greater element
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (list.get(j) <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list,i+1,end);

        return i+1;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(this.list.size() == 0)
        {
            return new ArrayList<>();
        }

        sort(this.list,0,this.list.size()-1);
        return this.list;
    }
}
