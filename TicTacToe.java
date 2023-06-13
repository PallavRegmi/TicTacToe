import java.util.Scanner;
public class TicTacToe {

    private int row;
    private int column;
    private int trackTheGame = 0;

    Scanner sc = new Scanner(System.in);

    enum CellState {
        X,
        O,
        EMPTY
    }

    enum GameState {
        WIN,
        DRAW,
        CONTINUE,
    }


    private CellState[][] board = new CellState[3][3];

    public void printBoard() {
        System.out.println("______________________");
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                System.out.printf("| "+"%5s", board[r][c] + " ");
            }
            System.out.println("|");
            System.out.println("----------------------");
        }
    }
    public void setValueInBoardX(){
        board[row][column] = CellState.X;
    }
    public void setValueInBoardO(){
        board[row][column] = CellState.O;
    }
    public void setValue(int row, int column){
        this.row = row-1;
        this.column = column-1;
    }

    public boolean validMove() {
        //
        if (row > 2 || column > 2) {
            return false;
        } else if (row < 0 || column < 0) {
            return false;
        } else {
            if (board[row][column] == null) {
                return true;
            } else
                return false;
            }
        }

    public GameState gameStatus() {
        int row = 0;
        int column = 0;

        if (board[row][column] == board[row][column + 1] && board[row][column] == board[row][column + 2] && board[row][column] != null) {
            return GameState.WIN;
        } else if (board[row+1][column] == board[row+1][column + 1] && board[row+1][column] == board[row][column + 2] && board[row+1][column] !=null) {
            return GameState.WIN;
        }else if (board[row+2][column] == board[row+2][column + 1] && board[row+2][column] == board[row+2][column + 2] && board[row+2][column] != null) {
            return GameState.WIN;
        }else if (board[row][column] == board[row+1][column] && board[row][column] == board[row+2][column] && board[row][column] != null ) {
            return GameState.WIN;
        }else if (board[row][column+1] == board[row+1][column+1] && board[row][column+1] == board[row+2][column+1] && board[row][column+1] !=null) {
            return GameState.WIN;
        }else if (board[row][column+2] == board[row+1][column+2] && board[row][column+2] == board[row+2][column+2] && board[row][column+2] !=null) {
            return GameState.WIN;
        }else if (board[row][column] == board[row+1][column+1] && board[row][column] == board[row+2][column+2] && board[row][column] != null) {
            return GameState.WIN;
        }else if (board[row][column+2] == board[row+1][column+1] && board[row][column+2] == board[row+2][column] && board[row][column+2] != null) {
            return GameState.WIN;
        }else{
            for(int i = 0 ; i< board.length ; i++){
                for(int j = 0 ; j<board.length ; j++){
                    if(board[i][j] == null){
                        return GameState.CONTINUE;
                    }
                }
            }
        }
        if (board[0][0]!=null && board[0][1]!=null && board[0][2]!=null && board[1][0]!=null && board[1][1]!=null && board[1][2]!=null && board[2][0]!=null && board[2][1]!=null && board[2][2]!=null){
            return GameState.DRAW;
        }
        return GameState.CONTINUE;
        }
        public void play() {
            while (gameStatus()==GameState.CONTINUE) {
                printBoard();
                System.out.println("Player X's turn.");
                System.out.print("Player X: Enter row (1, 2, or 3): ");
                int row = sc.nextInt();
                System.out.print("Player X : Enter column (1 ,2, or 3): ");
                int column = sc.nextInt();
                setValue(row, column);
                while (!validMove()) {
                    System.out.println("Please enter valid move.");
                    System.out.print("Player X: Enter row (1, 2, or 3): ");
                    row = sc.nextInt();
                    System.out.print("Player X : Enter column (1 ,2, or 3): ");
                    column = sc.nextInt();
                    setValue(row, column);
                }
                setValueInBoardX();
                if(gameStatus()==GameState.WIN || gameStatus() == GameState.DRAW){
                    trackTheGame =1;
                    break;
                }
                printBoard();
                System.out.println("Player O's turn.");
                System.out.print("Player O: Enter row (1, 2, or 3): ");
                row = sc.nextInt();
                System.out.print("Player O : Enter column (1 ,2, or 3): ");
                column = sc.nextInt();
                setValue(row, column);
                while (!validMove()) {
                    System.out.println("Please enter valid move.");
                    System.out.print("Player O: Enter row (1, 2, or 3): ");
                    row = sc.nextInt();
                    System.out.print("Player O : Enter column (1 ,2, or 3): ");
                    column = sc.nextInt();
                    setValue(row, column);
                }
                setValueInBoardO();
                if(gameStatus()==GameState.WIN || gameStatus()==GameState.DRAW){
                    trackTheGame =2;
                    break;
                }
            }
            if(gameStatus()==GameState.DRAW){
                printBoard();
                System.out.println("Draw");
            }
            else if(gameStatus()==GameState.WIN){
                if(trackTheGame==1){
                    printBoard();
                    System.out.println("Player X WINS");
                }
                else if(trackTheGame==2) {
                    printBoard();
                    System.out.println("Player O WINS");
                }
            }
        }
}


