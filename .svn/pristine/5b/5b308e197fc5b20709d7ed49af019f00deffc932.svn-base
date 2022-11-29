package com.elcom.catalog.dataservice.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.catalog.dataservice.root.DataServiceResponse;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.SICCodeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sic-code")
public class SICCodeController extends BaseController {

	private SICCodeService sicCodeService;

	@Autowired
	private SICCodeController(SICCodeService sicCodeService) {
		this.sicCodeService = sicCodeService;
	}
	
	@ApiOperation(value = "Fetches a SIC Code record from the database",
		          notes = "<p>This method fetches a SIC Code record from the database.</p>")
	@GetMapping("/{itemId}")
	public ResponseEntity<DataServiceResponse> getSICCode(@PathVariable("itemId") Long itemId) {
		
		//CompanyDTO companyDTO = companyService.getCompanyById(itemId);
		//return buildResponse(companyDTO);
		return null;
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<DataServiceResponse> searchSICCode(@Valid @RequestBody SearchCriteria searchCriteria, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(searchCriteria, bindingResult);
		}
		
		SearchResponse searchResponse = sicCodeService.searchSICCode(searchCriteria);
		return buildResponse(searchResponse);
	}
	
}
