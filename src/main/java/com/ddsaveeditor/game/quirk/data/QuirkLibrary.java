package com.ddsaveeditor.game.quirk.data;

import com.ddsaveeditor.game.data.GameDataContext;
import com.ddsaveeditor.game.quirk.Quirk;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A Repository responsible for returning data of Quirks from the game files
 */
public class QuirkLibrary implements IQuirkLibrary {
    private final GameDataContext dataContext;

    /**
     * Creates a Repository for Quirk Data
     * @param dataContext the context of the Quirk
     */
    public QuirkLibrary(GameDataContext dataContext){
        this.dataContext=dataContext;
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> getAll() {
        return this.dataContext.getQuirks()
                .getAll()
                .collect(Collectors.toList());
    }
    /** {@inheritDoc} **/
    public Optional<Quirk> get(String id) {
        return this.dataContext.getQuirks()
                .getFirst(quirk -> Objects.equals(quirk.id, id));
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> get(String... ids) {
        return this.dataContext.getQuirks()
                .get(quirk -> Arrays.asList(ids).contains(quirk.id))
                .collect(Collectors.toList());
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> getDiseases() {
        return this.dataContext.getQuirks()
                .get(quirk -> quirk.isDisease)
                .collect(Collectors.toList());
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> getNegatives() {
        return this.dataContext.getQuirks()
                .get(quirk -> !quirk.isPositive)
                .collect(Collectors.toList());
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> getPositives() {
        return this.dataContext.getQuirks()
                .get(quirk -> quirk.isPositive)
                .collect(Collectors.toList());
    }
    /** {@inheritDoc} **/
    public Collection<Quirk> getIncompatiblesWith(String id) {
        return this.dataContext.getQuirks()
                .get(quirk -> quirk.getIncompatibleQuirks().contains(id))
                .collect(Collectors.toList());
    }
}