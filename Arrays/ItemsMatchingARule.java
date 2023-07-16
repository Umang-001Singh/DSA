package Arrays;

import java.util.*;

public class ItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        ArrayList<ArrayList<String>> result =new ArrayList<>();
        for(int i=0;i<3;i++){
            result.add(new ArrayList<>());
        }

        for(int j=0;j<items.size();j++){
            for(int k=0;k<items.size();k++){
                (result.get(j)).add(items.get(j).get(k));
            }

        }
        int count;
        if(ruleKey.equals("type")){
            count=0;
            for(String s:result.get(0)){
                if(s.equals(ruleValue)){
                    count++;
                }

            }
        }
        else if(ruleKey.equals("color")){
            count=0;
            for(String c:result.get(1)){
                if(c.equals(ruleValue)){
                    count++;
                }
            }
        }
        else {
            count=0;
            for(String n: result.get(2)){
                if(n.equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }
}
