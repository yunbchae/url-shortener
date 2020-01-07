package com.smilegate.shortener.application;

import com.smilegate.shortener.domain.Url;
import com.smilegate.shortener.domain.UrlRepository;
import com.smilegate.shortener.utils.Base62Util;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private UrlRepository urlRepository;
    private Long index;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
        this.index = urlRepository.countAll()+1;
    }

    public Url getUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public String getShortUrl(String longUrl) {
        Url url =  urlRepository.findByLongUrl(longUrl);

        if(url==null) {
            String shortUrl = Base62Util.longTOString(index);
            url = new Url(index, longUrl, shortUrl);
            urlRepository.save(url);
            index++;
        }

        return "localhost:8080/" +url.getShortUrl();
    }

}
