package com.pi.javateam.web;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * Created by pi on 2/25/14.
 */
public class TestUtil {

    public static final MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype()
    );
}
