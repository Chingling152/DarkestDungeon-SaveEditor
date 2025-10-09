package com.ddsaveeditor.roster.hero.quirk;

import java.util.Objects;

public class HeroQuirk {
    private String id;
    private boolean isNew;
    private boolean isLocked;
    private int missionCount;
    private int replacesQuirk;
    private boolean replacesQuirkViewed;
    private int evolutionDurationRemaining;

    private final String counterQuirk;

    public HeroQuirk(String id, boolean isNew, boolean isLocked, String counterQuirk){
        this.id = id;
        this.isNew = isNew;
        this.isLocked = isLocked;
        this.counterQuirk = counterQuirk;
    }

    public HeroQuirk(String id,boolean isNew, boolean isLocked){
        this(id,isNew, isLocked, null);
    }

    public boolean isCompatible(String counterQuirk){
        return !Objects.equals(this.counterQuirk, counterQuirk);
    }
    public String getId(){
        return this.id;
    }
    public void toggleLocked(){
        this.isLocked = !this.isLocked;
    }
}
