package com.upgrad.musichoster.api.controller;


import com.upgrad.musichoster.api.model.MusicUploadRequest;
import com.upgrad.musichoster.api.model.MusicUploadResponse;
import com.upgrad.musichoster.service.business.MusicUploadService;
import com.upgrad.musichoster.service.entity.MusicEntity;
import com.upgrad.musichoster.service.exception.UploadFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class MusicUploadController {

    @Autowired
    private MusicUploadService musicUploadService;

    @RequestMapping(method = RequestMethod.POST, path = "/musicupload", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MusicUploadResponse> musicupload(@RequestBody(required = false) final MusicUploadRequest musicUploadRequest, @RequestHeader("authorization") final String authorization) throws
            UploadFailedException, UnsupportedEncodingException {
        final MusicEntity musicEntity = new MusicEntity();

        musicEntity.setDescription(musicUploadRequest.getDescription());
        musicEntity.setMusic(musicUploadRequest.getMusic());
        musicEntity.setName(musicUploadRequest.getName());

        final MusicEntity createdmusicEntity = musicUploadService.upload(musicEntity, authorization);
        MusicUploadResponse uploadResponse = new MusicUploadResponse().id(String.valueOf(musicEntity.getId())).status("Upload Succesful");

        return new ResponseEntity<>(uploadResponse,HttpStatus.OK);

    }
}
