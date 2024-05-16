package app.biobats.realmexam

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class UserModel (
     @PrimaryKey @Required var name: String? = null,
    var age: Int? = 0
) : RealmObject()