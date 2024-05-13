//package com.example.myapplication
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.painter.Painter
//import com.bumptech.glide.RequestBuilder
//import com.bumptech.glide.load.DataSource
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.load.engine.GlideException
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.bumptech.glide.request.RequestListener
//
//class GlidePainter(
//    private val request: RequestBuilder<out Any>
//) : Painter() {
//
//    private var result: Any? = null
//
//    override val intrinsicSize: android.graphics.Size?
//        get() = null
//
//    override fun DrawScope.onDraw() {
//        // This is a no-op since Glide handles the loading and drawing of the image.
//    }
//
//    @Composable
//    fun rememberGlidePainter(
//        request: RequestBuilder<out Any>
//    ): GlidePainter {
//        return remember(request) {
//            GlidePainter(request)
//        }
//    }
//
//    init {
//        request
//            .transition(DrawableTransitionOptions.withCrossFade())
//            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//            .listener(object : RequestListener<Any?> {
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Any?>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    result = e
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Any?,
//                    model: Any?,
//                    target: Target<Any?>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    result = resource
//                    return false
//                }
//            })
//    }
//}
