package com.models.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_currency")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "requestId", scope = UserCurrency.class)
public class UserCurrency extends UserCurrencyAbstract {

}
