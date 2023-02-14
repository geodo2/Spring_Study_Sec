package com.example.test_project_sec.controller;

import com.example.test_project_sec.data.entity.ListenerEntity;
import com.example.test_project_sec.data.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listener")
public class ListenerController {

  private ListenerService listenerService;

  @Autowired
  public ListenerController(ListenerService listenerService){
    this.listenerService = listenerService;
  }

  @GetMapping
  public String getListener(Long id){
    listenerService.getEntity(id);

    return "OK";
  }

  @PostMapping
  public void saveListener(String name){
    ListenerEntity listener = new ListenerEntity();
    listener.setName(name);

    listenerService.saveEntity(listener);
  }

  @PutMapping
  public void updateListener(Long id, String name){
    ListenerEntity listener = new ListenerEntity();
    listener.setId(id);
    listener.setName(name);

    listenerService.updateEntity(listener);
  }

  @DeleteMapping
  public void deleteListener(Long id){
    ListenerEntity listener = listenerService.getEntity(id);

    listenerService.removeEntity(listener);
  }

}