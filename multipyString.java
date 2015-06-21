public class Solution {
    public String multiply(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        if(ch1.length == 0 || ch2.length == 0) {
            throw new IllegalArgumentException("empty number");
        }
        int[] list = new int[ch1.length + ch2.length];
        for(int i = ch1.length - 1; i >= 0; i--) {
            if(ch1[i] == '0') {
                continue;
            }
            int x = ch1[i] - '0';
            for(int j = ch2.length - 1; j >= 0; j--) {
                int y = ch2[j] - '0';
                int index = ch1.length - i - 1 + ch2.length - j - 1;
                int mul = x * y;
                while(mul != 0) {
                    mul += list[index];
                    int curr = mul % 10;
                    list[index] = curr;
                    index ++;
                    mul = mul / 10;
                }
            }
        }
        int start = list.length - 1;
        while(start > 0 && list[start] == 0) start--;
        StringBuilder sb = new StringBuilder();
        while(start >= 0) {
            sb.append(list[start]);
            start--;
        }
        return sb.toString();
    }
}