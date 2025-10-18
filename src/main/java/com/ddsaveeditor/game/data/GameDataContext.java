package com.ddsaveeditor.game.data;

import com.ddsaveeditor.data.DataContext;
import com.ddsaveeditor.data.ReadonlyDataCollection;
import com.ddsaveeditor.data.io.IDataReader;
import com.ddsaveeditor.game.quirk.Quirk;

/**
 * A DataContext that holds Game Data
 */
public class GameDataContext extends DataContext
{
    private ReadonlyDataCollection<Quirk> quirks;
    /**
     * Gets all quirks from the game
     * @return All quirks from {@link GameDataContext#quirks}
     */
    public ReadonlyDataCollection<Quirk> getQuirks(){
        return this.quirks;
    }
    /**
     * Creates a GameDataContext and loads its data
     * @param reader the reader responsible for returning the data
     */
    public GameDataContext(IDataReader reader) {
        super(reader);
        this.load();
    }
    /** {@inheritDoc} **/
    public void load() {
        try{
            this.quirks = new ReadonlyDataCollection<>(
                    this.reader.readList(
                            "quirk_library",
                            Quirk.class
                    )
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
