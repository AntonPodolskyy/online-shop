package ru.apodolskyy.shop.dao.interfaces.objects;

import ru.apodolskyy.shop.dao.interfaces.CommonDAO;
import ru.apodolskyy.shop.dao.interfaces.FindDAO;
import ru.apodolskyy.shop.entity.Purchase;

public interface PurchaseDAO extends CommonDAO<Purchase>, FindDAO<Purchase> {

}
