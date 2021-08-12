import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //Create a room
        Room r = new Room();
        String[][] room = r.getRoom();
        String[][] exploredRoom = r.getExploredRoom();
        int finished = -1;

        //Prints the room
        while(finished == -1) {
            printRoom(room, exploredRoom);

            //Get user to explore a cell
            Scanner sc = new Scanner(System.in);
            int rowToSearch = getRow(sc, room);
            int colToSearch = getColumn(sc, room);

            finished = checkArea(rowToSearch, colToSearch, exploredRoom, finished, room);
        }
    }


    /**
     * Prints the layout of the room as its explored so far
     * @param room - The room
     * @param exploredRoom - The room as its been explored so far
     */
    private static void printRoom(String[][]room, String[][]exploredRoom){
        for(int i=0; i<room.length; i++){
            for(int j=0; j<room.length; j++){
                System.out.print(exploredRoom[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Gets the user to enter a row
     * @param sc - Scanner to read input
     * @param room - The room to be explored
     * @return - The row number
     */
    private static int getRow(Scanner sc, String[][]room){
        //Read user input
        System.out.println("Enter Row: ");
        int rowToSearch = sc.nextInt();

        //If out of range ask user to enter again
        while (rowToSearch < 0 || rowToSearch > (room.length - 1)) {
            System.out.print("Invalid Input");
            System.out.println("Enter Row: ");
            rowToSearch = sc.nextInt();
        }
        return rowToSearch;
    }


    /**
     *
     * @param sc - The scanner to read input
     * @param room - The room
     * @return - The column number
     */
    private static int getColumn(Scanner sc, String[][] room){
        System.out.println("Enter Column: ");
        int colToSearch = sc.nextInt();

        //While not in range keep asking user for input
        while (colToSearch < 0 || colToSearch > (room.length - 1)) {
            System.out.print("Invalid Input");
            System.out.println("Enter Col: ");
            colToSearch = sc.nextInt();
        }
        return colToSearch;
    }


    /**
     * Checks the cell to see if user dies, wins or carries on
     * @param rowToSearch - The row to search
     * @param colToSearch - The column to search
     * @param exploredRoom - The explored room so far
     * @param finished - Whether the game has finished or not
     * @param room - The room being explored
     * @return - Weather or not the game is over or not
     */
    private static int checkArea(int rowToSearch, int colToSearch, String[][] exploredRoom, int finished, String[][] room){
        //If T, user wins
        if (room[rowToSearch][colToSearch].equals("T")) {
            System.out.println("YOU WIN");
            finished = 0;
            //If B, user looses
        } else if (room[rowToSearch][colToSearch].equals("B")) {
            System.out.println("Explosion! You LOSE!");
            finished = 0;
        } else {
            //Carry on, found nothing
            exploredRoom[rowToSearch][colToSearch] = "E";
        }
        return finished;
    }


}
