package com.workbook.liuwb.workbook.glide;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.request.RequestOptions.decodeTypeOf;

@GlideExtension
public class MyAppExtension {

    private static final int MINI_THUMB_SIZE = 100;

    private static final RequestOptions DECODE_TYPE_GIF = decodeTypeOf(GifDrawable.class).lock();


    private MyAppExtension() {
    }

    @GlideOption
    public static void miniThumb(RequestOptions options) {
        options.fitCenter()
                .override(MINI_THUMB_SIZE);
    }

    @GlideOption
    public static void miniThumb(RequestOptions options, int size) {
        options.fitCenter()
                .override(size);
    }

//    @GlideType(GifDrawable.class)
//    public static void asGif(RequestBuilder<GifDrawable> builder) {
//        builder.transition(new DrawableTransitionOptions()).apply(DECODE_TYPE_GIF);
//    }

}
