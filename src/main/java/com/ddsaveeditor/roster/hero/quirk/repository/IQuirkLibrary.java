package com.ddsaveeditor.roster.hero.quirk.repository;

import com.ddsaveeditor.roster.hero.quirk.Quirk;

import java.util.Collection;

public interface IQuirkLibrary {
    Collection<Quirk> GetAll();
    Quirk Get(String ids);
    Collection<Quirk> Get(String[] ...ids);
}
