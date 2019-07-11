package com.louis.home.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.home.controller.model.ModuleDTO;
import com.louis.home.controller.model.Response;
import com.louis.home.repository.entity.Module;
import com.louis.home.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/home")
public class HomeController {

  @Autowired
  private UserService userService;

  @Autowired
  private ObjectMapper objectMapper;

  @RequestMapping(value = "/category", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
  public Response category(@RequestParam (required = true, name = "UserID") String userId){

    List<Module> moduleList = this.userService.getListOfModule(userId);
    AtomicInteger atomicInteger = new AtomicInteger(1);

    List<ModuleDTO> moduleDTOList = moduleList.stream()
        .map(module -> {
          ModuleDTO moduleDTO=new ModuleDTO();
          moduleDTO.setModuleOrder(""+atomicInteger.getAndIncrement());
          BeanUtils.copyProperties(module, moduleDTO);
          return moduleDTO;
        })
        .collect(Collectors.toList());

    return Response.builder()
        .email(userId)
        .modules(moduleDTOList)
        .build();
  }
}
