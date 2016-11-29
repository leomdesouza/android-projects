package leonardo.com.treehouseblog.states;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import leonardo.com.treehouseblog.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titleLabel) TextView mTitleLabel;
    @BindView(R.id.gridDraw) GridView mGridDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



    }
}
