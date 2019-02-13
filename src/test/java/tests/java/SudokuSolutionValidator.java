package tests.java;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class SudokuSolutionValidator {
    @Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int[][] sudoku1 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int[][] sudoku2 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2, 9},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertEquals(true, SudokuValidator(sudoku));
        //assertEquals(false, SudokuValidator(sudoku1));
        //assertEquals(false, SudokuValidator(sudoku2));
    }

    private boolean SudokuValidator(int[][] sudoku) {
        ArrayList<int[]> tempList = new ArrayList<>();

        if (sudoku.length != 9){
            return false;
        }

        // Change into ArrayList
        for (int[] temp : sudoku){
            // Sudoku must have 9 columns
            if (temp.length !=9){
                return false;
            }
            tempList.add(temp);
        }

        // Add column array
        for (int i=0; i< sudoku.length; i++){
            int[] temp = new int[sudoku.length];
            for (int j=0; j< sudoku.length; j++){
                // If any value of array equal 0 then it is not valid
                if(sudoku[j][i] == 0){
                    return false;
                }
                temp[j] = sudoku[j][i];
            }
            tempList.add(temp);
        }

        // Validate
        for (int[] temp : tempList){
            Set<Integer> mySet = Arrays.stream(temp).boxed().collect(Collectors.toSet());
            if (mySet.size() != temp.length){
                return false;
            }
        }

        // Print the tempList
        for (int[] temp : tempList){
            for (int i : temp){
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

        return true;
    }
}

