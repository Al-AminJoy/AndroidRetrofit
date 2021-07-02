package com.alamin.androidretrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    /**
     * All APIes FROM jsonplaceholder.typicode.com
     */

    @GET("posts")
    Call<List<Post>> getPosts();

    /**
     * url like /posts/1
     *If Multiple Parameter Then Just Add @Path() Annotation
     */

    @GET("posts/{id}/comments")
    Call<List<Comment>> getCommentByID(@Path("id") int postID);

    /**
     * url like /comments?postId=1
     *If Multiple Parameter Then Just Add @Query() Annotation
     * Also can use @QueryMap() for Multiple Field
     */
    @GET("comments")
    Call<List<Comment>> getCommentByIDTWO(@Query("postId") int postID);

    @GET("comments")
    Call<List<Comment>> getCommentByMultipleID(@Query("postId") int [] postID);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userID,
            @Field("title") String title,
            @Field("body") String body
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @FieldMap Map<String,String> fields
            );
    @PUT("posts/{id}")
    Call<Post> putPost(@Header("Dynamic-Header") String header, @Path("id") int postId, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int postId,@Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int postId);
}
