import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AllUniquePermutations {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{ 1, 1, 2}));
		System.out.println(permute(A));
	}
	
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		Set<ArrayList<Integer>> solutionIndexSet = new HashSet<>();
		backtracking(new ArrayList<Integer>(), A, solutionIndexSet);
		Set<ArrayList<Integer>> solutionSet = new HashSet<>();
		
		solutionSet = solutionIndexSet
				.stream()
				.map((indexList) -> indexListToNumberList(indexList, A))
				.collect(Collectors.toSet());		
		return new ArrayList<ArrayList<Integer>>(solutionSet);
    }
	
	public static ArrayList<Integer> indexListToNumberList(ArrayList<Integer> indexList, ArrayList<Integer> input) {
		ArrayList<Integer> numberList = new ArrayList<>();
		for(Integer i : indexList) {
			numberList.add(input.get(i));
		}
		return numberList;
	}
	
	public static void backtracking(ArrayList<Integer> current, ArrayList<Integer> input, Set<ArrayList<Integer>> solutionSet) {
		if(isSolution(current, input)) {
			solutionSet.add(current);
			return;
		}
		for(ArrayList<Integer> next : nextStates(current, input)) {
			backtracking(next, input, solutionSet);
		}
	}
	
	public static Set<ArrayList<Integer>> nextStates(ArrayList<Integer> current, ArrayList<Integer> input) {
		Set<ArrayList<Integer>> nextStates = new HashSet<>();
		for(Integer candidate : candidates(current, input)) {
			ArrayList<Integer> next = new ArrayList<>(current);
			next.add(candidate);
			nextStates.add(next);
		}
		return nextStates;
	}
	
	public static ArrayList<Integer> candidates(ArrayList<Integer> current, ArrayList<Integer> input) {
		ArrayList<Integer> candidates = new ArrayList<>();
		for(int i = 0; i < input.size(); i++) {
			if(!current.contains(i)) {
				candidates.add(i);
			}
		}
		return candidates;
	}
	
	public static boolean isSolution(ArrayList<Integer> current, ArrayList<Integer> input) {
		return current.size() == input.size();
	}

}
