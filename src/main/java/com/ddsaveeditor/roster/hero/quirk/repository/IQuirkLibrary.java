package com.ddsaveeditor.roster.hero.quirk.repository;

import com.ddsaveeditor.roster.hero.quirk.Quirk;

import java.util.Collection;

public interface IQuirkLibrary {
    public Collection<Quirk> GetAll();
    public Quirk Get(String ids);
    public Collection<Quirk> Get(String[] ...ids);
}
