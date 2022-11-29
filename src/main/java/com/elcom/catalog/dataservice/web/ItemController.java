package com.elcom.catalog.dataservice.web;

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
import com.elcom.catalog.dataservice.root.dto.ItemAssetDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAssetDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemAttributeDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDTO;
import com.elcom.catalog.dataservice.root.dto.ItemBarcodeDetachedDTO;
import com.elcom.catalog.dataservice.root.dto.ItemDTO;
import com.elcom.catalog.dataservice.root.dto.ItemTaxonomyDTO;
import com.elcom.catalog.dataservice.root.dto.ItemTaxonomyDetachedDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.ItemAssetService;
import com.elcom.catalog.dataservice.service.ItemAttributeService;
import com.elcom.catalog.dataservice.service.ItemBarcodeService;
import com.elcom.catalog.dataservice.service.ItemService;
import com.elcom.catalog.dataservice.service.ItemTaxonomyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController {

	private ItemService itemService;
	private ItemAttributeService itemAttributeService;
	private ItemAssetService itemAssetService;
	private ItemBarcodeService itemBarcodeService;
	private ItemTaxonomyService itemTaxonomyService;

	@Autowired
	private ItemController(ItemService itemService, ItemAttributeService itemAttributeService, ItemAssetService itemAssetService,
						   ItemBarcodeService itemBarcodeService, ItemTaxonomyService itemTaxonomyService) {
		this.itemService = itemService;
		this.itemAttributeService = itemAttributeService;
		this.itemAssetService = itemAssetService;
		this.itemBarcodeService = itemBarcodeService;
		this.itemTaxonomyService = itemTaxonomyService;
	}
	
	@ApiOperation(value = "Fetches a master product record (item) from the database",
 			      notes = "<p>This method fetches a master product record (item) from the database.</p>")
	@GetMapping("/{itemId}")
	public ResponseEntity<DataServiceResponse> getItem(@PathVariable("itemId") Long itemId) {
		
		ItemDTO itemDTO = itemService.getItemById(itemId);
		return buildResponse(itemDTO);
	}

	@ApiOperation(value = "Toggles the status of a master product record (item)",
		          notes = "<p>This method toggles the status of a master product record (item) - this can be used as a shortcut to enable / disable items.</p>")
	@GetMapping("/toggle-status/{itemId}")
	public ResponseEntity<DataServiceResponse> toggleStatus(@PathVariable("itemId") Long itemId) {
		
		ItemDTO itemDTO = itemService.toggleItemActiveStatus(itemId);
		return buildResponse(itemDTO);
	}
	
	@ApiOperation(value = "Persists a master product record (item) in the database",
	              notes = "<p>This method persists a master product record (item) in the database. If an id is provided the record (if found will be updated).</p>")
	@PostMapping("/")
	public ResponseEntity<DataServiceResponse> saveItem(@Valid @RequestBody ItemDTO itemDTO, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(itemDTO, bindingResult);
		}
		
		try {
			itemService.saveItem(itemDTO);
			return buildResponse(itemDTO);
		} catch(Exception e) {
			return buildBadRequestResponse("The item could not be saved. Error encountered: "+e.getMessage());
		}
	}
	
	@ApiOperation(value = "Removes a master product record (item) from the database",
                  notes = "<p>This method removes a master product record (item) from the database. An id is the only attribute required in the request json.</p>")
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<DataServiceResponse> deleteItem(@RequestBody ItemDTO itemDTO) {
		
		itemService.deleteItem(itemDTO);
		return buildResponse(itemDTO);
	}
	
	@ApiOperation(value = "Searches the master product record and returns matches.",
                  notes = "<p>This method provides a means to search on the master product record and return matches made.</p>")
	@PostMapping("/search")
	public ResponseEntity<DataServiceResponse> searchSICCode(@Valid @RequestBody SearchCriteria searchCriteria, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(searchCriteria, bindingResult);
		}
		
		SearchResponse searchResponse = itemService.searchItems(searchCriteria);
		return buildResponse(searchResponse);
	}
	
	@ApiOperation(value = "Provides a means to add, update and remove individual item attributes.",
                  notes = "<p>This method provides a means of adding, updating and removing individual item attributes.</p>")
	@PostMapping("/{action}/attribute")
	public ResponseEntity<DataServiceResponse> addRemoveItemAttribute(@Valid @RequestBody ItemAttributeDetachedDTO itemAttribute,
																	  BindingResult bindingResult,
																	  @PathVariable("action") String action) {
		
		ItemAttributeDTO itemAttributeDTO = null;
		
		if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
			return buildBadRequestResponse(itemAttribute, bindingResult);
		}
		
		try {
			switch(action) {
				case ADD_OPERATION    -> itemAttributeDTO = itemAttributeService.saveDetachedItemAttribute(itemAttribute);
				case DELETE_OPERATION -> {
					itemAttributeService.deleteItemAttribute(itemAttribute.getId());
					return buildResponse("Item attribute successfully deleted");
					}
				default -> {
					return buildBadRequestResponse("invalid action - valid values are add or delete");
				}
			}
		} catch(Exception e) {
			return buildBadRequestResponse("The item attributed could not be saved. Error encountered: "+e.getMessage());
		}
		
		return buildResponse(itemAttributeDTO);
	}

	@ApiOperation(value = "Provides a means to add, update and remove individual item assets.",
                  notes = "<p>This method provides a means of adding, updating and removing individual item assets.</p>")
	@PostMapping("/{action}/asset")
	public ResponseEntity<DataServiceResponse> addRemoveItemAsset(@Valid @RequestBody ItemAssetDetachedDTO itemAsset,
																  BindingResult bindingResult,													  
																  @PathVariable("action") String action) {
		
		ItemAssetDTO itemAssetDTO = null;
		
		if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
			return buildBadRequestResponse(itemAsset, bindingResult);
		}
		
		try {
			switch(action) {
				case ADD_OPERATION    -> itemAssetDTO = itemAssetService.saveDetachedItemAsset(itemAsset);
				case DELETE_OPERATION -> {
					itemAssetService.deleteItemAsset(itemAsset.getId());
					return buildResponse("Item asset successfully deleted");
					}
				default -> {
					return buildBadRequestResponse("invalid action - valid values are add or delete");
				}
			}
		} catch(Exception e) {
			return buildBadRequestResponse("The item asset could not be saved. Error encountered: "+e.getMessage());
		}
		
		return buildResponse(itemAssetDTO);
	}
	
	@ApiOperation(value = "Provides a means to add, update and remove individual item barcodes.",
            	  notes = "<p>This method provides a means of adding, updating and removing individual item barcodes.</p>")
	@PostMapping("/{action}/barcode")
	public ResponseEntity<DataServiceResponse> addRemoveItemBarcode(@Valid @RequestBody ItemBarcodeDetachedDTO itemBarcode,
																	BindingResult bindingResult,
																	@PathVariable("action") String action) {
	
	ItemBarcodeDTO itemBarcodeDTO = null;
	
	if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
		return buildBadRequestResponse(itemBarcode, bindingResult);
	}
	
	try {
		switch(action) {
			case ADD_OPERATION    -> itemBarcodeDTO = itemBarcodeService.saveDetachedItemBarcode(itemBarcode);
			case DELETE_OPERATION -> {
				itemBarcodeService.deleteItemBarcode(itemBarcode.getId());
				return buildResponse("Item barcode successfully deleted");
				}
			default -> {
				return buildBadRequestResponse("invalid action - valid values are add or delete");
			}
		}
	} catch(Exception e) {
		return buildBadRequestResponse("The item barcode could not be saved. Error encountered: "+e.getMessage());
	}
	
	return buildResponse(itemBarcodeDTO);
	}
	
	@ApiOperation(value = "Provides a means to add, update and remove individual item taxonomies.",
				  notes = "<p>This method provides a means of adding, updating and removing individual item taxonomies.</p>")
	@PostMapping("/{action}/taxonomy")
	public ResponseEntity<DataServiceResponse> addRemoveItemTaxonomy(@Valid @RequestBody ItemTaxonomyDetachedDTO itemTaxonomy,
																	 BindingResult bindingResult,
																	 @PathVariable("action") String action) {
	
	ItemTaxonomyDTO itemTaxonomyDTO = null;
	
	if (bindingResult.hasErrors() && !DELETE_OPERATION.equalsIgnoreCase(action)) {
		return buildBadRequestResponse(itemTaxonomy, bindingResult);
	}
	
	try {
		switch(action) {
			case ADD_OPERATION    -> itemTaxonomyDTO = itemTaxonomyService.saveDetachedItemTaxonomy(itemTaxonomy);
			case DELETE_OPERATION -> {
				itemTaxonomyService.deleteItemTaxonomy(itemTaxonomy.getId());
				return buildResponse("Item taxonomy successfully deleted");
				}
			default -> {
				return buildBadRequestResponse("invalid action - valid values are add or delete");
			}
		}
	} catch(Exception e) {
		return buildBadRequestResponse("The item taxonomy could not be saved. Error encountered: "+e.getMessage());
	}
	
	return buildResponse(itemTaxonomyDTO);
	}
	
	
}
