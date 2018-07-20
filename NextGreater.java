import java.util.ArrayList;
import java.util.Arrays;

public class NextGreater {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{ 4, 5, 2, 10}));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(new Integer[]{ 3, 2, 1}));
		
		System.out.println(nextGreater(A));
		System.out.println(nextGreater(B));
	}
	
	public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
		Integer[] solution = new Integer[A.size()];
		
		for(int i = 0; i < A.size() - 1; i++) {
			for(int j = i + 1; j < A.size(); j++) {
				if(A.get(j) > A.get(i)) {
					solution[i] = A.get(j);
					break;
				}
			}
			solution[i] = solution[i] == null ? -1 : solution[i];	
		}
		solution[A.size() - 1] = -1;
		
		return new ArrayList<Integer>(Arrays.asList(solution));
	}
}
