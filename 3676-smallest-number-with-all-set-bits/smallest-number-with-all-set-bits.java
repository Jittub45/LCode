class Solution {
    public int smallestNumber(int n) {
        while(true){
            String bin = Integer.toBinaryString(n);
            char[] ch = bin.toCharArray();
            boolean flag = true;

            for(char bit: ch){
                if(bit == '0'){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                return n;
            
            n++;
        }
    }
}