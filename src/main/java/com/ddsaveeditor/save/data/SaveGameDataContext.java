package com.ddsaveeditor.save.data;

import com.ddsaveeditor.data.DataContext;
import com.ddsaveeditor.data.io.IDataReader;
import com.ddsaveeditor.save.roster.data.RosterData;

/**
 *
 */
public class SaveGameDataContext extends DataContext {
    private RosterData roster;
    /**
     * Gets one RosterData
     * @return A roster from {@link SaveGameDataContext#roster}
     */
    public RosterData getRoster(){
        return this.roster;
    }
    public SaveGameDataContext(IDataReader reader) {
        super(reader);
        this.load();
    }
    /** {@inheritDoc} **/
    public void load() {
        try{
            this.roster = this.reader.read(
                    "persist.roster",
                    RosterData.class
            );
        } catch (Exception e) {
            //TODO: throw custom exception
            throw new RuntimeException(e);
        }
    }
    /** {@inheritDoc} **/
    public void commit() {

    }
}
