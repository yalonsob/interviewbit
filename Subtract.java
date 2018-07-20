
public class Subtract {

	public static void main(String[] args) {
		ListNode A = new ListNode(1);
		ListNode B = new ListNode(2);
		ListNode C = new ListNode(3);
		ListNode D = new ListNode(4);
		ListNode E = new ListNode(5);
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		ListNode result = subtract(A);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
			
		}
	}
	
	public static ListNode subtract(ListNode A) {
		int len = getListLength(A);
		int half = len / 2;
		ListNode currentNode = A;
		ListNode halfNode = getNode(A, half);
		
		halfNode.next = reverse(halfNode.next);
		ListNode subtractNode = halfNode.next;
		
		for(int i = 1; i <= half; i++) {
			
			currentNode.val = subtractNode.val - currentNode.val;
			currentNode = currentNode.next;
			subtractNode = subtractNode.next;
		}
		
		halfNode.next = reverse(halfNode.next);
		
		return A;
	}
	
	public static ListNode reverse(ListNode A) {
		if(A == null || A.next == null) {
			return A;
		}
		
		ListNode prev = null;
		ListNode current = A;
		ListNode next = A.next;
		
		while(next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}
		current.next = prev;
		A = current;
		
		return A;
	}
		
	public static int getListLength(ListNode A) {
		int len = 0;
		while(A != null) {
			len++;
			A = A.next;
		}
		return len;
	}
	
	public static ListNode getNode(ListNode head, int position) {
		ListNode currentNode = head;
		for(int i = 1; i < position; i++) {
			if(currentNode.next != null) {
				currentNode = currentNode.next;
			} else {
				return null;
			}
		}
		return currentNode;	
	}
	
//	n^2
//	public static ListNode subtract(ListNode A) {
//		int last = getListLength(A);
//		int half = last / 2;
//		ListNode currentNode = A;
//		
//		for(int i = 1; i <= half; i++) {
//			currentNode.val = getNode(A, last).val - currentNode.val;
//			currentNode = currentNode.next;
//			last--;
//		}
//		return A;
//	}
//

}

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}
