class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        ArrayList<Map.Entry<Character,Integer>>list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        StringBuilder answer=new StringBuilder();
        for(Map.Entry<Character,Integer>entry:list){
            char ch=entry.getKey();
            int frequency=entry.getValue();
            for(int i=0;i<frequency;i++){
                answer.append(ch);
            }
            
        }
        return answer.toString();
    
        
    }
}