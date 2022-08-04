package com.andurasoftware.alexandria.business.common.interfaces;

public abstract class BaseAggregate<T extends State> implements Aggregate<T> {
    protected T state;

    public BaseAggregate(T state) {
        this.state = state;
    }

    public T getState() { return this.state; }
}
