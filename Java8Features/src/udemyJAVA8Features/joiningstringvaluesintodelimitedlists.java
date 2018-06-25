package udemyJAVA8Features;

/**
 * Created by Arpit on 28-06-2017.
 */
public class joiningstringvaluesintodelimitedlists {

    public static void main(String[] args) {
        /*
        join(delimiter, elements[iterables])
         */
//        String stooges = String.join(",","Larry","Curly","Moe");
        String stooges = String.join(" and ","Larry","Curly","Moe");
        String [] states = {"California", "Oregon", "New York"};
        String statesList = String.join("-",states);
        System.out.println(statesList);
    }

}
