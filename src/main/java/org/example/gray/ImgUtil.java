package org.example.gray;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class ImgUtil {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedImage image = ImageIO.read(new File("redhead.jpg"));
        imageTo(image, "GREYSCALE");
        imageTo(image, "BLACK&WHITE");

    }
    public static void imageTo(BufferedImage image, String string) throws IOException, InterruptedException {
        BufferedImage out = new BufferedImage(image.getWidth(), image.getHeight(), TYPE_INT_RGB);
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < image.getWidth(); ++i) {
            list.add(new Thread(i + "") {
                @Override
                public void run() {
                    try {
                        if (string.equals("GREYSCALE")) {
                            writeGreyscale(image, out, Integer.parseInt(getName()));
                        }
                        else if (string.equals("BLACK&WHITE")) {
                            writeBlackWhite(image, out, Integer.parseInt(getName()));
                        }
                        else {
                            throw new Exception("Not a command !");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        list.forEach(Thread::start);
        for (Thread thread : list) {
            thread.join();
        }
        if (string.equals("GREYSCALE")) {
            ImageIO.write(out, "JPG", new FileOutputStream("greyscale.jpg"));
        }
        else {
            ImageIO.write(out, "JPG", new FileOutputStream("black&white.jpg"));
        }
    }
    public static void writeGreyscale(BufferedImage picture, BufferedImage out, int width) throws IOException {
        for (int j = 0; j < picture.getHeight(); ++j) {
            int R = (picture.getRGB(width, j) & 0x00FF0000) >> 16;
            int G = (picture.getRGB(width, j) & 0x0000FF00) >> 8;
            int B = picture.getRGB(width, j) & 0x000000FF;
            int grey = (int) (0.3 * R + 0.59 * G + 0.11 * B);
            out.setRGB(width, j, new Color(grey, grey, grey).getRGB());
        }
    }
    public static void writeBlackWhite(BufferedImage picture, BufferedImage out, int width) throws IOException {
        for (int j = 0; j < picture.getHeight(); ++j) {
            int R = (picture.getRGB(width, j) & 0x00FF0000) >> 16;
            int G = (picture.getRGB(width, j) & 0x0000FF00) >> 8;
            int B = picture.getRGB(width, j) & 0x000000FF;
            boolean toBlack = ((R + G + B) / 3) < 128;
            if (toBlack) {
                out.setRGB(width, j, new Color(0, 0, 0).getRGB());
            }
            else {
                out.setRGB(width, j, new Color(255, 255, 255).getRGB());
            }
        }
    }
}
