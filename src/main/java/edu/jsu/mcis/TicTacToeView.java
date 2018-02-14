package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {

    private TicTacToeModel model;
	
	private JButton[][] squares;
	private JPanel squaresPanel;
	private JLabel resultLabel; 
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
		
		int width = model.getWidth();
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		squares = new JButton[width][width];
		JPanel squaresPanel = new JPanel(new GridLayout(width, width)); 
		resultLabel = new JLabel();
		resultLabel.setName("ResultLabel");	
		
		for (int row = 0; row < width; ++row) {
            
            for (int col = 0; col < width; ++col) {
				
				squares[row][col] = new JButton();
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				squares[row][col].setPreferredSize(new Dimension(64, 64));
				squaresPanel.add(squares[row][col]);
        
			}
		}
		
		add(squaresPanel);
		add(resultLabel);

		resultLabel.setText("Let's Play Tic-Tac-Toe!"); 
	}

	@Override
	public void actionPerformed(ActionEvent event){
		String name = ((JButton) event.getSource()).getName();

	int row = (char) name.charAt(6) - 48;
	int col = (char) name.charAt(7) - 48;
	
	model.makeMark(row,col);
	
	setSquare();
	
	showResult(" "); 
	
	if (model.isGameover()){
		showResult(model.getResult().toString().toUpperCase());
		for (int i = 0; i < model.getWidth(); i++){
			for (int j = 0; j < model.getWidth(); j++){
				squares[i][j].setEnabled(false);
			}
		}
		
	}
}

	public void setSquare(){
		
		for (int row = 0; row < model.getWidth(); row++){
			for (int col = 0; col < model.getWidth(); col++){
				squares[row][col].setText(model.getMark(row, col).toString());
			}
		}
	}
	
	public void showResult(String message){
		resultLabel.setText(message);
	}
}	