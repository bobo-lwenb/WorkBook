package com.workbook.liuwb.mylibrary.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapUtil {

    public static Bitmap ratio(String filePath, int pixelw, int pixelh) {
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        newOptions.inJustDecodeBounds = true;//  在decode的时候并不是真正的加载图像
        newOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        // 预加载
        BitmapFactory.decodeFile(filePath, newOptions);

        int originalW = newOptions.outWidth;
        int originalH = newOptions.outHeight;

        newOptions.inSampleSize = getSampleSize(originalW, originalH, pixelw, pixelh);

        newOptions.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, newOptions);
    }

    private static int getSampleSize(int originalW, int originalH, int pixelw, int pixelh) {
        int sampleSize = 1;

        if (originalW > originalH && originalW > pixelw) {
            sampleSize = originalW / pixelw;
        } else if (originalH > originalW && originalH > pixelh) {
            sampleSize = originalH / pixelh;
        }

        if (sampleSize <= 0) {
            sampleSize = 1;
        }
        return sampleSize;
    }


}
