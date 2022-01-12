class Solution {
    public int findNthDigit(int n) {
        int numDigits = 1;
        long count = 9; //the number counts of current digit level,we start at one digit,there are 9 numbers(1-9)which is at one digit.
       /**
        * number [1-9] (there are 9 numbers)is of one digit,number[10-99](there are 90 numbers) is
        * of two digits,number[100-999](there are 900 numbers) is of three digits,so first we should
        * find what level(i mean which digits(one digit,two digit or so on)  by level) the nth digit locate,
        * once we find the digit level, we achieve half the process,
        */
       /**
        *if n - digit * counts > 0,it means the nth digit is not at the current digit level,we should
        * increase digit level to pass more number
        */
        
        while (n - count * numDigits > 0) {
            n = n -  (int)(count * numDigits);
            numDigits++;
            
             //counts are grow as follows,9,90,900,9000.....since the counts maybe overflow so i use long typ
            count = count * 10;
        }
        //after loop,the n means nth digits from the current baseNumber

       //the base number is 1，10，100，1000，10000 and so on.
        int baseNUmber = (int) Math.pow(10, numDigits - 1);
        //find the number where nth digit locate
        int number = (n - 1) / numDigits + baseNUmber;
        //find the digit where nth digit locate at the number above
        int indexOfNthDigit = (n - 1) % numDigits;
        
        return String.valueOf(number).charAt(indexOfNthDigit) - '0';
    }
}
