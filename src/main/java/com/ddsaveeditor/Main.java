package com.ddsaveeditor;

import com.ddsaveeditor.file.JSONFileReader;
import com.ddsaveeditor.quirk.Quirk;
import com.ddsaveeditor.quirk.repository.QuirkLibrary;

import java.util.Collection;

public class Main {
    public static void main(String... args) {
        QuirkLibrary repository = new QuirkLibrary(new JSONFileReader());
        Collection<Quirk> quirks = repository.GetAll();
    }
}
