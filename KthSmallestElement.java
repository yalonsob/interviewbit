import java.util.*;

public class KthSmallestElement {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>(Arrays.asList(new Integer[]{ 2, 1, 4, 3, 2}));
		int k = 3;
		System.out.println(kthsmallest(A, k));

	}
	
	public static int kthsmallest(final List<Integer> A, int B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(B, (n1, n2) -> n2.compareTo(n1));
		for(int n : A) {
			if(pq.size() < B) {
				pq.add(n);
			} else {
				int peek = pq.peek();
				if(peek > n) {
					pq.remove(peek);
					pq.add(n);
				}
			}
		}
		return pq.peek();
	}
	
//	n^2 solution:
	
//	public static int kthsmallest(final List<Integer> A, int B) {
//		Set<Integer> indexOfSmallest = new HashSet<>();
//		int smallest = -1;
//		
//		for(int i = 0; i < B; i++) {
//			smallest = findSmallest(A, indexOfSmallest);
//		}
//		
//		return smallest;
//    }
//	
//	public static int findSmallest(final List<Integer> A, Set<Integer> indexOfSmallest) {
//		int smallest = Integer.MAX_VALUE;
//		int index = -1;
//		for(int i = 0; i < A.size(); i++) {
//			if(A.get(i) < smallest && !indexOfSmallest.contains(i)) {
//				smallest = A.get(i);
//				index = i;
//			}
//		}
//		indexOfSmallest.add(index);
//		return smallest;
//	}

}
