package com.ddsaveeditor.quirk.repository;

import com.ddsaveeditor.quirk.Quirk;

import java.util.ArrayList;
import java.util.Collection;

// JSONArray a = (JSONArray) parser.parse(new FileReader("c:\\exer4-courses.json"));

public class QuirkLibrary implements IQuirkLibrary {

    public QuirkLibrary(){

    }

    @Override
    public Collection<Quirk> GetAll() {
        return new ArrayList<>();
    }

    @Override
    public Quirk Get(String id) {
        return null;
    }

    @Override
    public Collection<Quirk> Get(String[]... ids) {
        return new ArrayList<>();
    }

    @Override
    public Collection<Quirk> GetDiseases() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Quirk> GetNegatives() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Quirk> GetPositives() {
        return new ArrayList<>();
    }

    @Override
    public Collection<Quirk> GetIncompatiblesWith(String id) {
        return new ArrayList<>();
    }
}
