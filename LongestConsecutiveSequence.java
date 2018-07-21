import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{ 100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive(A));

	}
	
	public static int longestConsecutive(final List<Integer> A) {
		Map<Integer, Integer> seen = new HashMap<>();
		int max = 0;
        
        for(Integer num : A) {
            if(!seen.containsKey(num)) {
                int left = 0;
                int right = 0;
                
                if(seen.containsKey(num - 1)) {
                    left = seen.get(num - 1);
                }
                if(seen.containsKey(num + 1)) {
                    right = seen.get(num + 1);
                }
                int val = 1 + left + right;
                seen.put(num, val);
                max = Math.max(max, val);
                
                if(left > 0) {
                    seen.put(num - left, val);
                }
                if(right > 0) {
                    seen.put(num + right, val);
                }   
            }
        }
        return max;
    }

}
