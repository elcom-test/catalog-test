package com.elcom.catalog.dataservice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BuildSearchIndex implements ApplicationListener<ApplicationReadyEvent> {
  
	@PersistenceContext
	private EntityManager entityManager;
  
	@Value("${rebuild.search.index:false}")
	private Boolean rebuildSearchIndex;
  
	/**
	 * Create an initial Lucene index for the data already present in the database.
	 * This method is called after the application has started up AND only if the rebuild search index property is set.
	 */
	@Transactional
	public void onApplicationEvent(final ApplicationReadyEvent event) {
    
		if (!getRebuildSearchIndex()) {
			return;
		}
	  
		try {
			FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
			fullTextEntityManager.createIndexer().startAndWait();
		}
		catch (InterruptedException e) {
			System.out.println("An error occurred trying to build the serach index: " + e.toString());
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	  
		return;
	}

}