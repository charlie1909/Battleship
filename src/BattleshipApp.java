import java.util.Random;
import java.util.Scanner;

public class BattleshipApp {


    private int[][] board;
    private int size;
    private int shipCount;

    public BattleshipApp(int size) {
        this.size = size;
        shipCount = 3;
        board = new int[this.size][this.size];
        emptyBoard();
        generateShipPositions();
    }

    private void generateShipPositions() {
        Random random = new Random();
        for(int i = 0; i < shipCount; i++){
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            board[x][y] = 1;
        }
    }

    private void emptyBoard() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j<size; j++){
                board[i][j] = 0;
            }
        }
    }

    private boolean fire(int x, int y){
        if(board[y][x] == 1){
            board[y][x] = 0;
            System.out.println("You sunk a battleship!");
            shipCount--;
            return true;
        }
        System.out.println("Miss!");
        return false;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        displayBoard();
        while(!gameOver()){
            System.out.println("X Coord: ");
            int x = scanner.nextInt();
            System.out.println("Y Coord: ");
            int y = scanner.nextInt();
            fire(x,y);
            displayBoard();
        }
        System.out.println("You won!");
    }

    private void displayBoard() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j<size; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    private boolean gameOver() {
        return shipCount == 0;
    }
}
