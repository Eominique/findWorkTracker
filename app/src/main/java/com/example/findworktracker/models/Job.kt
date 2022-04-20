package com.example.findworktracker.models

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "job_table")
data class Job(

    @SerializedName("candidate_required_location")
    @Expose
    val candidate_required_location: String?,

    @SerializedName("category")
    @Expose
    val category: String?,

    @SerializedName("company_logo_url")
    @Expose
    val company_logo_url: String?,

    @SerializedName("company_name")
    @Expose
    val company_name: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("job_type")
    @Expose
    val job_type: String?,

    @SerializedName("publication_date")
    @Expose
    val publication_date: String?,

    @SerializedName("salary")
    @Expose
    val salary: String?,

//    @SerializedName("tags")
//    @Expose
//    val tags: List<String>,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("url")
    @Expose
    val url: String?,

    @Expose
    var is_mark:Boolean=false
):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(candidate_required_location)
        parcel.writeString(category)
        parcel.writeString(company_logo_url)
        parcel.writeString(company_name)
        parcel.writeString(description)
        parcel.writeInt(id)
        parcel.writeString(job_type)
        parcel.writeString(publication_date)
        parcel.writeString(salary)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeByte(if (is_mark) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Job> {
        override fun createFromParcel(parcel: Parcel): Job {
            return Job(parcel)
        }

        override fun newArray(size: Int): Array<Job?> {
            return arrayOfNulls(size)
        }
    }

}