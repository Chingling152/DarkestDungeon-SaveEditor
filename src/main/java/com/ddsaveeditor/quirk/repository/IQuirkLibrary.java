package com.ddsaveeditor.quirk.repository;

import com.ddsaveeditor.quirk.Quirk;

import java.util.Collection;
import java.util.Optional;

public interface IQuirkLibrary {
    Collection<Quirk> GetAll();
    Optional<Quirk> Get(String id);
    Collection<Quirk> Get(String ...ids);
    Collection<Quirk> GetDiseases();
    Collection<Quirk> GetNegatives();
    Collection<Quirk> GetPositives();
    Collection<Quirk> GetIncompatiblesWith(String id);
}
