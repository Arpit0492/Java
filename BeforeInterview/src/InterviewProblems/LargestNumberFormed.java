package InterviewProblems; /**
 * Created by ARPIT JOHRI on 17-03-2017.
 *
 * link : http://www.practice.geeksforgeeks.org/problem-page.php?pid=380
 */
import java.util.*;

public class LargestNumberFormed {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            ArrayList<String> A = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                A.add(scan.nextInt()+"");
            }

            Collections.sort(A, (o1, o2) -> (o2+o1).compareTo(o1+o2));

            for (String s:A) {
                System.out.printf(s+"");
            }
            System.out.println();
        }
    }
}
