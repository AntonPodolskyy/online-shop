package ru.apodolskyy.shop.dao.interfaces;

import java.util.List;

public interface FindDAO<T> {

    // Get all items
    List<T> findAll();

    // Get by specific string
    List<T> findAll(String findParameter);

}
