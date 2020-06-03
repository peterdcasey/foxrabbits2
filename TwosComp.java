
/**
 * Write a description of class TwosComp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */ 
public class TwosComp
{
    private static java.io.PrintStream so = System.out;
    
    public static void main(String[] args) {
        so.println(1 + " " + showBits(1,13));
        so.println(1 + " " + showBitsx(1,13));
        so.println(0 + " " + showBits(0,13));
        so.println(-1 + " " + showBits(-1,13));
        so.println(-2 + " " + showBits(-2,13));
        so.println(-3 + " " + showBits(-3,13));
        so.println(-3 + " " + showBitsx(-3,13));
        //so.println(flipBits("1010"));
        //so.println(addOne("1010"));
    }
    
    // default 8 bit number
    static String showBits(int num) {
        return showBits(num, 8);
    }
    
    static String showBits(int num, int bitLength) {
        // int dividend = num;
        int quotient = 0;
        int remainder = 0;
        String result = "";
        boolean negative = num < 0;
        
        if (negative) {
            // num = -num; // abs(num)
            num = ~num;
        } 
        
        int dividend = num;
        
        while (dividend != 0) {
            quotient = dividend / 2;
            remainder = dividend % 2;
            result = remainder + result;
            dividend = quotient;
        }
        
        int zeros = bitLength - result.length();
        
        for (int i = 0; i < zeros; i += 1) {
            result = "0" + result;
        }
        
        if (negative) {
            // result = addOne(flipBits(result));
            result = flipBits(result);
        }
        
        return  result;
    }
    
    static String showBitsx(int num, int bitLength) {
        String result = "";
        int quotient = 0;
        int remainder = 0;
        boolean negative = (num < 0);
       
        if (negative){
            num = ~num;
        }
       
        int dividend = num;
       
        while (dividend !=0){
            quotient = dividend / 2;
            remainder = dividend % 2;
            result = remainder + result;
            dividend = quotient;
        }
               
        int zeros = bitLength - result.length();
       
        for (int i = 0; i < zeros; i += 1){
                result = "0" + result;            
        }
       
        if (negative){
            // so.println("~" + result);
            result = flipBits(result);
        }
       
        return result;
    } 
    
    static String flipBits(String s) {  //  0110
        String result = "";
        
        for (int i = 0; i < s.length(); i += 1) {
            char ch = s.charAt(i);
            
            if (ch == '1') {
                result = result + '0';
            }
            else {
                result = result + '1';
            }
        }
        
        return result;
    }
    
    private static String addOne(String binaryString) {
        String result = "";
        char[] chars = binaryString.toCharArray();
        boolean carry = true;

        for(int i = chars.length -1; i >= 0; i--) {
            char c = chars[i];
            
            if(c == '1' && carry) {
                result = "0" + result;
            } else if (carry) {
                carry = false;
                result = "1" + result;
            } else {
                result = c + result;
            }

        }
        return result;
    } 
}
