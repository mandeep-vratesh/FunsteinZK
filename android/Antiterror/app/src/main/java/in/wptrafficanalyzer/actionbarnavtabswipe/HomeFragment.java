package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mandeep on 28/1/2017.
 */
public class HomeFragment extends Fragment {

    //declaring the info buttons on the home screen
    boolean desc1_toggle= false,desc2_toggle= false,desc3_toggle= false,desc4_toggle= false,desc5_toggle= false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container,
                false);

        //initialising the texts
        final TextView desc1 = (TextView) v.findViewById(R.id.desc1);
        final TextView desc2 = (TextView) v.findViewById(R.id.desc2);
        final TextView desc3 = (TextView) v.findViewById(R.id.desc3);
        final TextView desc4 = (TextView) v.findViewById(R.id.desc4);
        final TextView desc5 = (TextView) v.findViewById(R.id.desc5);

        //initialising the buttons
        Button topic1 = (Button) v.findViewById(R.id.topic1);
        Button topic2 = (Button) v.findViewById(R.id.topic2);
        Button topic3 = (Button) v.findViewById(R.id.topic3);
        Button topic4 = (Button) v.findViewById(R.id.topic4);
        Button topic5 = (Button) v.findViewById(R.id.topic5);

        //hiding the text descriptions
        desc1.setHeight(0);
        desc2.setHeight(0);
        desc3.setHeight(0);
        desc4.setHeight(0);
        desc5.setHeight(0);

        //adding animations to the buttons on start
        Animation animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_1);
        //desc1.startAnimation(animate);
        topic1.startAnimation(animate);
        animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_2);
        //desc2.startAnimation(animate);
        topic2.startAnimation(animate);
        animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_3);
        //desc3.startAnimation(animate);
        topic3.startAnimation(animate);
        animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_4);
        //desc4.startAnimation(animate);
        topic4.startAnimation(animate);
        animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_5);
        //desc5.startAnimation(animate);
        topic5.startAnimation(animate);


        //click to expand the text description
        topic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc1_toggle=!(desc1_toggle);
                if(desc1_toggle)
                    desc1.setHeight(1000);
                else
                    desc1.setHeight(0);
            }
        });
        topic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc2_toggle=!(desc2_toggle);
                if(desc2_toggle)
                    desc2.setHeight(1000);
                else
                    desc2.setHeight(0);
            }
        });
        topic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc3_toggle=!(desc3_toggle);
                if(desc3_toggle)
                    desc3.setHeight(1000);
                else
                    desc3.setHeight(0);
            }
        });
        topic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc4_toggle=!(desc4_toggle);
                if(desc4_toggle)
                    desc4.setHeight(1000);
                else
                    desc4.setHeight(0);
            }
        });
        topic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc5_toggle=!(desc5_toggle);
                if(desc4_toggle)
                    desc5.setHeight(500);
                else
                    desc5.setHeight(0);
            }
        });
        return v;
    }
}
