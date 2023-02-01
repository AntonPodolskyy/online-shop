package ru.apodolskyy.shop.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apodolskyy.shop.interfaces.ICustomer;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements ICustomer {
    // TODO переменные лучше делать private (в других классах тоже)

    public String name;
    public String surname;

}
