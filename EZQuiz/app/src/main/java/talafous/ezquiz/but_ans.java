package talafous.ezquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;

public class but_ans extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.but_ans, container, false);

        final Button submitbut = (Button) view.findViewById(R.id.submitbut);
        final Button quitbut = (Button) view.findViewById(R.id.quitbut);

        submitbut.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        submitbutClicked(v);
                    }
                }
        );

        quitbut.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        quitbutClicked(v);
                    }
                }
        );

        return view;
    }

    public void submitbutClicked(View view){

    }

    public void quitbutClicked(View view){

    }
}
