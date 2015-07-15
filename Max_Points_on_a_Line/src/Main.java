import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Solution {
   public int maxPoints(Point[] points) {
       Map<Integer, Integer> verticalCount = new HashMap<>();
       Map<Float, Map<Float, Set<Integer>>> slopeToInterceptMap = new HashMap<>();
       int retValue = 0, i, j;
       Float slope, intercept;
       Point a, b;
       for (Point pt: points)
           if (verticalCount.containsKey(pt.x))
               verticalCount.put(pt.x, verticalCount.get(pt.x) + 1);
           else
               verticalCount.put(pt.x, 1);
       for (i = 0; i < points.length; i++) {
           for (j = i + 1; j < points.length; j++) {
               a = points[i];
               b = points[j];
               if (a.x == b.x)
                   continue;
               slope = ((float)(a.y - b.y)) / (a.x - b.x);
               intercept = a.y - slope * a.x;
               if (!slopeToInterceptMap.containsKey(slope))
                   slopeToInterceptMap.put(slope, new HashMap<Float, Set<Integer>>());
               if (!slopeToInterceptMap.get(slope).containsKey(intercept))
                   slopeToInterceptMap.get(slope).put(intercept, new HashSet<Integer>());
               slopeToInterceptMap.get(slope).get(intercept).add(i);
               slopeToInterceptMap.get(slope).get(intercept).add(j);
           }
       }
       for (int k: verticalCount.values())
           retValue = retValue < k ? k : retValue;
       for (Map<Float, Set<Integer>> slopeToMap: slopeToInterceptMap.values()) {
           for (Set<Integer> s: slopeToMap.values()) {
               retValue = retValue < s.size() ? s.size() : retValue;
           }
       }
       for (Float s: slopeToInterceptMap.keySet()) {
           System.out.println("Slope");System.out.println(s);
           for (Float x: slopeToInterceptMap.get(s).keySet()) {
               System.out.println(x);
               System.out.println(slopeToInterceptMap.get(s).get(x));
           }
       }
       return retValue;
   }
}

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] raw = {{560,248},{0,16},{30,250},{950,187},{630,277},{950,187},{-212,-268},{-287,-222},{53,37},{-280,-100},{-1,-14},{-5,4},{-35,-387},{-95,11},{-70,-13},{-700,-274},{-95,11},{-2,-33},{3,62},{-4,-47},{106,98},{-7,-65},{-8,-71},{-8,-147},{5,5},{-5,-90},{-420,-158},{-420,-158},{-350,-129},{-475,-53},{-4,-47},{-380,-37},{0,-24},{35,299},{-8,-71},{-2,-6},{8,25},{6,13},{-106,-146},{53,37},{-7,-128},{-5,-1},{-318,-390},{-15,-191},{-665,-85},{318,342},{7,138},{-570,-69},{-9,-4},{0,-9},{1,-7},{-51,23},{4,1},{-7,5},{-280,-100},{700,306},{0,-23},{-7,-4},{-246,-184},{350,161},{-424,-512},{35,299},{0,-24},{-140,-42},{-760,-101},{-9,-9},{140,74},{-285,-21},{-350,-129},{-6,9},{-630,-245},{700,306},{1,-17},{0,16},{-70,-13},{1,24},{-328,-260},{-34,26},{7,-5},{-371,-451},{-570,-69},{0,27},{-7,-65},{-9,-166},{-475,-53},{-68,20},{210,103},{700,306},{7,-6},{-3,-52},{-106,-146},{560,248},{10,6},{6,119},{0,2},{-41,6},{7,19},{30,250}};
        Point[] points = new Point[raw.length];
        for(int i = 0; i < raw.length; i++) {
            points[i] = new Point(raw[i][0], raw[i][1]);
        }
        Solution solution = new Solution();
        for(int[] coord: raw) {
            if ((float)coord[1] == (float)(coord[0]) * (-2.525) - 228.875)
                System.out.println(Arrays.toString(coord));
        }
        System.out.println(solution.maxPoints(points));
    }

}
