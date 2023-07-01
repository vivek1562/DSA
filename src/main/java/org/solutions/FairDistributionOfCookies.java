package org.solutions;

public class FairDistributionOfCookies {
    int answer = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int[] cookieDist = new int[k];
        recursion(cookies, 0, k, cookieDist);
        return answer;
    }

    public int recursion(int[] cookies, int i, int k, int[] cookieDist) {
        if(i>=cookies.length) {
            int maxCookie = Integer.MIN_VALUE;
            for(int possibleResult : cookieDist)
                maxCookie = Math.max(maxCookie, possibleResult);
            answer = Math.min(answer, maxCookie);
            return answer;
        }

        int currentCookie = cookies[i];
        for(int j=0; j<k; j++) {
            cookieDist[j]+=currentCookie;
            recursion(cookies, i+1, k, cookieDist);
            cookieDist[j]-=currentCookie;
        }

        return answer;
    }
}
