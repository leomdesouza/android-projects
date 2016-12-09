package leonardo.com.treehouseblog.states;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import leonardo.com.treehouseblog.R;
import leonardo.com.treehouseblog.models.PostModel;
import leonardo.com.treehouseblog.models.TopicModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class    MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private final String mApi = "http://blog.teamtreehouse.com/api/get_recent_summary/?count=20";

    ArrayList<PostModel> mPostModel = new ArrayList<PostModel>();

    TopicModel mTopicModel = new TopicModel();

    @BindView(R.id.titleLabel) TextView mTitleLabel;
    @BindView(R.id.gridDraw) GridView mGridDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if(isNetworkAvailable()){
            response();
        } else{
            Toast.makeText(this, getString(R.string.network_unavailable_message), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isNetworkAvailable() {

        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }

        return isAvailable;
    }

    public void response(){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(mApi).build();

        Call call = client.newCall(request);

        mTopicModel.setIsOk(false);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                try {
                    if (response.isSuccessful()) {

                        String jsonData = response.body().string();
                        //Log.d(TAG, jsonData);
                        mTopicModel.setPostModel(getTopicDetails(jsonData));
                        mTopicModel.setIsOk(true);

                        //Log.d(TAG, mTopicModel.toString());

                        for(int i=0; i<mTopicModel.getPostModel().size(); i++){
                            Log.d(TAG, " " + i + " >>>>>>>>>>>" + mTopicModel.getPostModel().get(i).getImageUrl());
                            Log.d(TAG, " " + i + " >>>>>>>>>>>" + mTopicModel.getPostModel().get(i).getTitle());
                            Log.d(TAG, " " + i + " >>>>>>>>>>>" + mTopicModel.getPostModel().get(i).getUrl());
                            Log.d(TAG, " " + i + " >>>>>>>>>>>" + mTopicModel.getPostModel().get(i).getAuthor());
                            Log.d(TAG, " " + i + " >>>>>>>>>>>" + mTopicModel.getPostModel().get(i).getDate());
                        }

                    } else{
                        mTopicModel.setIsOk(false);
                        Log.d(TAG, "Erro na response da API");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ArrayList<PostModel> getTopicDetails(String jsonData) throws JSONException {

        JSONObject topic = new JSONObject(jsonData);

        ArrayList<PostModel> postModel = new ArrayList<PostModel>();

        JSONArray posts = topic.getJSONArray("posts");

        for(int i=0;i<topic.getInt("count");i++){

            PostModel post2 = new PostModel();
            JSONObject auxiliar = (JSONObject) posts.get(i);

            post2.setImageUrl(auxiliar.getString("thumbnail"));
            post2.setTitle(auxiliar.getString("title"));
            post2.setUrl(auxiliar.getString("url"));
            post2.setAuthor(auxiliar.getString("author"));
            post2.setDate(auxiliar.getString("date"));

            postModel.add(post2);
        }

        // Log.d(TAG, postModel.toString());

        //Log.d(TAG, posts.toString());

        return postModel;

    }


}
