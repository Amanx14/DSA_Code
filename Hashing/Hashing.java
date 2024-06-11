public class Hashing {
    //---------------------HASHING-------------------------//
    
    // JAB SIRF LOWER CASE LETTERS HO
    public static int freqCount(String str, char letter) {
        int freq[] = new int[26]; //hash array

        for(int i=0; i<str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        return freq[letter - 'a'];
    }

    // JAB UPERCASE LOWER CASE SAB HO
    public static int freqCount2(String str, char letter) {
        int freq[] = new int[256]; // hash array

        for(int i=0; i<str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        return freq[letter];
    }
   
    public static void main(String args[]) {

        String str = "Ababad";
        char query = 'A';

        System.out.print(freqCount2(str, query));
    }
}