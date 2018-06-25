package InterviewProblems;

import java.util.*;

/**
 * Created by Arpit on 21-10-2017.
 * https://leetcode.com/problems/next-closest-time/description/
 * BRUTE FORCE solution
 */
public class nextClosestTime {


    public static void main(String[] args) {
        nextClosestTime n = new nextClosestTime();
//        n.nextClosestTime("22:59");
        System.out.println(n.nextClosestTime("19:34"));
    }

    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (char c : time.toCharArray())
            set.add(c);

        ArrayList<String> timeList = generateTimes();
        Collections.sort(timeList);
//        timeList.forEach(System.out::println);

        int index = Collections.binarySearch(timeList,time);
        while (true){
            index++;
            if (index == timeList.size()) {
                index = -1;
                continue;
            }
            String nextTime = timeList.get(index);
            if (set.contains(nextTime.charAt(0)) && set.contains(nextTime.charAt(1))
                    && set.contains(nextTime.charAt(3)) && set.contains(nextTime.charAt(4))) {
                return nextTime;
            }

        }
    }

    private ArrayList<String> generateTimes() {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        h1:for (int h1 = 0; h1 <3; h1++) {
            for (int h2 = 0; h2 < 10; h2++) {
                if (h1==2 && h2==4)
                    break h1;
                for (int m1 = 0; m1 < 6; m1++) {
                    for (int m2 = 0; m2 < 10; m2++) {
//                        map.put(h1+""+h2+":"+m1+""+m2,0);
                        list.add(h1+""+h2+":"+m1+""+m2);
//                        System.out.println(h1+""+h2+":"+m1+""+m2);
                    }
                }
            }
        }
        return list;
    }

}


