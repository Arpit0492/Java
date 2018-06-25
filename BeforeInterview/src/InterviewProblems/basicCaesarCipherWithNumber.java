package InterviewProblems;import java.util.Scanner;

public class basicCaesarCipherWithNumber
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int M=0; M<t; M++){
            int l = sc.nextInt();
            int k=sc.nextInt();
            String s=sc.next();
            String mine=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String my=" abcdefghijklmnopqrstuvwxyz";
            String nums = " 0123456789";
            //     int hash[]=new int[52];
            char ch;
            int ind;
            StringBuilder result=new StringBuilder();

            for(int i=0;i<s.length();i++)
            {
                ch=s.charAt(i);
                if(Character.isUpperCase(ch) && !Character.isDigit(ch) )
                {
                    ind=mine.indexOf(ch);
                    if((ind+k)%26!=0)
                        result.append(mine.charAt((ind+k)%26));
                    else
                        result.append(mine.charAt((26)));

                }
                else if(Character.isLowerCase(ch) && !Character.isDigit(ch))
                {
                    ind=my.indexOf(ch);
                    if((ind+k)%26!=0)
                        result.append(my.charAt(((ind+k)%26)));
                    else
                        result.append(my.charAt((26)));

                }
                else if(Character.isDigit(ch)){
                    ind = nums.indexOf(ch);
                    if((ind+k)%10!=0)
                        result.append(nums.charAt((ind+k)%10));
                    else
                        result.append(nums.charAt((10)));
                }
                else
                    result.append(ch);
            }
            System.out.println(result);
        }
    }
}

