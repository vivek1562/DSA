package org.solutions;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        //remove elements from wordSet then you won't need a separate visited array
        // Set<String> visited = new HashSet<>();
        // visited.add(beginWord);
        int level = 1, currSize;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        String currWord;
        char[] permutation;
        String permutationString;
        while(!q.isEmpty()) {
            currSize = q.size();
            level++;
            while(currSize-->0) {
                currWord = q.poll();
                for(int i=0; i<currWord.length(); i++) {
                    permutation = currWord.toCharArray();
                    for(char c='a'; c<='z'; c++) {
                        permutation[i] = c;
                        permutationString = new String(permutation);
                        if(wordSet.contains(permutationString)) {
                            wordSet.remove(permutationString);
                            if(permutationString.equals(endWord))
                                return level;
                            q.offer(permutationString);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
