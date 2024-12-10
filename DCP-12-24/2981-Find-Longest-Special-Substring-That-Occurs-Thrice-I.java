class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int len = s.length(), max = 0;

        for(int i = 0; i < len; ){
            char c = s.charAt(i);
            int count = 0;

            while(i < len && s.charAt(i) == c){
                count++;
                i++;
            }

            if(count == 1){
                max = Math.max(max, addToHashMap(hmap, String.valueOf(c), max, 1));
                continue;
            }

            int currMaxSize = count - 2;
            max = Math.max(max, currMaxSize);

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < count - 1; j++){
                sb.append(c);
            }

            max = Math.max(max, addToHashMap(hmap, sb.toString(), max, 2));
            sb.append(c);
            max = Math.max(max, addToHashMap(hmap, sb.toString(), max, 1));
        }

        return max >= 1 ? max : -1;
    }
    public int addToHashMap(HashMap<String, Integer> hmap, String sToAdd, int max, int addNum){
        if(!hmap.containsKey(sToAdd)){
            hmap.put(sToAdd, 0);
        }

        int newCount = hmap.get(sToAdd) + addNum;
        if(newCount >= 3){
            hmap.remove(sToAdd);
            return sToAdd.length();
        }
        else{
            hmap.put(sToAdd, newCount);
            return 0;
        }
    }
}