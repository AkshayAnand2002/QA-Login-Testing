package temp1;

import java.util.Date;

public class GenerateEmail {
    public static void main(String[] args){
        Date date=new Date();
        System.out.println(date);
        String dateString=date.toString();
        String nospace=dateString.replaceAll(" ","");
        String res=nospace.replaceAll("\\:","");
        String result=res+"@abc.com";
        System.out.println(result);
    }
}
