package talafous.ezquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class but_ans extends Fragment {

    butansListener activityCommander;

    int inc = 1;
    boolean q1 = false;
    boolean q2 = true;

    public interface butansListener{
        void clicked(int num, boolean question1, boolean question2);
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
        final Button radio1 = (Button) view.findViewById(R.id.radioButton1);
        final Button radio2 = (Button) view.findViewById(R.id.radioButton2);
        final EditText editText = (EditText) view.findViewById(R.id.editText);
        editText.setVisibility(View.GONE);
        editText.setEnabled(false);
        editText.setClickable(false);
        radio1.setVisibility(View.GONE);
        radio2.setVisibility(View.GONE);
        radio1.setClickable(false);
        radio2.setClickable(false);

        submitbut.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        if(inc == 4){
                            inc = 1;
                            q1 = false;
                            q2 = false;
                            submitbut.setText("Start!");
                        } else if(inc == 1){
                            submitbut.setText("Submit");
                            editText.setVisibility(View.VISIBLE);
                            editText.setText("Your Text Here");
                            editText.setClickable(true);
                            editText.setEnabled(true);
                            inc++;
                        } else if(inc == 2) {
                            submitbut.setText("Submit");
                            if(editText.getText().equals("Futurama Fry") || editText.getText().equals("futurama fry")
                                    || editText.getText().equals("futurama Fry") || editText.getText().equals("Futurama fry")) {
                                q2 = true;
                            }
                            editText.setText("");
                            editText.setClickable(false);
                            editText.setEnabled(false);
                            editText.setVisibility(View.GONE);
                            radio1.setVisibility(View.VISIBLE);
                            radio2.setVisibility(View.VISIBLE);
                            radio1.setClickable(true);
                            radio2.setClickable(true);
                            radio1.setEnabled(true);
                            inc++;
                        } else {
                            submitbut.setText("Retry?");
                            radio1.setVisibility(View.GONE);
                            radio2.setVisibility(View.GONE);
                            radio1.setEnabled(false);
                            radio2.setEnabled(false);
                            radio1.setClickable(false);
                            radio2.setClickable(false);
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

        radio1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        radio1.setEnabled(true);
                        radio2.setEnabled(false);
                        q1 = true;
                    }
                }
        );

        radio2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        radio2.setEnabled(true);
                        radio1.setEnabled(false);
                        q1 = false;
                    }
                }
        );

        return view;
    }

    public void submitbutClicked(View view){
        activityCommander.clicked(1, q1, q2);
    }

    public void quitbutClicked(View view){
        activityCommander.clicked(2, q1, q2);
    }

    public int getInc() {
        return inc;
    }
}
