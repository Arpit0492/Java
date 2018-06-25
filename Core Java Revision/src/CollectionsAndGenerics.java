import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

public class CollectionsAndGenerics {


    public static void main(String a[]) throws Exception {

        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        List<Integer> list = new ArrayList<>();
//
//
//        for (int i = 0; i <T; i++) {
//            list.add(in.nextInt());
//        }
//
//        Iterator<Integer> itr = list.iterator();
//
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//            itr.remove();
//        }

//        System.out.println(reverseStringRecursively("abcdefhijklmnopqrstuvwxyz"));
        String s = "";
//        printFibonacciUpto100();

        int A = 2, B = 3;

        A = A ^ B;
        B = A ^ B;
        A = A ^ B;

        System.out.println(A+" "+B);
    }

    public static String reverseStringRecursively(String str){

        if (str.length() < 2)
            return str;

        return reverseStringRecursively(str.substring(1)) + str.charAt(0);
    }


    public static void printFibonacciUpto100(){
        long [] fib = new long[100];

        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i <100; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        for (long f : fib) {
            System.out.println(f);
        }
    }

    public static boolean isArmstrong(int num){
        int result = 0;
        int orig = num;

        while(num != 0){
            int remainder = num % 10;
            result += remainder*remainder*remainder;
            num /= 10;
        }

        return orig == result;
    }

    private static int gcd(int a , int b){
        if (b==0)
            return a;
        return gcd(b, a%b);
    }

}

class Order implements Comparable<Order>{

    int orderId;
    String customer;
    int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return getOrderId() != order.getOrderId();

    }

    @Override
    public int hashCode() {
        int result = getOrderId();
        result = 31 * result + getCustomer().hashCode();
        result = 31 * result + getAmount();
        return result;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Order o) {
        return this.getOrderId()<o.getOrderId()?-1:this.getOrderId()>o.getOrderId()?1:0;
    }

    private static class OrderByAmount implements Comparator<Order>{
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getAmount() < o2.getAmount()?-1:o1.getAmount()>o2.getAmount()?1:0;
        }
    }

    private static class OrderByName implements Comparator<Order>{
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getCustomer().compareTo(o2.getCustomer());
        }
    }
}

class DaemonThreadExample{
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            try {
                while (true){
                    System.out.println("Daemon thread is running");
                }
            }catch (Exception e){}
            finally {
                System.out.println("Daemon thread is exiting");
            }
        }, "Daemon Thread");

        daemon.setDaemon(true);
        daemon.start();
    }
}

class DateAPI{
    public static void main(String[] args) {
        Date d1 = new Date(100000000L);
        Calendar c = Calendar.getInstance();
        c.setTime(d1);

        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        c.roll(Calendar.MONTH, 12);
        Date d2 = c.getTime();
        System.out.println(d2.toString());

        Date d3 = new Date(100000000000L);

        DateFormat [] df = new DateFormat[1];

        df [0] = DateFormat.getInstance();
        DateFormat f = DateFormat.getDateTimeInstance();
        System.out.println(f.format(d3));


        Locale IN = new Locale("pt","BR");
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.format(IN));


        Map<String, Integer> map = new HashMap<>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort( list, (o1, o2) -> (o2.getValue()).compareTo( o1.getValue() ));

        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    }

}