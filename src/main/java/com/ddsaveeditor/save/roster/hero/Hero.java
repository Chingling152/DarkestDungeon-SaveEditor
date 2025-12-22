package com.ddsaveeditor.save.roster.hero;

import com.ddsaveeditor.save.roster.hero.quirk.HeroQuirk;
import com.ddsaveeditor.save.roster.hero.quirk.HeroQuirkException;
import com.ddsaveeditor.save.roster.hero.quirk.HeroQuirkIncompatibleException;
import com.ddsaveeditor.save.roster.hero.quirk.HeroQuirkNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Hero {
    private final int id;
    //private final Actor actor;
    //private final State state;

    //HashedString heroClass; //TODO: Add HashedString (maybe change to an enum)
    //private final Map<Integer, Trinket> trinkets;
    private final Map<String, HeroQuirk> quirks;
    private final Equipment equipment;

    public Hero(int id) {
        this.id = id;
        this.equipment = new Equipment(0, 0);
        this.quirks = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void changeWeapon(int weaponRank){
        this.equipment.setWeaponRank(weaponRank);
    }

    public void changeArmor(int armorRank){
        this.equipment.setMaxArmourRank(armorRank);
    }

    public void changeEquipment(int armorRank, int weaponRank)
    {
        this.equipment.setMaxArmourRank(armorRank);
        this.equipment.setWeaponRank(weaponRank);
    }

    public Collection<HeroQuirk> getQuirks(){
        return this.quirks.values();
    }

    public void addQuirk(HeroQuirk quirk){
        if(this.hasQuirk(quirk.id)){
            throw new HeroQuirkException("Hero already have a quirk with id " + id);
        }

        for (HeroQuirk currentQuirk : this.quirks.values()) {
            if(!currentQuirk.isCompatible(quirk.id)) {
                throw new HeroQuirkIncompatibleException(
                        "The Quirk " + quirk.name + " is not compatible with the current quirk" + currentQuirk.name
                );
            }
        }

        this.quirks.put(quirk.id, quirk);
    }

    public boolean hasQuirk(String id){
        return this.quirks.containsKey(id);
    }

    public void toggleLockQuirk(String id){
        if(!this.hasQuirk(id)){
            throw new HeroQuirkNotFoundException("The hero doesn't have the Quirk " + id);
        }

        HeroQuirk quirk = this.quirks.get(id);
        quirk.toggleLocked();
    }

    public void removeQuirk(String id){
        if(!this.hasQuirk(id)){
            throw new HeroQuirkNotFoundException("The hero doesn't have the Quirk " + id);
        }

        this.quirks.remove(id);
    }
}
