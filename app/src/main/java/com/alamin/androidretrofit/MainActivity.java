package com.alamin.androidretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);

        apiInterface=APIClient.getRetrofitClient().create(APIInterface.class);
        //getPosts();
        //getComments();
        //getCommentsTwo();
        //getCommentsByMultipleID();

        //createPost();
        
        updatePost();
        
        //deletePost();

    }

    private void deletePost() {
        Call<Void> call=apiInterface.deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                textViewResult.setText("Code : "+response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void updatePost() {
        Post post=new Post(5,null,"This Post Is For Test");
        Call<Post> call=apiInterface.putPost("Test",5,post);
       //  Call<Post> call=apiInterface.patchPost(5,post);


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }

                Post postResponse=response.body();
                String content = "";
                content +="Code : "+response.code() +"\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";
                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText("Error : "+t.getMessage());

            }
        });
    }

    private void createPost() {
        Post post=new Post(5,"Test Title 1","This Post Is For Test");
       // Call<Post> call=apiInterface.createPost(post);

      //  Call<Post> call=apiInterface.createPost(25,"Test Title 1","This Post Is For Test");
        Map<String,String> fields=new HashMap<>();
        fields.put("userId","1");
        fields.put("title","Test Title 1");
        fields.put("body","This Post Is For Test");
        Call<Post> call=apiInterface.createPost(fields);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }

                Post postResponse=response.body();
                    String content = "";
                    content +="Code : "+response.code() +"\n";
                    content += "ID: " + postResponse.getId() + "\n";
                    content += "User ID: " + postResponse.getUserId() + "\n";
                    content += "Title: " + postResponse.getTitle() + "\n";
                    content += "Text: " + postResponse.getText() + "\n\n";
                    textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText("Error : "+t.getMessage());

            }
        });
    }

    private void getCommentsByMultipleID() {
        Call<List<Comment>> call=apiInterface.getCommentByMultipleID(new int []{1,2,5});
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }
                List<Comment> commentList=response.body();
                for (Comment comment : commentList) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getCommentsTwo() {
        Call<List<Comment>> call=apiInterface.getCommentByIDTWO(2);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }
                List<Comment> commentList=response.body();
                for (Comment comment : commentList) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call=apiInterface.getCommentByID(2);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }
                List<Comment> commentList=response.body();
                for (Comment comment : commentList) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void getPosts() {
        Call<List<Post>> call=apiInterface.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code : "+response.code());
                    return;
                }
                List<Post> postList=response.body();
                for (Post post : postList) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}