package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
		int width = model.getWidth();
        
		System.out.print("\n\n");
		System.out.print("  ");
		for (int i = 0; i < width; i++){
			
			System.out.print(i);
		}
		
        System.out.print("\n\n");
		
		for (int row = 0; row < width; row++){
			
			System.out.print(row + " ");
			
			for (int col = 0; col < width; col++){
			
				System.out.print(model.getMark(row,col));
				
			}
			
			System.out.print("\n");
		}
		
		System.out.print("\n\n");

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        System.out.print("Enter the row and column numbers, separated by a space: ");

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.err.print("The Row and Column ENTERED is Invalid!");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}