class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, String> owner = new HashMap<>();
        HashMap<String, TreeSet<String>> mergedAccounts = new HashMap<>();
    
        List<List<String>> out = new ArrayList<>();
        
        
        for (List<String> emails : accounts) {
            String user = emails.get(0);
            
            for (int i = 1; i < emails.size(); i++) {        
                owner.put(emails.get(i), user);
                parents.put(emails.get(i), emails.get(i));
            }
        }
         
        for (List<String> emails : accounts) {
            String p1 = findParent(parents, emails.get(1));
            
            for (int i = 2; i < emails.size(); i++) {
                String p2 = findParent(parents, emails.get(i));
                
                // union
                if (p1.equals(p2) == false) {
                    parents.put(p2, p1);
                }
            }
        }
        
        for(List<String> a : accounts) {
            String p = findParent(parents, a.get(1));
            if (!mergedAccounts.containsKey(p)) {
                mergedAccounts.put(p, new TreeSet<>());
            }
                
            for (int i = 1; i < a.size(); i++)
                mergedAccounts.get(p).add(a.get(i));
        }
        
  
        
        for (String key : mergedAccounts.keySet()) {
            List<String> list = new ArrayList<>(mergedAccounts.get(key));
            String own = owner.get(key);
            list.add(0, own);
            out.add(list);
        }
        
        return out;
    }
    
    String findParent(HashMap<String, String> parents, String email) {
        while (parents.get(email).equals(email) == false) {
            email = parents.get(email);
        }
        
        return email;
    }
}
