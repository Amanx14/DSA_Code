import java.util.*;

public class MergeIntervals {
    public static List<List<Integer>> overlappingSubintervals(int arr[][]) {
        int n = arr.length;

        // Comparing 2d arrays
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if(!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            } 
            for(int j=i+1; j<n; j++) {
                if(arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
                else {
                    break; 
                }
            }
            ans.add(Arrays.asList(start, end)); 
        }

        return ans;
    }
    public static int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length; 

        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i[] : intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                result.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
    public static void main(String args[]) {
        int arr[][] = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};

        List<List<Integer>> ans = overlappingSubintervals(arr);

        int result[][] = mergeIntervals(arr);

        for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
} 