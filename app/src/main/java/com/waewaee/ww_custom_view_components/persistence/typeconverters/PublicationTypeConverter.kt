package com.waewaee.ww_custom_view_components.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.waewaee.ww_custom_view_components.data.vos.PublicationVO

class PublicationTypeConverter {
    @TypeConverter
    fun toString(publicationVO: PublicationVO): String {
        return Gson().toJson(publicationVO)
    }

    @TypeConverter
    fun toPublication(publicationJson: String): PublicationVO {
        val publicationType = object : TypeToken<PublicationVO>() {}.type
        return Gson().fromJson(publicationJson, publicationType)
    }
}