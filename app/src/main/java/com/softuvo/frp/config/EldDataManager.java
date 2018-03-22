package com.softuvo.frp.config;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.text.DateFormatSymbols;

public class EldDataManager {
    private static final EldDataManager eldDataManager = new EldDataManager();

    public static EldDataManager
    getInstance() {
        return eldDataManager;
    }

    private EldDataManager() {
    }

    public static String convertImageToStringForServer(Bitmap imageBitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (imageBitmap != null) {
            if (sizeOf(imageBitmap) > 3000000) {
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                byte[] byteArray = stream.toByteArray();
                return Base64.encodeToString(byteArray, Base64.DEFAULT);
            } else if (sizeOf(imageBitmap) > 1000000) {
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream);
                byte[] byteArray = stream.toByteArray();
                return Base64.encodeToString(byteArray, Base64.DEFAULT);
            } else if (sizeOf(imageBitmap) < 1000000) {
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 90, stream);
                byte[] byteArray = stream.toByteArray();
                return Base64.encodeToString(byteArray, Base64.DEFAULT);
            } else {
                int bytes = imageBitmap.getByteCount();
                ByteBuffer bbf = ByteBuffer.allocate(bytes);
                imageBitmap.copyPixelsToBuffer(bbf);
                byte[] bitmarr = bbf.array();
                return Base64.encodeToString(bitmarr, Base64.DEFAULT);
            }
        } else {
            return "";
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static int sizeOf(Bitmap data) {
        return data.getByteCount();
    }

    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }
}
