package com.uespeis.service_impl;

import com.uespeis.model.Resources;
import com.uespeis.repository.ResourceRepository;
import com.uespeis.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService{

  @Autowired
  private ResourceRepository repository;
  
  public Resources save(Resources resource){
   return repository.save(resource);
  }

}