import java.util.Scanner;

public class TicTacToe {
	public static char turn = 'X';
	public static int row,col;
	public static Scanner scan = new Scanner(System.in);
	public static char[][] board;
	
	public static void main(String[] args){
		Welcome welcome = new Welcome();
		
		board = new char[3][3];
		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				board[i][j]= '_';
			}
		}
		Play();
	}
	
	public static void Play(){
		boolean playing = true;
		
		//print initial empty board
		System.out.println("Player " + turn + "'s move");
		PrintBoard();
		
		while(playing){
			
			System.out.println("Enter Row [1-3]:  ");
			row = scan.nextInt() - 1;
			System.out.println("Enter Column [1-3]: ");
			col = scan.nextInt() - 1;
			
			if(board[row][col] == '_'){
		
				board[row][col] = turn;
				
				//swtich player
				if(turn == 'X')
					turn = 'O';
				else
					turn = 'X';
				
				System.out.println("Player " + turn + "'s move");
				//declare winner
				if(GameOver(row,col)){
					playing = false;
					System.out.println();
					System.out.println("Game Over! Player " + turn + " wins!");
				}
				
			} else {
				
				System.out.println("Invlid move.");
				System.out.println("Player " + turn + "'s move");
			}
			
			//print current board
			PrintBoard();
			
			
		}
	}
	
	public static void PrintBoard(){
		for(int i = 0 ; i < 3 ; i++){
			System.out.println();
			for(int j = 0 ; j < 3 ; j++){
				if (j == 0) System.out.print("| ");
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}
	
	public static boolean GameOver(int rMove, int cMove){
		//check perpendicular
			if(board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove])
				return true;
			if(board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2])
				return true;
		//check diagonal
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1]!= '_')
				return true;
			if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1]!= '_')
				return true;
		return false;
	}
}
	
