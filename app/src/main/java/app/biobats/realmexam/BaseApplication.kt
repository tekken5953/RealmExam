package app.biobats.realmexam

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .name("realm.weather")
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)
    }
}