package com.ddsaveeditor.data;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @param <T> any type to be
 */
public class ReadonlyDataCollection<T> {
    protected final Collection<T> collection;
    /**
     *
     * @param collection
     */
    public ReadonlyDataCollection(Collection<T> collection) {
        this.collection = collection;
    }
    /**
     *
     * @return
     */
    public Stream<T> getAll(){
        return this.collection.stream();
    }
    /**
     *
     * @param predicate
     * @return
     */
    public Stream<T> get(Predicate<? super T> predicate){
        return this.collection.stream()
                .filter(predicate);
    }
    /**
     *
     * @param predicate
     * @return
     */
    public Optional<T> getFirst(Predicate<? super T> predicate){
        return this.collection.stream()
                .filter(predicate)
                .findFirst();
    }
}
