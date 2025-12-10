package com.ddsaveeditor.save.roster;

import com.ddsaveeditor.save.roster.hero.Hero;

import java.util.HashMap;

public class Roster {
    private final HashMap<String, Hero> heroes;
    public Roster(){
        this.heroes = new HashMap<>();
    }

    public boolean containsHero(String heroId){
        return this.heroes.containsKey(heroId);
    }

    public Hero getHero(String id){
        return this.heroes.getOrDefault(id, null);
    }

    public void addHero(Hero hero){
        String id = String.valueOf(hero.getId());
        if(this.containsHero(id)){
            throw new Error();
        }

        this.heroes.put(id, hero);
    }

    public void updateHero(Hero hero){
        String id = String.valueOf(hero.getId());
        if(!this.containsHero(id)){
            throw new Error();
        }

        this.heroes.put(id, hero);
    }
}
