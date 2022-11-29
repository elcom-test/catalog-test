package com.elcom.catalog.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.catalog.dataservice.root.Catalog;
@Repository
@Transactional
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

}
