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
import com.elcom.catalog.dataservice.root.dto.CompanyDTO;
import com.elcom.catalog.dataservice.search.model.SearchCriteria;
import com.elcom.catalog.dataservice.search.model.SearchResponse;
import com.elcom.catalog.dataservice.service.CompanyService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

	private CompanyService companyService;

	@Autowired
	private CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@ApiOperation(value = "Fetches a company record from the database",
		          notes = "<p>This method fetches a company record from the database.</p>")
	@GetMapping("/{itemId}")
	public ResponseEntity<DataServiceResponse> getCompany(@PathVariable("itemId") Long itemId) {
		
		CompanyDTO companyDTO = companyService.getCompanyById(itemId);
		return buildResponse(companyDTO);
	}
	
	@ApiOperation(value = "Persists a company record in the database",
		          notes = "<p>This method persists a company record in the database. If an id is provided the record (if found will be updated).</p>")
	@PostMapping
	public ResponseEntity<DataServiceResponse> saveCompany(@Valid @RequestBody CompanyDTO companyDTO, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(companyDTO, bindingResult);
		}
		
		try {;
			companyService.saveCompany(companyDTO);
			return buildResponse(companyDTO);
		} catch(Exception e) {
			return buildBadRequestResponse("The company record could not be saved. Error encountered: "+e.getMessage());
		}
	
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<DataServiceResponse> searchCompany(@Valid @RequestBody SearchCriteria searchCriteria, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return buildBadRequestResponse(searchCriteria, bindingResult);
		}
		
		SearchResponse searchResponse = companyService.searchCompany(searchCriteria);
		return buildResponse(searchResponse);
		
		
	}
	
}
