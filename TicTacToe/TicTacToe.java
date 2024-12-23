package TicTacToe;

import java.util.*;

public class TicTacToe 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);  
        char player = 'X';
        char[][] board = new char[3][3];
        boolean gameOver = false;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = ' ';
            }
        }

        while(!gameOver)
        {
            displayboard(board);
            System.out.println("Player "+player+" enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            
            if(board[row][col] == ' ')
            {
                board[row][col] = player;
                gameOver = haveWon(board, player) && isEmpty(board);
                if(gameOver)
                {
                    System.out.println("Player "+player+ " has won!!");
                }
                else
                {
                    if(player == 'X')
                    {
                        player = 'O';
                    }
                    else
                    player = 'X';
                }
            }
            else
            {
                System.out.println("Invalid move. Try again");
            }
        }
        displayboard(board);
    }    

    private static boolean isEmpty(char[][] board)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(board[i][j] == ' ')
                return true;
            }
        }
        return false;
    }

    private static boolean haveWon(char[][] board,char player) 
    {
        for(int row=0; row<3; row++)
        {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
            {
                return true;
            }
        }
        
        for(int col=0; col<3; col++)
        {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
            {
                return true;
            }
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
            {
                return true;
            }

            if(board[2][0]==player && board[1][1]==player && board[0][2]==player)
            {
                return true;
            }
            return false;
    }

    public static void displayboard(char[][] board)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                System.out.print(board[i][j]+ "_ |");
            }
            System.out.println();
        }
    }
}
