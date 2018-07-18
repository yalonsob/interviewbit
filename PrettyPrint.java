import java.util.ArrayList;

public class PrettyPrint {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> solution = prettyPrint(4);
		System.out.println(solution);
	}
	
	public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        
        int len = A * 2 - 1;
        int[][] matrix = new int[len][len];
        
        if(matrix.length == 0) return solution;
        
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            //Right
            for(int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = A;
            }
            rowBegin++;
            
            //Down
            for(int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = A;
            }
            colEnd--;
            
            //Left
            for(int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = A;
            }
            rowEnd--;
            
            //Up
            if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = A;
                }    
            }
            colBegin++;
            A--;    
        }
        
        for(int[] row : matrix) {
        		ArrayList<Integer> rowList = new ArrayList<>();
        		for(int i : row) {
        			rowList.add(i);
        		}
        		solution.add(rowList);
        } 
        return solution;
    }
}
