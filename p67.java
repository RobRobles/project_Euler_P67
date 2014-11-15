import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class p67 {

	public static void main(String[] args) throws FileNotFoundException {

		//This is for problem 67
		File file = new File("triangle.txt");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(file);

		//fixed rows of input file
		int r = 100; 
		//fixed columns of input file
		int c = 100; 

		//2D arrayList for keeping track of the triangle 
		int[][] triangle = new int[r][c];

		int row = 0, col = 0; 
		//A temp line for line splits
		String tempLine; 

		//while we are still able to read in the next line of the text file. Make sure you imported the right one. 
		while(input.hasNextLine())
		{
			//read the next line
			tempLine = input.nextLine(); 
			//split the lines at the spaces that are found
			String [] nums = tempLine.split(" "); 

			//go throught the entire list and add them to the 2D array
			for(int i = 0; i < nums.length; i++)
			{
				triangle[row][col] = Integer.parseInt(nums[i]);
				col += 1; 
			}
			col = 0; 
			row += 1; 
		}

		//making sure our triangle is at the right length
		//System.out.println("I should be 100: " + triangle.length);

		//initializing s to 2 less than the length of triangle (13) and working our way back
		for(int s = triangle.length - 2; s >=0; s--)
		{
			//initialzing j to 0 and making it less than the length of trinagle at s as it progresses. 
			for (int j = 0 ; j < triangle[s].length; j++) 
			{
				//checking bounds, and getting max path
				if (j != triangle[s].length-1) {
					triangle[s][j] += Math.max(triangle[s + 1][j], triangle[s + 1][j + 1]); 
				} else {
					//adding the other node/number
					triangle[s][j] += triangle[s+1][j];
				}
			}
		}
		System.out.println(Integer.toString(triangle[0][0])) ;

	}
}

