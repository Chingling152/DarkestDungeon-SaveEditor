package com.ddsaveeditor.data;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReadonlyDataCollection<T> {
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

    public Optional<T> getFirst(Predicate<? super T> predicate){
        return this.collection.stream()
                .filter(predicate)
                .findFirst();
    }
}
