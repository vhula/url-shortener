package io.github.vhula.urlshortener.urls;

import javax.ejb.Singleton;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Singleton
public class ShortenURLService {

    private final ConcurrentMap<String, String> shortenedUrls = new ConcurrentHashMap<>();

    public String shorten(String url) {
        Objects.requireNonNull(url);
        String uuid = UUID.randomUUID().toString();
        shortenedUrls.putIfAbsent(uuid, url);
        return uuid;
    }

    public String resolve(String uuid) {
        Objects.requireNonNull(uuid);
        return shortenedUrls.get(uuid);
    }

}
