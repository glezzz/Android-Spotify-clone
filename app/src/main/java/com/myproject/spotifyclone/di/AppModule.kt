package com.myproject.spotifyclone.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.myproject.spotifyclone.R
import com.myproject.spotifyclone.exoplayer.MusicServiceConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMusicServiceConnection(
        @ApplicationContext context: Context
    ) = MusicServiceConnection(context)

    // tell Dagger the dependencies we need
    // Dagger hilt will call this function behind the scenes for us
    // makes sure we only have one instance of the Glide instance
    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            // if image is not fully loaded, display this one
            .placeholder(R.drawable.ic_image)
            // same for error
            .error(R.drawable.ic_image)
            // makes sure images are cached with Glide
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )
}