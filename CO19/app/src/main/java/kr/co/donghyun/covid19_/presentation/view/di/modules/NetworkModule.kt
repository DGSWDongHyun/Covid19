package kr.co.donghyun.covid19_.presentation.view.di.modules

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.donghyun.covid19_.data.constants.Constants
import kr.co.donghyun.covid19_.data.network.api.Covid19NewsParseAPI
import kr.co.donghyun.covid19_.data.network.api.Covid19ParseAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // for xml
    @Singleton
    @Provides
    fun getAPI() : Covid19ParseAPI
            = Retrofit.Builder()
        .baseUrl(Constants.ADDRESS)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
        .build().create(Covid19ParseAPI::class.java)

    //for json
    @Singleton
    @Provides
    fun getAPIJson() : Covid19NewsParseAPI
        = Retrofit.Builder()
        .baseUrl(Constants.NEWS_ADDRESS)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(Covid19NewsParseAPI::class.java)

}