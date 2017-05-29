package intro.keddit.kotlin.com.keddit

import android.app.Application
import intro.keddit.kotlin.com.keddit.di.AppModule
import intro.keddit.kotlin.com.keddit.di.DaggerNewsComponent
import intro.keddit.kotlin.com.keddit.di.NewsComponent

/**
 * Created by Alex Gomez on 5/8/2017.
 */
class KedditApplication : Application() {
    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}