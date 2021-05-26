/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        // Store our read chars from Read4
        char[] temp = new char[4];
        int totalRead = 0;
        
        while (totalRead < n) {
            int countRead = read4(temp);
            
            int numCharToCopy = Math.min(countRead, n - totalRead);
            
             /*Even if we read 4 chars from Read4, 
            we don't want to exceed N and only want to read chars till N.*/
            for (int i = 0; i < numCharToCopy; i++) {
                buf[totalRead] = temp[i];
                totalRead++;
            }
            
            
            if (countRead < 4) {
                // done.
                break;
            }
            
        }
        
        return totalRead;
    }
}
