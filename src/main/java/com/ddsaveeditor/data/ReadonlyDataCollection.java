package com.ddsaveeditor.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @param <T> A class that extends {@link DataEntity}
 */
public class ReadonlyDataCollection<T extends DataEntity> {
    protected final Collection<T> collection;

    public ReadonlyDataCollection(Collection<T> collection) {
        this.collection = collection;
    }

    public Stream<T> getAll(){
        return this.collection.stream();
    }

    public Stream<T> get(Predicate<? super T> predicate){
        return this.collection.stream()
                .filter(predicate);
    }

    public Optional<T> getById(String id){
        return this.collection.stream()
                .filter(item -> Objects.equals(item.id, id))
                .findFirst();
    }

    public Stream<T> getByIds(String... ids){
        return this.collection.stream()
                .filter(item -> Arrays.asList(ids).contains(item.id));
    }
}
