public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strs) {
            int len = str.length();
            sb.append(len);
            sb.append("/");
            sb.append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, slash));
            
            // next string will be at 
            i = slash + size + 1;
            String str = s.substring(slash + 1, i);
            ans.add(str);
        }
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
