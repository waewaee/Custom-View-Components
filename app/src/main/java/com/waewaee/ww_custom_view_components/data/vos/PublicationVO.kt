package com.waewaee.ww_custom_view_components.data.vos

import com.google.gson.annotations.SerializedName

data class PublicationVO(
    @SerializedName("publication_name")var publicationName : String = "",
    @SerializedName("posted_date") var postedDate : String = "",
    @SerializedName("posted_time") var postedTime : String = ""
)