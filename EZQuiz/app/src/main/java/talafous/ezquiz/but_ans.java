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
    boolean q2 = false;

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
        final Button choice1 = (Button) view.findViewById(R.id.choiceButton1);
        final Button choice2 = (Button) view.findViewById(R.id.choiceButton2);
        final EditText editText = (EditText) view.findViewById(R.id.editText);
        editText.setVisibility(View.GONE);
        editText.setEnabled(false);
        editText.setClickable(false);
        choice1.setVisibility(View.GONE);
        choice2.setVisibility(View.GONE);
        choice1.setClickable(false);
        choice2.setClickable(false);

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
                            editText.setText("Your Answer Here");
                            editText.setClickable(true);
                            editText.setEnabled(true);
                            inc++;
                        } else if(inc == 2) {
                            submitbut.setText("Submit");
                            if(editText.getText().toString().equals("Futurama Fry") || editText.getText().toString().equals("futurama fry")
                                    || editText.getText().toString().equals("futurama Fry") || editText.getText().toString().equals("Futurama fry")) {
                                q2 = true;
                            }
                            editText.setText("");
                            editText.setClickable(false);
                            editText.setEnabled(false);
                            editText.setVisibility(View.GONE);
                            choice1.setVisibility(View.VISIBLE);
                            choice2.setVisibility(View.VISIBLE);
                            choice1.setClickable(true);
                            choice2.setClickable(true);
                            inc++;
                        } else {
                            submitbut.setText("Retry?");
                            choice1.setVisibility(View.GONE);
                            choice2.setVisibility(View.GONE);
                            choice1.setClickable(false);
                            choice2.setClickable(false);
                            inc++;
                        }
                        submitbutClicked();
                    }
                }
        );

        quitbut.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        quitbutClicked();
                    }
                }
        );

        choice1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        q1 = true;
                    }
                }
        );

        choice2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        q1 = false;
                    }
                }
        );

        return view;
    }

    public void submitbutClicked(){
        activityCommander.clicked(1, q1, q2);
    }

    public void quitbutClicked(){
        activityCommander.clicked(2, q1, q2);
    }

    public int getInc() {
        return inc;
    }
}
