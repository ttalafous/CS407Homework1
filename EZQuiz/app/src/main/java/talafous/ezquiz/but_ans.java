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

    butansListener activityCommander;

    int inc = 1;

    public interface butansListener{
        public void clicked(int num);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (butansListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.but_ans, container, false);

        final Button submitbut = (Button) view.findViewById(R.id.submitbut);
        final Button quitbut = (Button) view.findViewById(R.id.quitbut);

        submitbut.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        if(inc == 4){
                            inc = 1;
                            submitbut.setText("Start!");
                        } else if(inc == 1 || inc == 2){
                            submitbut.setText("Submit");
                            inc++;
                        } else{
                            submitbut.setText("Retry?");
                            inc++;
                        }
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
        activityCommander.clicked(1);
    }

    public void quitbutClicked(View view){
        activityCommander.clicked(2);
    }

    public int getInc() {
        return inc;
    }
}
