package com.elcom.catalog.dataservice.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.catalog.dataservice.root.TaxTypes;

@Repository
@Transactional
public interface TaxTypesRepository extends JpaRepository<TaxTypes, Long> {

    @Query("SELECT taxType FROM TaxTypes taxType ")
    public Set<TaxTypes> getDefaultTaxTypes();

    @Query("SELECT taxType FROM TaxTypes taxType WHERE taxType.percentage = ?1 ")
    public Optional<TaxTypes> getTaxTypeByPercentage(long percentage);
    
    @Query("SELECT taxType FROM TaxTypes taxType WHERE taxType.key = ?1")
    public Optional<TaxTypes> getTaxTypeByTaxTypeKey(String taxTypeKey);

}
