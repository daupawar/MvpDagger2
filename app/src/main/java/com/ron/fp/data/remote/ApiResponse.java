package com.ron.fp.data.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rohan Pawar on 19/05/17.
 */

public class ApiResponse<T> {
    @SerializedName("status")
    public boolean status;

    @SerializedName("code")
    public int code;

    @SerializedName("message")
    public String reason;

    @SerializedName("data")
    public T content;
}
