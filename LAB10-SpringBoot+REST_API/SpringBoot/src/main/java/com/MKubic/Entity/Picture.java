package com.MKubic.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class Picture {
    public int index;
    public String name;
    public String resolution;
    public long size;
    public long created;

    public Picture(int index, String name) throws IOException {
        this.index=index;
        this.name=name;
        File image=new File("src\\main\\Pictures\\"+name);
        this.size=image.length();
        this.created=image.lastModified();
        BufferedImage img = ImageIO.read(image);
        this.resolution=img.getWidth()+"x"+img.getHeight();
    }

}
