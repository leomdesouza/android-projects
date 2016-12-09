package leonardo.com.treehouseblog.models;

import java.util.ArrayList;

/**
 * Created by leosouza on 11/29/16.
 */

public class TopicModel {

    private ArrayList<PostModel> mPostModel;
    private Boolean mIsOk;

    public ArrayList<PostModel> getPostModel() {
        return mPostModel;
    }

    public void setPostModel(ArrayList<PostModel> postModel) {
        mPostModel = postModel;
    }

    public Boolean getIsOk() {
        return mIsOk;
    }

    public void setIsOk(Boolean ok) {
        mIsOk = ok;
    }
}
