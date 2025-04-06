package Exam_DAA;

public class Assignment24 {

    // KMP Search Function
    public static void search(char[] pat, char[] txt) {
        int m = pat.length;
        int n = txt.length;

        int[] lps = computeLPSArray(pat);

        int i = 0; // index for txt[]
        int j = 0; // index for pat[]
        while (i < n) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1]; // Continue searching
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    // Preprocess the pattern to create LPS array
    public static int[] computeLPSArray(char[] pat) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pat.length];
        lps[0] = 0;

        while (i < pat.length) {
            if (pat[i] == pat[length]) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        char[] txt = "AABAACAADAABAABA".toCharArray();
        char[] pat = "AABA".toCharArray();

        search(pat, txt);
    }
}
