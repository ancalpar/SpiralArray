import java.util.Arrays;

public class SpiralArray {
    public static void main(String[] args) {
        // Example
        int[][] array = {
                {  1,  2,  3,  4,  5},
                { 14, 15, 16, 17,  6},
                { 13, 20, 19, 18,  7},
                { 12, 11, 10,  9,  8}
        };
        System.out.println(Arrays.toString(spiralArray(array)));
    }

    public static int[] spiralArray(int[][] array) {
        int[] newArray = new int[array.length*array[0].length];

        // Each variable defines the constant value of the direction.
        int right = 0;
        int down = array[0].length-1;
        int left = array.length-1;
        int up = 0;

        // The index variable defines the index of the element to be placed.
        int index = 0;

        // After each element is assigned to the array, the index value is incremented by one.
        // When the last element is assigned, the index number is equal to the length of the array, so the loop ends.
        while(true){
            // Going Right                                    //
            for (int i = up; i < down; i++, index++) {        //
                newArray[index] = array[right][i];            //   ------------>
            }                                                 //
            if (index == newArray.length) break;              //

            // Going down                                     //        |
            for (int i = right; i < left; i++, index++) {     //        |
                newArray[index] = array[i][down];             //        |
            }                                                 //        |
            if (index == newArray.length) break;              //        V

            // Going left                                     //
            for (int i = down; i > up; i--, index++) {        //
                newArray[index] = array[left][i];             //   <------------
            }                                                 //
            if (index == newArray.length) break;              //

            // Going up                                       //        ∧
            for (int i = left; i > right; i--, index++) {     //        |
                newArray[index] = array[i][up];               //        |
            }                                                 //        |
            if (index == newArray.length) break;              //        |

            right++; down--; left--; up++;
        }
        return newArray;
    }
}
