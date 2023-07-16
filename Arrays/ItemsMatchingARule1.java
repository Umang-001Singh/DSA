package Arrays;
import java.util.*;

public class ItemsMatchingARule1 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        ArrayList<String> type=new ArrayList<>();
        ArrayList<String> color= new ArrayList<>();
        ArrayList<String> name= new ArrayList<>();


        for(int j=0;j<items.size();j++){
            type.add(items.get(j).get(0));
            color.add(items.get(j).get(1));
            name.add(items.get(j).get(2));
        }
        int count;
        if(ruleKey.equals("type")){
            count=0;
            for(String s:type){
                if(s.equals(ruleValue)){
                    count++;
                }

            }
        }
        else if(ruleKey.equals("color")){
            count=0;
            for(String c:color){
                if(c.equals(ruleValue)){
                    count++;
                }
            }
        }
        else {
            count=0;
            for(String n:name){
                if(n.equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }


}


