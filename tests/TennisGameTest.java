import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"   DONE
// "15 - 15" DONE
// "30 - 30" DONE
// "deuce" DONE
// "15 - love", "love - 15" DONE
// "30 - love", "love - 30" DONE
// "40 - love", "love - 40" DONE
// "30 - 15", "15 - 30" DONE
// "40 - 15", "15 - 40" DONE
// "player1 has advantage" DONE
// "player2 has advantage" DONE
// "player1 wins" DONE
// "player2 wins" DONE
	
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_Player1WinsPoint_15_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 15_0", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsPoint_30_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 30_0", "30 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsPoint_40_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 40_0", "40 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1WinsGame() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect message when Player1 wins", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsPoint_0_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 0_15", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsPoint_0_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 0_30", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_Player2WinsPoint_0_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 0_40", "love - 40", score);
	}
	

	@Test
	public void testTennisGame_Player2WinsGame() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect message when Player2 wins", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_EachPlayerWin1Points_15_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 15-15", "15 - 15", score);
	}
	
	@Test
	public void testTennisGame_EachPlayerWin2Points_30_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 30-30", "30 - 30", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins2Points_Player2Wins1points_30_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 30-15", "30 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins1Points_Player2Wins2points_15_30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 15-30", "15 - 30", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins3Points_Player2Wins1points_40_15() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 40-15", "40 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1Wins1Points_Player2Wins3points_15_40() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Incorrect score in situation 15-40", "15 - 40", score);
	}
	
	@Test
	public void testTennisGame_EahcPlayerWins4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	//ADVANTAGET
	
	@Test
	public void testTennisGame_Player1WinsAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player1 advantage situation incorrect", "player1 has advantage", score);		
	}
	
	@Test
	public void testTennisGame_Player2WinsAdvantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Player2 advantage situation incorrect", "player2 has advantage", score);		
	}
	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}		
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}		
}
