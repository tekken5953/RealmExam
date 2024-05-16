package app.biobats.realmexam

import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where

object RealmObject {
    val realm: Realm by lazy { Realm.getDefaultInstance() }

    fun insert(user: UserModel) {
        realm.executeTransactionAsync {
            it.insertOrUpdate(user)
        }
    }

    fun getUserByName(name: String): UserModel? = realm.where<UserModel>().equalTo("name", name).findFirst()

    fun getAllUsers(): RealmResults<UserModel> {
        return realm.where<UserModel>()
            .findAll().sort("name", Sort.ASCENDING)
    }

    fun deleteAllUsers() {
        realm.executeTransaction {
            it.where<UserModel>().findAll().deleteAllFromRealm()
        }
    }

    fun deleteUserByName(name: String) {
        realm.executeTransaction {
            it.where<UserModel>().equalTo("name", name).findAll().deleteAllFromRealm()
        }
    }
}