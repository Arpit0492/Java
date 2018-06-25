package JavaBrains;

/**
 * Created by ARPIT JOHRI on 30-11-2016.
 */
public class ClosuresExample {

    public static void main(String[] args) {
        int a = 10;
        int j = 30;
        doProcess(a,i -> System.out.println(i+j));



    }


    public static void doProcess(int i, Process p){
        p.Process(i);
    }
}


interface Process{
    void Process(int i);
}
