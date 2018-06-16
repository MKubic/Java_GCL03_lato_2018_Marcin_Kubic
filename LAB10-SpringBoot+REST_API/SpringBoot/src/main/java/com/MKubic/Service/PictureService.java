package com.MKubic.Service;

import com.MKubic.Data.PictureData;
import com.MKubic.Entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class PictureService {
    @Autowired
    public PictureData pictureData;

    public Collection<Picture> getPicture(){
        return pictureData.getPicture();
    }

    public ResponseEntity<byte[]> getPictures(int id) throws IOException {
        return this.pictureData.getPictures(id);
    }

    public void removePicture(int id){
        this.pictureData.removePicture(id);
    }
    public void uploadPicture(String name,int id) throws IOException {
        this.pictureData.uploadPicture(name,id);
    }

}
