import java.util.*; 
public class rec_ArrayList {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        ArrayList<String> ans = getKPC("79");
        System.out.println(ans);
    }

    //print all substrings of a string
    public static void getSubstrings(String str){
        for(int i =0 ; i < str.length() ; i++){
            for(int j = i ; j < str.length(); j++){
                String s = str.substring(i, j+1);
                System.out.println(s);
            }
        }
    }

    //get subsequence
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");  //imp step
            return bans;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr = gss(ros);
        ArrayList<String> ans = new ArrayList<>();
        for(int i =0 ; i < rr.size() ; i++){
            String s = rr.get(i);
            ans.add(s);
        }

        for(int i =0 ; i < rr.size() ; i++){
            String s = rr.get(i);
            ans.add(ch + s);
        }
        return ans;
    }

    //get kpc

    public static String[] codes = {".;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        int n = str.charAt(0) - '0';
        String ros = str.substring(1);
        ArrayList<String> rr = getKPC(ros);
        ArrayList<String> ans = new ArrayList<>();
        //String toAdd = codes[n]; 
        for(int i = 0 ; i < codes[n].length() ; i++){
            for(String s : rr){
                ans.add(codes[n].charAt(i) + "" + s);
            }
        }

        return ans;
    }
}
