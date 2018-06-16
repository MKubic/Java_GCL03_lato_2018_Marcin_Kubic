package com.MKubic.Controller;

import com.MKubic.Entity.Picture;
import com.MKubic.Service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gallery")
public class PictureController {

    @Autowired
    public PictureService pictureService;

    @RequestMapping(value="/pictures",method=RequestMethod.GET)
    public Collection<Picture>getPicture(){
        return pictureService.getPicture();
    }

    @RequestMapping(value="/picture/{id}",method=RequestMethod.GET)
    public ResponseEntity<byte[]> getPictures(@PathVariable("id") int id) throws IOException {
        return this.pictureService.getPictures(id);
    }

    @RequestMapping(value="/picture/{id}",method=RequestMethod.DELETE)
    public Map<String, String> removePicture(@PathVariable("id") int id) throws IOException {

        HashMap<String, String> message = new HashMap<>();
        if(pictureService.pictureData.pictures.containsKey(id)){
            pictureService.removePicture(id);
            message.put("result", "true");
            return message;
        }else{
            message.put("result", "false");
            return message;
        }
    }
    @RequestMapping(value="/upload",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, String> uploadPicture(@PathVariable(name="file")MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        HashMap<String, String> message = new HashMap<>();
        File f=new File("src\\main\\Pictures\\"+file.getOriginalFilename());
        f.createNewFile();
        FileOutputStream output=new FileOutputStream(f);
        output.write(file.getBytes());
        output.close();
        this.pictureService.uploadPicture(file.getOriginalFilename(),pictureService.pictureData.pictures.size());
        if(pictureService.pictureData.pictures.containsKey(pictureService.pictureData.pictures.size()-1)){
            message.put("result", "true");
            return message;
        }else{
            message.put("result", "false");
            return message;
        }
    }

}
