import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader f = new FileReader("adventOfCodeDay3puzzleInput.txt");
        Scanner s = new Scanner(f);
        char[] row = new char[140];
        String line = ("");
        char[] number = new char[3];

        //create a 2D array to read input into
        char[][] array = new char[140][140];

        for(int i = 0; i < 140; i++) {
            line = s.nextLine();
            row = line.toCharArray();
            for(int j = 0; j < 140; j++){
                array[i][j] = row[j];
            }
        }
        //itterating over array to find numbers
        for(int i = 0; i < 140; i++) {
            for(int j = 0; j < 140; j++){
                int moveJ = 0;
                boolean isPart = false;
                //find number
                if(Character.isDigit(array[i][j])){
                    number[0] = array[i][j];
                    if(Character.isDigit(array[i][j+1])){
                        number[1] = array[i][j+1];
                        moveJ++;
                        if(Character.isDigit(array[i][j+2])){
                            number[2] = array[i][j+2];
                            moveJ++;
                        }
                    }
                }
            }
        }


    }

    static boolean checkChar(char c){
        if((c != '.')&&(!(Character.isDigit(c)))){
            return true;
        }
        return false;
    }

    static boolean isPart(char[][] arr, int i, int j){
        boolean iP = false;
        //check top
        if((i - 1) >= 0){
            if((j-1) >=0){
                if(checkChar(arr[i-1][j-1])){
                    return iP;
                }
            }
            if(checkChar(arr[i-1][j])){
                return iP;
            }
            if(j+1 <= 139){
                if(checkChar(arr[i-1][j+1])){
                    return iP;
                }
            }
        }
        //check bottom
        if((i + 1) <= 139){
            //CONTINUE HERE
            if((j-1) >=0){
                if(checkChar(arr[i-1][j-1])){
                    return iP;
                }
            }
            if(checkChar(arr[i-1][j])){
                return iP;
            }
            if(j+1 <= 139){
                if(checkChar(arr[i-1][j+1])){
                    return iP;
                }
            }
        }
        //check left
        //check right
        return iP;
    }
}
