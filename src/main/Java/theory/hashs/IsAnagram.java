package theory.hashs;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        int[] sourceNums = new int[26];
        for (int i = 0; i < source.length(); i++) {
            sourceNums[source.charAt(i) - 'a']++;
            sourceNums[target.charAt(i) - 'a']--;
        }
        for (int i = 0; i < sourceNums.length; i++) {
            if (sourceNums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
