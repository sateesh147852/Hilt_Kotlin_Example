package com.app.hilt.di

import android.content.Context
import com.app.hilt.R
import com.app.hilt.adapter.NamesAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  @Named("FirstName")
  fun getFirstName(): String = "Sateesh"

  @Provides
  @Named("LastName")
  fun getLastName(): String = "Chikkalagi"

  @Provides
  fun getNumber() : Int = 7

  @Provides
  fun isActive() : Boolean = true

  @Provides
  @Singleton
  fun providerRequestOptions(): RequestOptions {
    return RequestOptions()
      .error(R.mipmap.ic_launcher)
      .placeholder(R.mipmap.ic_launcher)
  }

  @Provides
  @Singleton
  fun providerRequestManager(context: Context): RequestManager {
    return Glide.with(context).applyDefaultRequestOptions(providerRequestOptions())
  }

  @Provides
  fun provideNamesAdapter() : NamesAdapter{
    return NamesAdapter()
  }

  @Provides
  fun provideContext(@ApplicationContext context: Context) : Context = context


}