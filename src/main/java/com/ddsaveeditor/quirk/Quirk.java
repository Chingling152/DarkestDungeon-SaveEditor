package com.ddsaveeditor.quirk;

public class Quirk {
    public final String id;
    public final String name;
    public final boolean isPositive;
    public final boolean isDisease;
    public final String classification;
    private final String[] incompatibleQuirks;

    public Quirk(
            String id, String name,
            boolean isPositive, boolean isDisease,
            String classification, String[] incompatibleQuirks
    ) {
        this.id = id;
        this.name = name;
        this.isPositive = isPositive;
        this.isDisease = isDisease;
        this.classification = classification;
        this.incompatibleQuirks = incompatibleQuirks;
    }

    public String[] getIncompatibleQuirks(){
        return this.incompatibleQuirks.clone();
    }
}
