package com.ddsaveeditor.roster.hero;

import com.ddsaveeditor.roster.hero.quirk.HeroQuirk;
import com.ddsaveeditor.roster.hero.quirk.HeroQuirkException;
import com.ddsaveeditor.roster.hero.quirk.HeroQuirkNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public void addQuirk(String id, HeroQuirk quirk){
        if(!Objects.equals(id, quirk.getId())){
            throw new HeroQuirkException("Quirk id is not equal to param id");
        }
        if(this.hasQuirk(id)){
            throw new HeroQuirkException("Hero already have a quirk with id " + id);
        }

        this.quirks.put(id, quirk);
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
