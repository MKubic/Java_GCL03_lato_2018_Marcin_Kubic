package com.MKubic.Data;

import com.MKubic.Entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@Repository
public class PictureData {

    public static Map<Integer, Picture> pictures;

    //@Value("${fileFolder}")
    private static String Path;

    static {
        Path="src\\main\\Pictures\\";
        File f=new File(Path);
        String[] table;
        table=f.list();
        pictures = new HashMap<Integer, Picture>(){
            {

                for(int i = 0; i<table.length; i++){
                    try {
                        put(i, new Picture(i,table[i]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                /*
                try {
                    put(1, new Picture(1, "pociag.jpg"));
                    put(2, new Picture(2, "zachod.jpg"));
                    put(3, new Picture(3, "zacmienie.jpg"));
                    put(4, new Picture(4, "zima.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
            }
        };
    }

    public Collection<Picture> getPicture() {
        return this.pictures.values();
    }
    public ResponseEntity<byte[]> getPictures(int id) throws IOException {
        String name=pictures.get(id).name;
        File f=new File(Path+name);
        byte[] img=Files.readAllBytes(f.toPath());
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.IMAGE_JPEG);
        header.setContentLength(img.length);
        return new ResponseEntity<>(img, header, HttpStatus.OK);
    }
    public void removePicture(int id){
        File f=new File(Path+this.pictures.get(id).name);
        f.delete();
        this.pictures.remove(id);
    }
    public void uploadPicture(String name,int id) throws IOException {
       this.pictures.put(id, new Picture(id, name));
    }
}
