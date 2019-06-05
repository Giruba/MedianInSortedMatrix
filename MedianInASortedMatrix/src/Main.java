import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Median in a row-wise sorted matrix");
		System.out.println("----------------------------------");
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of rows in the matrix");
			int rows = scanner.nextInt();
			System.out.println("Enter the number of columns in the matrix");
			int cols = scanner.nextInt();
			int[][] matrix = new int[rows][cols];
			for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
				for(int colIndex = 0; colIndex < cols; colIndex++) {
					System.out.println("Enter the element");
					matrix[rowIndex][colIndex] = scanner.nextInt();
				}
			}
			System.out.println("-----Printing the original matrix-----");
			PrintMatrix(matrix);
			System.out.println("Median in this matirx is "+GetMedianInMatrix(matrix));
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
	
	public static int GetMedianInMatrix(int[][] matrix) {
		int median = 0;
		int[] matrixArray = new int[matrix.length * matrix[0].length];

		int matrixArrayIndex = 0;
		for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for(int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				matrixArray[matrixArrayIndex++] = matrix[rowIndex][colIndex];
			}
		}
		Arrays.sort(matrixArray);
		int matrixArrayLength = matrixArray.length;
		if(matrixArrayLength%2 == 0) {
			median = matrixArray[matrixArrayLength/2] + matrixArray[matrixArrayLength/2 - 1];  
			median = median/2;
		}else {
			median = matrixArray[matrixArrayLength/2];
		}
		
		return median;
	}
	
	public static void PrintMatrix(int[][] matrix) {
		for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
			for(int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
				System.out.print(matrix[rowIndex][colIndex]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
