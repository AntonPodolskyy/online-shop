package ru.apodolskyy.shop.dao.interfaces.objects;

import ru.apodolskyy.shop.dao.interfaces.FindDAO;
import ru.apodolskyy.shop.entity.CustomerRole;

public interface CustomerRoleDAO extends FindDAO<CustomerRole> {

    // Get specific by ID
    CustomerRole get(long id);

    // Update existing
    void update(CustomerRole obj);

}
