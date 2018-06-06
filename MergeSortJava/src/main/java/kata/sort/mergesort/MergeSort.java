package kata.sort.mergesort;

import java.util.ArrayList;
import java.util.List;

class MergeSort {

    List<Integer> sort(List<Integer> list) {

        if (list.size() > 1) {
            List<Integer> sorted = new ArrayList<Integer>();

            List<Integer> left = new ArrayList<Integer>(sort(list.subList(0, list.size() / 2)));
            List<Integer> right = new ArrayList<Integer>(sort(list.subList(list.size() / 2, list.size())));

            while (left.size() > 0 && right.size() > 0) {
                if (left.get(0) < right.get(0)) {
                    sorted.add(left.get(0));
                    left.remove(0);
                } else {
                    sorted.add(right.get(0));
                    right.remove(0);
                }
            }

            if (left.size() > 0) sorted.addAll(left);
            if (right.size() > 0) sorted.addAll(right);

            return sorted;
        } else {
            return list;
        }
  }

}
