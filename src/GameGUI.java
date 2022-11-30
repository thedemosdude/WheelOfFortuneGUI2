//import acm.graphics.*;
//import acm.program.*;
//import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI {
	/** Constants for alphabet letter display */
	private static final double LETTER_DISPLAY_X = 8;
	private static final double LETTER_DISPLAY_Y = 485;
	private static final double LETTER_SPACING = 3; 
	
	/** Constants for wedge legend */
	private static final double LEGEND_DIMENSIONS = 20;
	private static final double LEGEND_X_OFFSET = 10;
	private static final double LEGEND_Y_OFFSET = 265;
	private static final double LEGEND_GAP = 5;
	
	/** Constants for the wheel */
	private static final double WHEEL_DIMENSIONS = 200;
	private static final double WHEEL_X_OFFSET = 125;
	private static final double WHEEL_Y_OFFSET = 265;
	
	/** Number of players */
	private static final int NUM_PLAYERS = 3;
	
	/** Number of cash values including Bankrupt */
	private static final double NUM_CASH_TYPES = 6;

	/** Dimensions of game display board */
	private static final double BOARD_WIDTH = 377;
	private static final double BOARD_HEIGHT = 196;
	
	/** Constants for the player boxes */
	private static final double BOX_WIDTH = 101;
	private static final double BOX_HEIGHT = 20;
	private static final double BOX_GAP = 17;	
	private static final double BOX_X_OFFSET = 20;
	private static final double BOX_Y_OFFSET = BOARD_HEIGHT + 10;
	
	/** Constants for the letter boxes that appear on the game board */
	private static final double BLOCK_HEIGHT = 25;
	private static final double BLOCK_WIDTH = 18;
	private static final double BLOCK_GAP = (325 - BLOCK_WIDTH * 14)/ 13;
	private static final double BLOCK_X_OFFSET = 26 + (BLOCK_WIDTH + BLOCK_GAP); //Letters are never displayed in the first block space.
	private static final double BLOCK_Y_OFFSET = 64 - (BLOCK_HEIGHT + BLOCK_GAP);
	
	/* Pause for letter display animation */
	private static final double PAUSE = 15;
	
	/** Cash values of each wedge */
	private static final int CASH_VALUE_ONE = 100;
	private static final int CASH_VALUE_TWO = 200;
	private static final int CASH_VALUE_THREE = 300;
	private static final int CASH_VALUE_FOUR = 400;
	private static final int CASH_VALUE_FIVE = 500;
}
