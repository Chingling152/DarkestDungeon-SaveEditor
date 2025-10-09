package com.ddsaveeditor.roster.hero.quirk.repository;

import com.ddsaveeditor.roster.hero.quirk.Quirk;

import java.util.ArrayList;
import java.util.Collection;

public class QuirkLibrary implements IQuirkLibrary{

    @Override
    public Collection<Quirk> GetAll() {
        return new ArrayList<>();
    }

    @Override
    public Quirk Get(String ids) {
        return null;
    }

    @Override
    public Collection<Quirk> Get(String[]... ids) {
        return new ArrayList<>();
    }
}
