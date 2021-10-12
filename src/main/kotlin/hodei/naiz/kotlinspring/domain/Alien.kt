package hodei.naiz.kotlinspring.domain

import com.google.cloud.firestore.annotation.DocumentId


/**
 * Created by Hodei Eceiza
 * Date: 10/4/2021
 * Time: 23:23
 * Project: kotlinSpring
 * Copyright: MIT
 */

data class Alien (
    @DocumentId
    val id: String?="",
    val name:String?="",
    val planet:String?=""

)
