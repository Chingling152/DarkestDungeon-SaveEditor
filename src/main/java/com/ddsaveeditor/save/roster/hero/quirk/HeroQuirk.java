package com.ddsaveeditor.save.roster.hero.quirk;

import java.util.Objects;

public class HeroQuirk {
    /**
     * Quirk id used to be found and used by heroes and {@link #incompatibleQuirks}
     */
    public final String id;
    /**
     * Display name of the Quirk (It's just the id but without "_" and in CamelCase)
     */
    public final String name;

    private final String[] incompatibleQuirks;

    private final boolean isNew;
    private boolean isLocked;

    private int missionCount;
    private int replacesQuirk;
    private boolean replacesQuirkViewed;
    private int evolutionDurationRemaining;

    public HeroQuirk(
            String id,
            boolean isNew, boolean isLocked,
            String[] incompatibleQuirks
    ){
        this.id = id;

        this.name = id//TODO: improve this code or move to a mapping
                .replaceAll("_", " ")
                .replaceFirst(
                        id.substring(0,1),
                        id.substring(0,1).toUpperCase()
                );

        this.isNew = isNew;
        this.isLocked = isLocked;
        this.incompatibleQuirks = incompatibleQuirks;
    }

    public void toggleLocked(){
        this.isLocked = !this.isLocked;
    }

    /**
     * Checks if a quirk is not compatible with the current Quirk
     * @param quirk the quirk to be compared
     * @return true if the compared quirk doesn't exist in {@link #incompatibleQuirks}
     */
    public boolean isCompatible(String quirk) {
        for (String incompatibleQuirk : this.incompatibleQuirks) {
            if (Objects.equals(incompatibleQuirk, quirk))
                return false;
        }
        return true;
    }
}
