package leonardo.com.interactivestory.model;

/**
 * Created by leosouza on 11/17/16.
 */

public class Choice {
    private String mText;
    private int mNextPage;

    public Choice(String text, int nextPage){
        mNextPage = nextPage;
        mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
