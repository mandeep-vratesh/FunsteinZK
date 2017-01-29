package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mandeep on 28/1/2017.
 */
public class ReportFragment extends Fragment {
    private StringRequest request;
    private RequestQueue requestQueue;
    String URL ="http://antiterror.pe.hu/add_suspecious.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_suspecious, container,
                false);

        Button camera = (Button) v.findViewById(R.id.camera);
        Button report = (Button) v.findViewById(R.id.report);
        final EditText desc = (EditText) v.findViewById(R.id.description);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        Animation animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_1);
        //desc1.startAnimation(animate);
        desc.startAnimation(animate);
        animate= AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up_2);
        //desc1.startAnimation(animate);
        camera.startAnimation(animate);
        report.startAnimation(animate);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        //send the data about the suspicious object
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    if (jsonObject.names().get(0).equals("success")) {
                                        Toast.makeText(getActivity().getApplicationContext(), jsonObject.getString("success"), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getActivity().getApplicationContext(), "error: " + jsonObject.getString("error"), Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getActivity().getApplicationContext(), "error_response: " + error, Toast.LENGTH_LONG).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap<String, String> hashmap = new HashMap<String, String>();
                                hashmap.put("description", desc.getText().toString());
                                return hashmap;
                            }
                        };
                        requestQueue.add(request);
                    }
                });
        return v;
    }
}
