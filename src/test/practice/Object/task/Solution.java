package test.practice.Object.task;


import test.practice.Object.task.ImageReaderFactory;
import test.practice.Object.task.common.*;


public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}
