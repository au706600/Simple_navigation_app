package com.example.firstnavigation

import android.util.Log


class Repository {

    data class FriendId(val id: String, val name: String)
    data class FriendDetail(val friendId: FriendId, val age: Int, val mobile: String)
    data class City(val name: String)
    data class School(val id: String, val name: String, val city: City)


    private val errorFriend = FriendDetail(FriendId("badId", "noName"), -1, "00000000")
    private val Friends = listOf(
        FriendDetail(FriendId("1", "John Jacobsen"), 20, "90716050"),
        FriendDetail(FriendId("2", "Jane Jacobsen"), 24, "80203055"),
        FriendDetail(FriendId("3", "Jack Jacobsen"), 28, "95757782"),
        FriendDetail(FriendId("4", "Jill Jacobsen"), 32, "20354030"),
    )

    private val errorSchool = School("badId", "NoSchool", City("No City"))
    private val elementarySchool = listOf(
        School("1","Elementary school", City("Viborg")),
        School("2", "High school", City("Viborg")),
    )

    fun getFriend(id: String?): FriendDetail {
        Log.v("Repository", "GetFriend called")
        if (id == null) {
            Log.e("Repository", "Received null id")
            return errorFriend
        } else {
            return Friends.find { it.friendId.id == id }?:errorFriend

        }
    }

    fun getList(): List<FriendId> {
        Log.v("Repository", "GetList called")
        return Friends.map { it.friendId }
    }

    fun getSchool(id: String?): School?
    {
        Log.v(this::class.simpleName, "Get elementary school $id")
        if (id == null)
        {
            Log.e("Repository", "Received null id")
            return errorSchool
        } else {
            return elementarySchool.find{it.id == id}?:errorSchool
        }
    }

    fun getElementarySchoolList(): List<School>
    {
        Log.v("Repository", "GetElementarySchool called")
        return elementarySchool
    }


}