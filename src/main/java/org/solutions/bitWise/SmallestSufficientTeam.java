package org.solutions.bitWise;

import java.util.*;

public class SmallestSufficientTeam {
    List<Integer> answer = new ArrayList<>();
    int targetMask;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> indexMap = new HashMap<>();
        int i=0;
        for(String skill : req_skills) {
            indexMap.put(skill, i);
            i++;
        }
        List<Integer> maskedPeople = new ArrayList<>();
        for(List<String> skillList : people) {
            int mask = 0;
            for(String skill : skillList) {
                mask |= 1 << indexMap.get(skill);
            }
            maskedPeople.add(mask);
        }
        targetMask = (int)Math.pow(2, req_skills.length)-1;
        int[][] dp = new int[targetMask+1][people.size()];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        helper(new ArrayList<>(), maskedPeople, 0, 0, dp);
        return answer.stream().mapToInt(j->j).toArray();
    }

    public void helper(List<Integer> currTeam, List<Integer> maskedPeople, int i, int currMask, int[][] dp) {
        if(i>=maskedPeople.size()) {
            if(currMask == targetMask && (answer.size()==0 || answer.size()>currTeam.size())) {
                answer = new ArrayList<>(currTeam);
            }
            return;
        }

        if(dp[currMask][i] != -1 && dp[currMask][i] <= currTeam.size())
            return;

        if(answer.size()!=0 && currTeam.size()>=answer.size())
            return;

        helper(currTeam, maskedPeople, i+1, currMask, dp);
        //explore only if the possible result is changed
        if((currMask | maskedPeople.get(i)) != currMask) {
            currTeam.add(i);
            helper(currTeam, maskedPeople, i+1, currMask | maskedPeople.get(i), dp);
            currTeam.remove(currTeam.size()-1);
        }

        if(currTeam.size()>0)
            dp[currMask][i] = currTeam.size();
    }
}
