import java.util.ArrayList;

public class MoveAllZeros {
    public static void moveZero(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != 0) {
                list.add(arr[i]);
            }
        }

        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }

        for(int i=list.size(); i<arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void moveZeroOptimized(int arr[]) {
        int i=0;
        for(int j=0; j<arr.length; j++) {
            if(arr[j] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,0,2,3,0,4,0,1};
        moveZero(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
