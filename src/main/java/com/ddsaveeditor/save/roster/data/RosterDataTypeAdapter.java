package com.ddsaveeditor.save.roster.data;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;

import static com.ddsaveeditor.data.file.json.util.JSONReaderUtil.nextArray;

public class RosterDataTypeAdapter extends TypeAdapter<RosterData> {
    /**
     *
     * @param out
     * @param value
     * @throws IOException
     */
    @Override
    public void write(JsonWriter out, RosterData value) throws IOException {
        out.beginObject();

        out.name("base_root").beginObject();

        out.name("version").value(value.version);
        out.name("nextGuid").value(value.nextGuid);
        out.name("dismissed_hero_count").value(value.dismissedHeroCount);
        out.name("highest_resolve_xp").value(value.highestResolveXp);
        out.name("last_party").beginObject();
        out.name("last_party_guids").beginArray();
        for (String partyId: value.lastParty.lastPartyGuids){
            out.value(partyId);
        }
        out.endArray();
        out.endObject();
        // TODO: add heroes

        out.endObject();

        out.endObject();
    }

    /**
     *
     * @param in
     * @return
     * @throws IOException
     */
    @Override
    public RosterData read(JsonReader in) throws IOException {
        RosterData rosterData = new RosterData();
        in.beginObject();

        in.nextName(); // enter "base_root"
        in.beginObject();
        while (in.peek() != JsonToken.END_OBJECT) {
            String name = in.nextName();
            switch (name){
                case "version":
                    rosterData.version = in.nextString();
                    break;
                case "nextGuid":
                    rosterData.nextGuid = in.nextString();
                    break;
                case "dismissed_hero_count":
                    rosterData.dismissedHeroCount = in.nextInt();
                    break;
                case "highest_resolve_xp":
                    rosterData.highestResolveXp = in.nextDouble();
                    break;
                case "last_party":
                {
                    in.beginObject();
                    in.nextName();// last_party_guids

                    String[] partyIds = nextArray(in,String.class).toArray(new String[0]);

                    in.endObject();

                    rosterData.lastParty = new RosterData.RosterLastPartyData(partyIds);
                    break;
                }
                case "heroes":
                    in.skipValue();
                    rosterData.heroes = new HashMap<>();
                    break;
                default:
                    throw new IllegalStateException("Unexpected name: " + name);
            }
        }
        in.endObject();

        in.endObject();
        return rosterData;
    }
}
