package com.ddsaveeditor.quirk.repository;

import com.ddsaveeditor.quirk.Quirk;

import java.util.Collection;
import java.util.Optional;

public interface IQuirkLibrary {
    Collection<Quirk> getAll();
    Optional<Quirk> get(String id);
    Collection<Quirk> get(String ...ids);
    Collection<Quirk> getDiseases();
    Collection<Quirk> getNegatives();
    Collection<Quirk> getPositives();
    Collection<Quirk> getIncompatiblesWith(String id);
}
