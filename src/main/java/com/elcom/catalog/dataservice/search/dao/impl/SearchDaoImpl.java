package com.elcom.catalog.dataservice.search.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.engine.spi.FacetManager;
import org.hibernate.search.query.facet.Facet;
import org.hibernate.search.query.facet.FacetSortOrder;
import org.hibernate.search.query.facet.FacetingRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Repository;

import com.elcom.catalog.dataservice.search.dao.SearchDao;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchFacet;
import com.elcom.catalog.dataservice.search.model.SearchResponse;

@Repository("searchDao")
public class SearchDaoImpl implements SearchDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public SearchResponse search(SearchCriteria searchCriteria) {
		SearchResponse response = new SearchResponse();
		
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory() 
				  .buildQueryBuilder()
				  .forEntity(searchCriteria.getObjectToSearch())
				  .get();

		org.apache.lucene.search.Query queryB = queryBuilder
				  .simpleQueryString()
				  .onFields(searchCriteria.getFieldToSearch(), searchCriteria.getAdditionalFieldsToSearch())
				  .matching(searchCriteria.getSearchString())
				  .createQuery();
		
		org.hibernate.search.jpa.FullTextQuery query = fullTextEntityManager.createFullTextQuery(queryB, searchCriteria.getObjectToSearch())
																			.setFirstResult(searchCriteria.getIndexStart())
																			.setMaxResults(searchCriteria.getNumRecords());
		@SuppressWarnings("unchecked")
		List<?> results = mapList(query.getResultList(), searchCriteria.getObjectToReturn());
				
		response.setMatchedRecords(results);
		response.setNumMatches(query.getResultSize());
		
		// add facets if requested
		if (searchCriteria.getSearchFacets() != null) {
			response.setFacets(searchFacet(searchCriteria));
		}
		return response;
	}

	
	private Map<String, List<SearchFacet>> searchFacet(SearchCriteria searchCriteria) {
		String searchString = searchCriteria.getSearchString();

		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory() 
				  .buildQueryBuilder()
				  .forEntity(searchCriteria.getObjectToSearch())
				  .get();
		
		Map<String, List<SearchFacet>> facets = new HashMap();
		
		for (String facet : searchCriteria.getSearchFacets()) {
		
			FacetingRequest postedAtFR = queryBuilder.facet()
			      .name(facet)
			      .onField(facet)
			      .discrete()
			      .orderedBy(FacetSortOrder.COUNT_DESC)
			      .includeZeroCounts(false)
			      .maxFacetCount(20)
			      .createFacetingRequest(); 
			
			org.apache.lucene.search.Query query = queryBuilder
					  .simpleQueryString()
					  .onFields(searchCriteria.getFieldToSearch(), searchCriteria.getAdditionalFieldsToSearch())
					  .matching(searchString)
					  .createQuery();
			
			org.hibernate.search.jpa.FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, searchCriteria.getObjectToSearch());
			
			FacetManager facetMgr = fullTextQuery.getFacetManager();
			facetMgr.enableFaceting(postedAtFR);
			List<Facet> facetResults = facetMgr.getFacets(facet);
		
			List<SearchFacet> searchFacets = facetResults.stream()
														 .map(fr -> SearchFacet.builder()
																			   .key(fr.getValue())
																			   .count(fr.getCount())
																			   .build())
														 .collect(Collectors.toList());
			facets.put(facet,searchFacets);
		}
		
		return facets;
	}
	
	private <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}

	@Override
	public Integer findTotal() {
		// TODO Auto-generated method stub
		return null;
	}

}
