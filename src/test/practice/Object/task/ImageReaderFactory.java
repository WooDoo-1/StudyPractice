package test.practice.Object.task;

import test.practice.Object.task.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (ImageTypes.JPG.equals(imageTypes)) return new JpgReader();
        else if (ImageTypes.BMP.equals(imageTypes)) return new BmpReader();
        else if (ImageTypes.PNG.equals(imageTypes)) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
