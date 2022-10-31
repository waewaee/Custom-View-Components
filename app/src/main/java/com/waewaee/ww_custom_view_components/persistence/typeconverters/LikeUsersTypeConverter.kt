package com.waewaee.ww_custom_view_components.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.waewaee.ww_custom_view_components.data.vos.UserVO

class LikeUsersTypeConverter {
    @TypeConverter
    fun toString(userList: ArrayList<UserVO>) : String {
        return Gson().toJson(userList)
    }

    @TypeConverter
    fun toUserList(userListJsonString: String) : ArrayList<UserVO>{
        val usetListType = object : TypeToken<ArrayList<UserVO>>() {}.type
        return Gson().fromJson(userListJsonString, usetListType)
    }
}