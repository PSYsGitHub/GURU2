

package com.example.guru2
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity


@Entity(tableName = "user")

data class User(
    val id: String,
    val username: String,
    val password: String,
    var activity: Boolean =false,
    var healing: Boolean = false,
    var exhibit: Boolean = false,
    var today: Boolean = false,
    var oneday: Boolean = false,
    var longday: Boolean =false
) : Parcelable {
    // Parcelable 생성자
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    )

    // writeToParcel() 메서드로 객체의 데이터를 Parcel로 쓰는 기능 구현
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeByte(if (activity) 1 else 0)
        parcel.writeByte(if (healing) 1 else 0)
        parcel.writeByte(if (exhibit) 1 else 0)
        parcel.writeByte(if (today) 1 else 0)
        parcel.writeByte(if (oneday) 1 else 0)
        parcel.writeByte(if (longday) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0 //사용하지 않음
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
