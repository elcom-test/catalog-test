package com.elcom.catalog.dataservice.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.catalog.dataservice.root.DataServiceResponse;
import com.elcom.catalog.dataservice.root.dto.CatalogDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemAttributeDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDTO;
import com.elcom.catalog.dataservice.root.dto.CatalogItemPriceDetachedDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.CatalogItemAttributeService;
import com.elcom.catalog.dataservice.service.CatalogItemPriceService;
import com.elcom.catalog.dataservice.service.CatalogItemService;
import com.elcom.catalog.dataservice.service.CatalogService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/catalog")
public class CatalogController extends BaseController {

	private CatalogService catalogService;

	private CatalogItemService catalogItemService;
	
	private CatalogItemPriceService catalogItemPriceService;
	
	private CatalogItemAttributeService catalogItemAttributeService;
	
	

	@Autowired
	private CatalogController(CatalogService catalogService,
							  CatalogItemService catalogItemService,
							  CatalogItemPriceService catalogItemPriceService,  
							  CatalogItemAttributeService catalogItemAttributeService) 
	{
		this.catalogService = catalogService;
		this.catalogItemService=catalogItemService;
		this.catalogItemPriceService=catalogItemPriceService;
		this.catalogItemAttributeService = catalogItemAttributeService;
	}



	@ApiOperation(value = "Fetches a master catalog from the database",
			notes = "<p>This method fetches a master catalog from the database.</p>")
	@GetMapping("/{catId}")
	public ResponseEntity<DataServiceResponse> getItem(@PathVariable("catId") Long catId) {

		Optional<CatalogDTO> item = catalogService.getCatalogById(catId);

		return buildResponse(item);
	}


	@ApiOperation(value = "Persists a master product catalog in the database",
			notes = "<p>This method persists a master catalog in the database. If an id is provided the record (if found will be updated).</p>")
	@PostMapping
	public ResponseEntity<DataServiceResponse> saveItem(@Valid @RequestBody CatalogDTO catalogDTO, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(catalogDTO, bindingResult);
		}

		try {
			catalogService.saveCatalog(catalogDTO);
		} catch(Exception e) {
			return buildBadRequestResponse("The catalog record could not be saved. Error encountered: "+e.getMessage());
		}

		return buildResponse(catalogDTO);

	}


	@ApiOperation(value = "Toggles the status of a master catalog",
			notes = "<p>This method toggles the status of a master catalog - this can be used as a shortcut to enable / disable catalogs.</p>")
	@GetMapping("/toggle-status/{catalogId}")
	public ResponseEntity<DataServiceResponse> toggleStatus(@PathVariable("catalogId") Long catalogId) {

		CatalogDTO catalogDTO = catalogService.togglecatalogActiveStatus(catalogId);
		return buildResponse(catalogDTO);
	}

	@ApiOperation(value = "Removes a master catalog from the database",
			notes = "<p>This method removes a catalog from the database. An id is the only attribute required in the request json.</p>")
	@DeleteMapping("/delete/{catalogId}")
	public ResponseEntity<DataServiceResponse> deleteCatalog(@RequestBody CatalogDTO catalogDTO) {
		catalogService.deleteCatalog(catalogDTO);
		return buildResponse(catalogDTO);
	}


	@ApiOperation(value = "Searches for a master catalog",
			notes = "<p>This method searches a master catalog - it uses different properties as search criteria.</p>")
	@PostMapping("/search")
	public ResponseEntity<DataServiceResponse> searchCatalog(@Valid @RequestBody SearchCriteria searchCriteria, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(searchCriteria, bindingResult);
		}

		SearchResponse searchResponse = catalogService.searchCatalog(searchCriteria);
		return buildResponse(searchResponse);
	}


	@ApiOperation(value = "Provides a means to add, update and remove individual catalog items.",
			notes = "<p>This method provides a means of adding, updating and removing individual catalogitems.</p>")
	@PostMapping("/{action}/item")
	public ResponseEntity<DataServiceResponse> addRemoveCatalogItem(@Valid @RequestBody CatalogItemDetachedDTO catalogItem,
			BindingResult bindingResult,
			@PathVariable("action") String action) {

		CatalogItemDTO catalogItemDTO = null;

		if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
			return buildBadRequestResponse(catalogItem, bindingResult);
		}

		try {
			switch(action) {
			case ADD_OPERATION    -> catalogItemDTO = catalogItemService.saveDetachedCatalogItem(catalogItem);
			case DELETE_OPERATION -> {
				catalogItemService.deleteCatalogItem(catalogItem.getId());
				return buildResponse("Catalog Item successfully deleted");
			}
			default -> {
				return buildBadRequestResponse("invalid action - valid values are add or delete");
			}
			}
		} catch(Exception e) {
			return buildBadRequestResponse("The Catalog Item could not be saved. Error encountered: "+e.getMessage());
		}

		return buildResponse(catalogItemDTO);
	}


	
	@ApiOperation(value = "Provides a means to add, update and remove individual catalog item prices.",
			notes = "<p>This method provides a means of adding, updating and removing individual catalog item prices.</p>")
	@PostMapping("/{action}/item-price")
	public ResponseEntity<DataServiceResponse> addRemoveCatalogItemPrice(@Valid @RequestBody CatalogItemPriceDetachedDTO catalogItemPrice,
			BindingResult bindingResult,
			@PathVariable("action") String action) {

		CatalogItemPriceDTO catalogItemPriceDTO = null;

		if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
			return buildBadRequestResponse(catalogItemPrice, bindingResult);
		}

		try {
			switch(action) {
			case ADD_OPERATION    -> catalogItemPriceDTO = catalogItemPriceService.saveDetachedCatalogItemPrice(catalogItemPrice);
			case DELETE_OPERATION -> {
				catalogItemPriceService.deleteCatalogItemPrice(catalogItemPrice.getId());
				return buildResponse("Catalog Item Price successfully deleted");
			}
			default -> {
				return buildBadRequestResponse("invalid action - valid values are add or delete");
			}
			}
		} catch(Exception e) {
			return buildBadRequestResponse("The Catalog Item could not be saved. Error encountered: "+e.getMessage());
		}

		return buildResponse(catalogItemPriceDTO);
	}
	
	@ApiOperation(value = "Provides a means to add, update and remove individual catalog item attributes.",
			notes = "<p>This method provides a means of adding, updating and removing individual catalog item attributes.</p>")
	@PostMapping("/{action}/item-attribute")
	public ResponseEntity<DataServiceResponse> addRemoveCatalogItemAttribute(@Valid @RequestBody CatalogItemAttributeDetachedDTO catalogItemAttribute,
			BindingResult bindingResult,
			@PathVariable("action") String action) {

		CatalogItemAttributeDTO catalogItemAttributeDTO = null;

		if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
			return buildBadRequestResponse(catalogItemAttribute, bindingResult);
		}

		try {
			
			switch(action) {
			case ADD_OPERATION    -> catalogItemAttributeDTO = catalogItemAttributeService.saveDetachedCatalogItemAttribute(catalogItemAttribute);
			case DELETE_OPERATION -> {
				catalogItemAttributeService.deleteCatalogItemAttribute(catalogItemAttribute.getId());
				return buildResponse("Catalog Item Attribuite successfully deleted");
			}
			default -> {
				return buildBadRequestResponse("invalid action - valid values are add or delete");
			}
			}
		} catch(Exception e) {
			return buildBadRequestResponse("The Catalog Item could not be saved. Error encountered: "+e.getMessage());
		}

		return buildResponse(catalogItemAttributeDTO);
	}
	
}
