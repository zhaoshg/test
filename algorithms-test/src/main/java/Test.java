import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 6, 6, 8, 12, 12, 43, 23, 23, 122, 65, 78, 90, 54};
        Arrays.sort(arr);
        checkDuplicate(arr);

    }

    public static void checkDuplicate(int[] arr) {
        int index = 0;
        while (index < arr.length - 1) {
            if (arr[index] != arr[index + 1]) {
                System.out.print(arr[index++]+",");
            } else {
                index++;
            }
        }
    }

}