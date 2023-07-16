package org.solutions.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostTickets {
    int n;
    int[] dp;

    public int minCostTickets(int[] days, int[] costs) {
        n = days[days.length-1];
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        Set<Integer> travelDays = new HashSet<>();
        for(int day : days)
            travelDays.add(day);
        return recur(travelDays, costs, 0);
    }

    public int recur(Set<Integer> travelDays, int[] costs, int currDay) {
        if(currDay > n)
            return 0;

        if(!travelDays.contains(currDay))
            return recur(travelDays, costs, currDay+1);

        if(dp[currDay] != -1)
            return dp[currDay];

        int oneDay = costs[0] + recur(travelDays, costs, currDay+1);
        int sevenDay = costs[1] + recur(travelDays, costs, currDay+7);
        int thirtyDay = costs[2] + recur(travelDays, costs, currDay+30);

        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}
