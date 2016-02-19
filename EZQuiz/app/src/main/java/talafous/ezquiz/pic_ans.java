package talafous.ezquiz;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class pic_ans extends Fragment {

    private static View view;
    private static TextView changeText1;
    private static TextView changeText2;
    private Drawable doge;
    private Drawable keanu;
    private Drawable mordor;
    private Drawable futuramafry;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pic_ans, container, false);
        changeText1 = (TextView) view.findViewById(R.id.changeText1);
        changeText2 = (TextView) view.findViewById(R.id.changeText2);
        doge = this.getResources().getDrawable(R.drawable.doge);
        keanu = this.getResources().getDrawable(R.drawable.keanu);
        mordor = this.getResources().getDrawable(R.drawable.mordor);
        futuramafry = this.getResources().getDrawable(R.drawable.futuramafry);
        view.setBackground(doge);
        return view;
    }

    public void changePic(int num, int score) {
        if (num == 1) {
            view.setBackground(doge);
            changeText1.setText("");
            changeText2.setText("");
        }
        else if (num == 2) {
            view.setBackground(futuramafry);
            changeText1.setText("??????");
        }
        else if (num == 3) {
            view.setBackground(mordor);
            changeText1.setText("");
            changeText2.setText("??????");
        } else {
            view.setBackground(keanu);
            changeText2.setText(score + " / 2!");
        }
    }
}
