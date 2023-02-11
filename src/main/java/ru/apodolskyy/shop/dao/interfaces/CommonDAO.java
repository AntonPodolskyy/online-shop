package ru.apodolskyy.shop.dao.interfaces;

public interface CommonDAO <T>{

    // Get specific by ID
    T get(long id);

    // Add new
    void add(T obj);

    // Update existing
    void update(T obj);

    // Delete existing
    void delete(T obj);

}
