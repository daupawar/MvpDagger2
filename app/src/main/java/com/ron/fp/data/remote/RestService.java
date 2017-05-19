package com.ron.fp.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.ron.fp.data.model.Profile;

import java.lang.reflect.Type;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface RestService {

    String CONNECTIONUR="";

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static RestService newRibotsService() {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(RestService.CONNECTIONUR)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RestService.class);
        }

        static class MyDeserializer<T> implements JsonDeserializer<T>
        {
            @Override
            public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
                    throws JsonParseException
            {
                JsonElement content = je.getAsJsonObject();

                // Deserialize it. You use a new instance of Gson to avoid infinite recursion
                // to this deserializer
                return new Gson().fromJson(content, type);

            }
        }
    }

    /******** Rest services *******/

    @FormUrlEncoded
    @POST("/loginUser")
    Observable<ApiResponse<Profile>> signIn(@Field("email") String username, @Field("password") String password);

}
