package org.tyaa.tradingactivity.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.tyaa.tradingactivity.entity.Sale;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-06T19:55:15")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Integer> id;
    public static volatile CollectionAttribute<Category, Sale> saleCollection;

}