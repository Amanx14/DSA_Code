import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TakingInputOnline {
    public static void main(String args[]) throws IOException{
        /* Old ways of taking input (BufferedReader)

        BufferedReader me InputStreamReader ka object dalna padta
        InputStreamReader me System.in dalna padta

        input read karne ke liye BufferedReader ka object ke sath .readLine() funtion use karna hota joh ki by default string ki value ko accept karta usko parse karna padta int me*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        System.out.println("My String input is :- " + input);

        // int num = Integer.valueOf(br.readLine());
        int num = Integer.parseInt(br.readLine());
        // double num = Double.parseDouble(br.readLine());

        System.out.println("My int input is :- " + num);

        // New Way of taking input (Scanner class)

        // Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // System.out.println(n);
        // sc.nextLine();

        // String str = sc.nextLine();
        // System.out.println(str);
    }
}
