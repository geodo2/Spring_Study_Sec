package com.example.test_project_sec.controller;

import com.example.test_project_sec.data.dto.ShortUrlResponseDTO;
import com.example.test_project_sec.data.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("short-url")
//http://localhost:8080/short-url
public class ShortUrlController {
  private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);


  @Value("${demo.short.url.id}")
  private String CLIENT_ID;

  @Value("${demo.short.url.secret}")
  private String CLIENT_SECRET;

  ShortUrlService shortUrlService;

  @Autowired
  public ShortUrlController(ShortUrlService shortUrlService){
    this.shortUrlService = shortUrlService;
  }

  @PostMapping()
  public ShortUrlResponseDTO generateShortUrl(@RequestBody String originalUrl){
    LOGGER.info("[generateShortUrl] perform API CLIENT_ID : {}, CLIENT_SECRET : {}, originalUrl: {}", CLIENT_ID, CLIENT_SECRET,originalUrl);

    return shortUrlService.generateShortUrl(CLIENT_ID,CLIENT_SECRET,originalUrl);
  }

  @GetMapping()
  public ShortUrlResponseDTO getShortUrl( String originalUrl){
    LOGGER.info("[getShortUrl] perform API CLIENT_ID : {}, CLIENT_SECRET : {}, originalUrl: {}", CLIENT_ID, CLIENT_SECRET,originalUrl);

    ShortUrlResponseDTO shortUrlResponseDTO = new ShortUrlResponseDTO("ss", "ss");
    return shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
  }

  @PutMapping
  public ShortUrlResponseDTO updateShortUrl(@RequestBody String originalUrl){ return null; }

  @DeleteMapping
  public String deleteShortUrl(String url){

    LOGGER.info("[deleteShortUrl] perform API CLIENT_ID : {}, CLIENT_SECRET : {}, originalUrl: {}", CLIENT_ID, CLIENT_SECRET,url);

    try{
      shortUrlService.deleteShortUrl(url);
    }catch(RuntimeException e){
      e.printStackTrace();
    }
    return "Delete!";
  }

}
