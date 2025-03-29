package Searching.LinearSearch;

public class LS_Strings {

    static boolean linearSearch(String str, char target){
        if(str.isEmpty()){
            return false;
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String name = "Aniket";
        char c = 'k';
        System.out.println(linearSearch(name,c));
    }

}
