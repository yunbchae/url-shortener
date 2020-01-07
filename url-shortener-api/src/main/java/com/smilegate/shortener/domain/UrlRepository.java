package com.smilegate.shortener.domain;

public interface UrlRepository {

    Url findByShortUrl(String shortUrl);

    Url findByLongUrl(String longUrl);

    int save(Url url);

    Long countAll();
}
