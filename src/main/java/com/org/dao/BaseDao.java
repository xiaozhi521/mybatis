package com.org.dao;

public interface BaseDao<T,P> {

    public P byId(T id);


}
