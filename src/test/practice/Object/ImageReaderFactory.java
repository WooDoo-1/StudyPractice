package test.practice.Object;

import test.practice.Object.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (ImageTypes.JPG.equals(imageTypes)) return new JpgReader();
        else if (ImageTypes.BMP.equals(imageTypes)) return new BmpReader();
        else if (ImageTypes.PNG.equals(imageTypes)) return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
