package com.ddsaveeditor.quirk.repository;

import com.ddsaveeditor.quirk.Quirk;

import java.util.Collection;

public interface IQuirkLibrary {
    Collection<Quirk> GetAll();
    Quirk Get(String id);
    Collection<Quirk> Get(String[] ...ids);
    Collection<Quirk> GetDiseases();
    Collection<Quirk> GetNegatives();
    Collection<Quirk> GetPositives();
    Collection<Quirk> GetIncompatiblesWith(String id);
}
