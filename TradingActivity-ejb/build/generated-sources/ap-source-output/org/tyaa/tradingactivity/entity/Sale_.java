package org.tyaa.tradingactivity.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.tyaa.tradingactivity.entity.Broker;
import org.tyaa.tradingactivity.entity.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-06T19:55:15")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, String> securityName;
    public static volatile SingularAttribute<Sale, Broker> brokerId;
    public static volatile SingularAttribute<Sale, Integer> quantity;
    public static volatile SingularAttribute<Sale, Integer> price;
    public static volatile SingularAttribute<Sale, Integer> id;
    public static volatile SingularAttribute<Sale, Category> categoryId;

}