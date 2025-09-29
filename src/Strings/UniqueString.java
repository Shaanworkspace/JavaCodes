package Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueString {
    boolean isUniqueByHashSet(String sub) {
        Set<Character> set = new HashSet<>();
        for (char c : sub.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
    boolean isUniqueBooleanArray(String sub) {
        boolean[] seen = new boolean[128]; // ASCII size
        for (int k = 0; k < sub.length(); k++) {
            char c = sub.charAt(k);
            if (seen[c]) return false;
            seen[c] = true;
        }
        return true;
    }

    boolean isUniqueByBitMask(String sub) {
        int mask = 0;
        for (int k = 0; k < sub.length(); k++) {
            int ch = sub.charAt(k) - 'a';
            if ((mask & (1 << ch)) != 0) return false; // bit already set
            mask |= (1 << ch); // set bit
        }
        return true;
    }

}
