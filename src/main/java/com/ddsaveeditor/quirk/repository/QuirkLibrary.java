package com.ddsaveeditor.quirk.repository;

import com.ddsaveeditor.file.JSONFileReader;
import com.ddsaveeditor.quirk.Quirk;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class QuirkLibrary implements IQuirkLibrary {
    private static final String QUIRK_LIBRARY_PATH = ".\\quirk_library.json";

    private final JSONFileReader fileReader;

    private Collection<Quirk> quirks;
    public QuirkLibrary(JSONFileReader fileReader){
        this.fileReader=fileReader;
    }

    @Override
    public Collection<Quirk> getAll() {
        try{
            this.quirks = this.fileReader.readList(QUIRK_LIBRARY_PATH, Quirk.class);
        }catch (IOException exception){
            //TODO: criar excessão customizada
            return new ArrayList<>();
        }

        return this.quirks;
    }

    @Override
    public Optional<Quirk> get(String id) {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream().filter(quirk -> Objects.equals(quirk.id, id)).findFirst();
    }

    @Override
    public Collection<Quirk> get(String... ids) {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream()
                .filter(quirk -> Arrays.stream(ids).anyMatch(id -> Objects.equals(quirk.id, id)))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Quirk> getDiseases() {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream()
                .filter(quirk -> quirk.isDisease)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Quirk> getNegatives() {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream()
                .filter(quirk -> !quirk.isPositive)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Quirk> getPositives() {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream()
                .filter(quirk -> quirk.isPositive)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Quirk> getIncompatiblesWith(String id) {
        if(this.quirks.isEmpty())
            this.getAll();
        return this.quirks.stream()
                .filter(quirk -> quirk.getIncompatibleQuirks().contains(id))
                .collect(Collectors.toList());
    }
}
