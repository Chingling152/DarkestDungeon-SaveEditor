package com.ddsaveeditor.save.roster.data;

import java.util.Map;

public class RosterData {
    public static class RosterLastPartyData {
        public final String[] lastPartyGuids;

        public RosterLastPartyData(String[] lastPartyGuids){
            this.lastPartyGuids = lastPartyGuids;
        }
    }
    public String version;
    public String nextGuid;
    public int dismissedHeroCount;
    public Map<String, Object> heroes;
    public RosterLastPartyData lastParty;
    public double highestResolveXp;
}
