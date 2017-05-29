package intro.keddit.kotlin.com.keddit.di

import android.content.Context
import dagger.Module
import dagger.Provides
import intro.keddit.kotlin.com.keddit.KedditApplication
import javax.inject.Singleton

/**
 * Created by Alex Gomez on 5/8/2017.
 */
@Module
class AppModule(val app: KedditApplication) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): KedditApplication =  app
}