package com.qa.lmsproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.ModuleRepository;

@RestController
@RequestMapping("/api")
public class ModuleController {
	@Autowired
	ModuleRepository repo;
	
	
	@PostMapping("/module")
	public ModuleModel createModule(@Valid @RequestBody ModuleModel mSDM) {
		ModuleModel module = new ModuleModel(mSDM.getName(),mSDM.getDescription());
		return repo.save(module);
	}
	
	@GetMapping("/module")
	public List<ModuleModel> getAllModules(){
		return repo.findAll();
	}
	
	@DeleteMapping("/module/{id}")
	public ResponseEntity<?> deleteModule(@PathVariable(value = "id")Long moduleId){
		ModuleModel mSDM = repo.findById(moduleId).orElseThrow(()-> new ResourceNotFoundException("Module","id", moduleId));
		repo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/module/{id}")
	public ModuleModel updateModule(@PathVariable(value = "id") Long moduleId, @Valid @RequestBody ModuleModel moduleDetails) {
		
		ModuleModel mSDM = repo.findById(moduleId).orElseThrow(()-> new ResourceNotFoundException("Module","id",moduleId));
		mSDM.setName(moduleDetails.getName());
		mSDM.setDescription(moduleDetails.getDescription());
		mSDM.setApproved(moduleDetails.isApproved());
		mSDM.setLastModified();
		ModuleModel updateModule = repo.save(mSDM);
		return updateModule;
	}
}
