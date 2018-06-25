package JavaBrains;

/**
 * Created by ARPIT JOHRI on 30-11-2016.
 */
public class ThisReferenceExample {
    public void doProcess(int i , Process p){
        p.Process(i);
    }

    public void execute(){
        doProcess(110, i->{
            System.out.println("Value of i is " + i);
            System.out.println(this);
        });
    }
    public static void main(String[] args) {

        ThisReferenceExample thiss = new ThisReferenceExample();
//        thiss.doProcess(110, i->{
//            System.out.println("Value of i is " + i);
//            //System.out.println(this);
//        });
      thiss.execute();
    }

    @Override
    public String toString() {
        return "This is the main JavaBrains.ThisReferenceExample class instance";
    }
}
