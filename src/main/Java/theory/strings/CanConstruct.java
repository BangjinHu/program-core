package theory.strings;

public class CanConstruct {

    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() < magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']--;
            if (count[magazine.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
