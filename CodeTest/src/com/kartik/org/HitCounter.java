package com.kartik.org;


public class HitCounter {
	private int[] times, hits;
	/** Initialize your data structure here. */
    HitCounter() {
        times=new int[300];
        hits=new int[300];
    }

    /** Record a hit.
    @timestamp - The current timestamp (in seconds granularity). */
    void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            ++hits[idx];
        }
    }

    /** Return the number of hits in the past 5 minutes.
    @timestamp - The current timestamp (in seconds granularity). */
    int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; ++i) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }

};

