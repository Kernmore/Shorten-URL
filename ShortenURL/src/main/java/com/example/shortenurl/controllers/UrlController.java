package com.example.shortenurl.controllers;

import com.example.shortenurl.UrlDTO;
import com.example.shortenurl.UrlResultDTO;
import com.example.shortenurl.UrlService;
import com.example.shortenurl.UrlStatDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }


//    @GetMapping ("/")
//    public String index(@RequestParam(required = false) String shortUrl, Model model){
//        var urls = urlService.getAll();
//        model.addAttribute("urls",urls);
//        model.addAttribute("shortUrl",shortUrl);
//        return "index";
//    }

    @PostMapping("/shorten")
    public UrlResultDTO shorten(@RequestBody UrlDTO urlDTO) {
        long id = urlService.saveUrl(urlDTO);

        var result = new UrlResultDTO();
        result.setUrl(urlDTO.getUrl());
        result.setShortUrl(Long.toString(id));

        return result;
    }

    @GetMapping("/my/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") Long id) {
        var url = urlService.getUrl(id);

        var headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        headers.setCacheControl("no-cache, no-store, must-revalidate");

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/stat")
    public List<UrlStatDTO> stat() {
        return urlService.getStatistics();
    }

    //Task 1
    /**
     * Removes the shortened URL with the specified ID from the database.
     *
     * @param id the ID of the shortened URL to remove
     * @return a ResponseEntity with an HTTP status code indicating the result of the operation
     *         - If the URL is successfully removed, returns an HTTP status code of 200 OK
     *         - If the request is malformed or the URL could not be removed, returns an HTTP status code of 400 Bad Request
     */
    @PostMapping("/remove/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id){
        if(urlService.removeUrl(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Task 2



}
