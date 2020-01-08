package com.smilegate.shortener.domain;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepositoryImpl implements UrlRepository {

    private final JdbcTemplate jdbcTemplate;

    public UrlRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long countAll() {
        return jdbcTemplate.queryForObject(
                "select count(*) from url;",
                Long.class
        );
    }

    @Override
    public Url findByShortUrl(String shortUrl) {
        return jdbcTemplate.queryForObject(
                "select * from url where short_url = ?;",
                new Object[]{shortUrl},
                (rs, rowNum) ->
                        new Url(
                                rs.getLong("id"),
                                rs.getString("long_url"),
                                rs.getString("short_url")
                        )
        );
    }

    @Override
    public Url findByLongUrl(String longUrl) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from url where long_url = ?;",
                    new Object[]{longUrl},
                    (rs, rowNum) ->
                            new Url(
                                    rs.getLong("id"),
                                    rs.getString("long_url"),
                                    rs.getString("short_url")
                            )
            );
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int save(Url url) {
        return jdbcTemplate.update("insert into url values(?,?,?);",
                url.getId(),
                url.getLongUrl(),
                url.getShortUrl()
        );
    }

}
