package com.ddsaveeditor.data;

import java.util.Collection;

public class DataCollection<T> extends ReadonlyDataCollection<T>{
    public DataCollection(Collection<T> collection){
        super(collection);
    }
    //TODO: update/add
    public void add(T item){
        this.collection.add(item);
    }
}
