package com.ddsaveeditor.save.roster.data;

import com.ddsaveeditor.save.data.SaveGameDataContext;
import com.ddsaveeditor.save.roster.Roster;

/**
 *
 */
public class RosterRepository {
    private final SaveGameDataContext context;
    /**
     *
     * @param context
     */
    public RosterRepository(SaveGameDataContext context){
        this.context = context;
    }
    /**
     *
     * @return the only roster available
     */
    public Roster getRoster(){
        RosterData rosterData = this.context.getRoster();
        if (rosterData == null) {
            throw new NullPointerException();
        }

        return new Roster();
    }
}
