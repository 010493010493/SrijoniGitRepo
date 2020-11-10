package com.ibm.currencyconvertservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.currencyconvertservices.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
