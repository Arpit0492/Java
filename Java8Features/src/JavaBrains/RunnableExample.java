package JavaBrains; /**
 * Created by ARPIT JOHRI on 27-11-2016.
 */

/************Classic Example to Use LAMBDA Expressions**************************/
public class RunnableExample {

    public static void main(String[] args) {

        Thread myThread = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");

            }
        });


        myThread.start();

        Thread myThread2 = new Thread(()-> System.out.println("Inside lambda Runnable"));




    }
}
