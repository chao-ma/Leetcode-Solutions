import java.util.*;

class Solution {
    
    int LEFT = 0;
    int RIGHT = 1;
    int HEIGHT = 2;
    private List<int[]> pts = new ArrayList<>();
    
    public static class BuildingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return -Integer.compare(o1[2], o2[2]);
        }
    }
    
    private void cleanHeap(PriorityQueue<int[]> heap, int x) {
        while (!heap.isEmpty() && x >= heap.peek()[RIGHT]) {
            int[] last = heap.remove();
            while (!heap.isEmpty() && heap.peek()[RIGHT] <= last[RIGHT])
                heap.remove();
            if (heap.isEmpty())
                addPoint(last[RIGHT], 0);
            else
                addPoint(last[RIGHT], heap.peek()[HEIGHT]);
        }        
    }
    
    private void addPoint(int x, int y) {
        if (pts.size() == 0)
            pts.add(new int[] {x, y});
        else {
            if (y == pts.get(pts.size() - 1)[1])
                return;
            if (x == pts.get(pts.size() - 1)[0] && y > pts.get(pts.size() - 1)[1]) {
                pts.remove(pts.size() - 1);
                addPoint(x, y);
            }
            else
                pts.add(new int[] {x, y});
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Math.max(buildings.length, 16), new BuildingComparator());
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            cleanHeap(heap, building[LEFT]);
            if (heap.isEmpty() || heap.peek()[HEIGHT] < building[HEIGHT])
                addPoint(building[LEFT], building[HEIGHT]);
            heap.add(building);
        }
        cleanHeap(heap, Integer.MAX_VALUE);
        return pts;
    }
}

public class Main {

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {2, 9, 11}, {3, 7, 15}, {5, 12, 12}, {12,15,1}, {15, 20, 10}, {19, 24, 8}};
        Solution solution = new Solution();
        List<int[]> res = solution.getSkyline(buildings);
        for (int[] pt: res)
            System.out.println(Arrays.toString(pt));
    }

}
