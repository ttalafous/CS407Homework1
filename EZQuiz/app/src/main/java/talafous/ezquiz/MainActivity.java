package talafous.ezquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements but_ans.butansListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void clicked(int num) {
        if(num == 2) {
            System.exit(0);
        }
        else if(num == 1) {
            pic_ans picAns = (pic_ans) getSupportFragmentManager().findFragmentById(R.id.fragment);
            but_ans butAns = (but_ans) getSupportFragmentManager().findFragmentById(R.id.fragment2);
            picAns.changePic(butAns.getInc());
        }
    }
}
