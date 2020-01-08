package com.smilegate.shortener.application;

import com.smilegate.shortener.domain.Url;
import com.smilegate.shortener.domain.UrlRepository;
import com.smilegate.shortener.utils.Base62Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Value("${server.port}")
    private String port;

    private UrlRepository urlRepository;
    private Long index;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
        this.index = urlRepository.countAll()+1;
    }

    public String getLongUrl(String shortUrl) {
        return "http://"+urlRepository.findByShortUrl(shortUrl)
                .getLongUrl();
    }

    public String getShortUrl(String longUrl) {
        longUrl = removePrefix(longUrl);

        Url url =  urlRepository.findByLongUrl(longUrl);
        if(url==null) url = createShortUrl(longUrl);
        return "localhost:"+port+"/"+url.getShortUrl();
    }

    private Url createShortUrl(String longUrl) {
        String shortUrl = Base62Util.longTOString(index);
        Url url = new Url(index, longUrl, shortUrl);
        urlRepository.save(url);
        index++;
        return url;
    }

    private String removePrefix(String longUrl) {
        StringBuilder sb = new StringBuilder(longUrl);
        if(longUrl.startsWith("http://")) {
            sb.delete(0, 7);
        }else if(longUrl.startsWith("https://")) {
            sb.delete(0, 8);
        }
        if(sb.toString().startsWith("www.")){
            sb.delete(0,4);
        }
        return sb.toString();
    }

}
