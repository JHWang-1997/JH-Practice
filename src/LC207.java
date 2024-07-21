import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *@author JH-Wang
 *@since 2024/7/21 23:39
 */
public class LC207 {

    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        Solution207 solution207 = new Solution207();
        boolean b = solution207.canFinish(5, arr);
        System.out.println(b);
    }
}

class Solution207 {
    List<List<Integer>> list;

    boolean[] okCources;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list = new ArrayList<>(numCourses);
        okCources = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (final int[] prerequisite : prerequisites) {
            list.get(prerequisite[0]).add(prerequisite[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (dsf(i, set)) {
                return false;
            }
            okCources[i] = true;
        }
        return true;
    }

    private boolean dsf(int val, Set<Integer> set) {
        if (set.contains(val)) {
            return true;
        }
        if (okCources[val]) {
            return false;
        }
        set.add(val);
        for (Integer idx : list.get(val)) {
            if (dsf(idx, set)) {
                set.remove(val);
                return true;
            }
        }
        set.remove(val);
        return false;
    }
}