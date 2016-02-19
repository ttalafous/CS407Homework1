package talafous.ezquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements but_ans.butansListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void clicked(int num, boolean q1, boolean q2) {
        int score;

        if(num == 2) {
            System.exit(1);
        }
        else if(num == 1) {
            pic_ans picAns = (pic_ans) getSupportFragmentManager().findFragmentById(R.id.fragment);
            but_ans butAns = (but_ans) getSupportFragmentManager().findFragmentById(R.id.fragment2);
            int cycle = butAns.getInc();
            if(q1 && q2) {
                score = 2;
            } else if(q1 || q2) {
                score = 1;
            } else {
                score = 0;
            }
            picAns.changePic(cycle, score);
        }
    }
}
