public class MaxConsecutiveOne {
    public static int maxConsecutiveOnes(int arr[]) {
        int count = 0;
        int maxStreak = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                count++;
            } 
            else {
                count = 0;
            }
            if(count > maxStreak) {
                maxStreak = count;
            }
        }
        return maxStreak;
    }
    public static void main(String[] args) {
        
        int arr[] = {1, 0, 1, 1, 0, 1};
        System.out.println(maxConsecutiveOnes(arr));
    }
}
