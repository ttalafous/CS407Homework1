package talafous.ezquiz;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class pic_ans extends Fragment {

    private static TextView changeText;
    private static View view;
    private Drawable doge;
    private Drawable keanu;
    private Drawable mordor;
    private Drawable futuramafry;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pic_ans, container, false);
        changeText = (TextView) view.findViewById(R.id.changeText);
        doge = this.getResources().getDrawable(R.drawable.doge);
        keanu = this.getResources().getDrawable(R.drawable.keanu);
        mordor = this.getResources().getDrawable(R.drawable.mordor);
        futuramafry = this.getResources().getDrawable(R.drawable.futuramafry);
        view.setBackground(doge);
        return view;
    }

    public void setChangeText(String change) {
        changeText.setText(change);
    }

    public void changePic(int num) {
        if (num == 1) {
            view.setBackground(doge);
        }
        if (num == 2) {
            view.setBackground(futuramafry);
        }
        if (num == 3) {
            view.setBackground(mordor);
        } else {
            view.setBackground(keanu);
        }
    }
}
