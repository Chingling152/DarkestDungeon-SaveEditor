package com.ddsaveeditor.game.quirk.data;

import com.ddsaveeditor.game.quirk.Quirk;

import java.util.Collection;
import java.util.Optional;

/**
 * Interface to retrieve {@link Quirk} data
 */
public interface IQuirkLibrary {
    /**
     * @return all {@link Quirk}s existent
     */
    Collection<Quirk> getAll();
    /**
     * Gets a {@link Quirk} by its id
     * @param id id to be searched
     * @return one {@link Quirk} or null if not found
     */
    Optional<Quirk> get(String id);
    /**
     * @param ids a collection of string ids of {@link Quirk}s to be searched
     * @return All found items that contains at least one of the ids from {@code ids}
     */
    Collection<Quirk> get(String ...ids);
    /**
     * @return All {@link Quirk}s that have the field {@link Quirk#isDisease} with the value {@code true}
     */
    Collection<Quirk> getDiseases();
    /**
     * @return All {@link Quirk}s that have the field {@link Quirk#isPositive} with the value {@code false}
     */
    Collection<Quirk> getNegatives();
    /**
     * @return All {@link Quirk}s that have the field {@link Quirk#isPositive} with the value {@code true}
     */
    Collection<Quirk> getPositives();
    /**
     * @param id id of the quirk to be compared
     * @return One or more {@link Quirk} that is not compatible with the one from param
     */
    Collection<Quirk> getIncompatiblesWith(String id);
}