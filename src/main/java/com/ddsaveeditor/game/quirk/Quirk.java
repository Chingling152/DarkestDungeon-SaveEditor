package com.ddsaveeditor.game.quirk;

import com.ddsaveeditor.data.DataEntity;

import java.util.Arrays;
import java.util.Collection;

/**
 * Quirk data of Heroes from the game library
 */
public class Quirk extends DataEntity {
    /**
     * Shows if the current Quirk gives a Buff or Debuff
     */
    public final boolean isPositive;
    /**
     * Shows if the current Quirk is a Disease
     */
    public final boolean isDisease;
    /**
     * Shows if the current Quirk is a mental or physical type
     */
    public final String classification;
    private final String[] incompatibleQuirks;

    /**
     * Creates a valid Quirk
     * @param id
     * @param isPositive
     * @param isDisease
     * @param classification
     * @param incompatibleQuirks
     */
    public Quirk(
            String id,
            boolean isPositive, boolean isDisease,
            String classification, String[] incompatibleQuirks
    ) {
        super(id);
        this.isPositive = isPositive;
        this.isDisease = isDisease;
        this.classification = classification;
        this.incompatibleQuirks = incompatibleQuirks;
    }

    /**
     * Gets all Quirk ids that are compatible with the current one
     * @return a List of Quirk ids
     */
    public Collection<String> getIncompatibleQuirks(){
        return Arrays.asList(this.incompatibleQuirks);
    }
}
