package kr.hs.emirim.xodusguckhan.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.post_01, R.drawable.post_02, R.drawable.post_03, R.drawable.post_04, R.drawable.post_05,
                      R.drawable.post_06, R.drawable.post_07, R.drawable.post_08, R.drawable.post_09, R.drawable.post_10,
                      R.drawable.post_01, R.drawable.post_02, R.drawable.post_03, R.drawable.post_04, R.drawable.post_05,
                      R.drawable.post_06, R.drawable.post_07, R.drawable.post_08, R.drawable.post_09, R.drawable.post_10,
                      R.drawable.post_01, R.drawable.post_02, R.drawable.post_03, R.drawable.post_04, R.drawable.post_05,
                      R.drawable.post_06, R.drawable.post_07, R.drawable.post_08, R.drawable.post_09, R.drawable.post_10};
    String[] postername = {"어벤져스_엔드게임", "센과 치히로의 행방불명", "부산행", "알라딘", "겨울왕국",
                           "겨울왕국2", "미니언즈", "기생충", "라라랜드", "인터스텔라",
                           "어벤져스_엔드게임", "센과 치히로의 행방불명", "부산행", "알라딘", "겨울왕국",
                           "겨울왕국2", "미니언즈", "기생충", "라라랜드", "인터스텔라",
                           "어벤져스_엔드게임", "센과 치히로의 행방불명", "부산행", "알라딘", "겨울왕국",
                           "겨울왕국2", "미니언즈", "기생충", "라라랜드", "인터스텔라"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신영화포스터");
        gridv = findViewById(R.id.gridv);
        PostAdapter adapter = new PostAdapter(this);
        gridv.setAdapter(adapter);

    }

    public class PostAdapter extends BaseAdapter{
        Context context;
        public PostAdapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            GridView.LayoutParams params = new GridView.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle(postername[pos]);
                    dlg.setIcon(R.drawable.m_icon);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close", null);
                    dlg.show();
                }
            });

            return imgv;
        }
    }
}