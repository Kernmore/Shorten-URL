package com.example.shortenurl;

public class UrlResultDTO extends UrlDTO {
    protected String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
