package com.smilegate.shortener.interfaces;

import com.smilegate.shortener.application.UrlService;
import com.smilegate.shortener.domain.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortUrl}")
    public void redirect(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) throws IOException {
        response.sendRedirect(urlService.getUrl(shortUrl).getLongUrl());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/shortUrl")
    public ResponseEntity<String> createShortenUrl(@RequestBody Url url) throws URISyntaxException {
        String shortUrl = urlService.getShortUrl(url.getLongUrl());
        URI location = new URI("");
        return ResponseEntity.created(location).body(shortUrl);
    }

}
