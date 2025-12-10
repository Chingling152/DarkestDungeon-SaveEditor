package com.ddsaveeditor;

import com.ddsaveeditor.data.file.json.JSONFileReader;
import com.ddsaveeditor.game.data.GameDataContext;
import com.ddsaveeditor.game.data.GamePathProvider;
import com.ddsaveeditor.game.quirk.Quirk;
import com.ddsaveeditor.game.quirk.data.QuirkLibrary;
import com.ddsaveeditor.save.roster.Roster;
import com.ddsaveeditor.save.roster.hero.Hero;
import com.ddsaveeditor.save.roster.hero.quirk.HeroQuirk;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        GameDataContext dataContext = new GameDataContext(
                new JSONFileReader(new GamePathProvider("path"))
        );
        QuirkLibrary repository = new QuirkLibrary(dataContext);
        Collection<Quirk> quirks = repository.getAll();

        Quirk selectedQuirk = quirks.iterator().next();
        Roster roster = new Roster();
        Hero hero = new Hero(1);
        HeroQuirk heroQuirk = new HeroQuirk(
                selectedQuirk.id,
                true,
                false,
                selectedQuirk.getIncompatibleQuirks().toArray(new String[0])
        );
        hero.addQuirk(heroQuirk);

        roster.addHero(hero);
    }
}
