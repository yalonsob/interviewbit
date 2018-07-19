import java.util.*;

public class NumRange {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{ 10, 5, 1, 0, 2}));
		int B = 6;
		int C = 8;
		System.out.println(numRange(A, B, C));
	}
	
	public static int numRange(ArrayList<Integer> A, int B, int C) {
		int count = 0;
		for(int begin = 0; begin < A.size(); begin++) {
			int currentSum = 0;
			for(int end = begin; end < A.size(); end++) {
				currentSum += A.get(end);
				if(B <= currentSum && currentSum <= C) 
					count++;
				if(currentSum > C)
					break;
			}
		}
		return count;
    }
}
