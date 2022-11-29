package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.elcom.catalog.dataservice.root.TaxTypes;

public interface TaxTypesService {

    Set<TaxTypes> getDefaultTaxTypes();
    Optional<TaxTypes> getTaxTypeByPercentage(long percentage);
    Optional<TaxTypes> getTaxTypeByTaxTypeKey(String taxTypeKey);
    Optional<TaxTypes> getTaxTypeByTaxTypeId(Long taxTypeId);
    TaxTypes saveTaxType(TaxTypes taxType);
    List<TaxTypes> getAllTaxTypes();
    void deleteTaxType(TaxTypes taxType);
}
