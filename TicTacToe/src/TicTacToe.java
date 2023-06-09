
import java.util.Arrays;
import java.util.List;



public class TicTacToe {

    static char prevMark='O';
    static char[][] board;
    
    public List<Thread> threads;
    
    
        
    
    public TicTacToe() {
    
        
    
        newBoard(); // create board filled with blank spaces
    }

    public void setMark(int x, int y, char mark) {
        if(x>2||y>2||(mark!='X'&&mark!='O')) // if coordinates get outside the table or the mark is not X or O throw exception
            throw new IllegalArgumentException();
        if (board[x][y]==' ') { // if given place in the table is blank you can place the mark
            board[x][y] = mark;
            prevMark=mark;
        }
        else
            throw new IllegalArgumentException();
    }

    public char[][] table() {
        return Arrays.stream(board).map(char[]::clone).toArray(char[][]::new);
    }

    public char lastMark() {
        return prevMark;
    }

    static private void newBoard() {
        board= new char[][]{{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
    }

}    

