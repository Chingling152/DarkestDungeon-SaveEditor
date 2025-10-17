package com.ddsaveeditor.game.quirk.data;

import com.ddsaveeditor.game.data.GameDataContext;
import com.ddsaveeditor.game.quirk.Quirk;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuirkLibrary implements IQuirkLibrary {
    private final GameDataContext dataContext;

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
                .getById(id);
    }

    /** {@inheritDoc} **/
    public Collection<Quirk> get(String... ids) {
        return this.dataContext.getQuirks()
                .getByIds(ids)
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
