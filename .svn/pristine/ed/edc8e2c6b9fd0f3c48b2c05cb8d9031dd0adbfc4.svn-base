package com.elcom.catalog.dataservice.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.catalog.dataservice.root.CatalogItem;
import com.elcom.catalog.dataservice.root.DataServiceResponse;
import com.elcom.catalog.dataservice.service.CatalogItemService;
import com.elcom.catalog.dataservice.service.CatalogService;
@RestController
@RequestMapping("/catalogItem")
public class CatalogItemController extends BaseController{
	
	
	private CatalogItemService catalogItemService;
	

	@Autowired
	private CatalogItemController(CatalogItemService catalogItemService) {
		this.catalogItemService = catalogItemService;
	}
	
	
	@GetMapping("/{catId}")
	public ResponseEntity<DataServiceResponse> getCatItem(@PathVariable("catId") Long catId) {
		
		Optional<CatalogItem> item = catalogItemService.getCatalogItemById(catId);
	
		return buildResponse(item);
	}
	
	
	


}
