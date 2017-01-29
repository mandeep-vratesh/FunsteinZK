package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Mandeep on 3/1/2016.
 */
public class DonateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_donate, container,
                false);
        WebView ngo_list = (WebView) v.findViewById(R.id.ngo_list);
        ngo_list.getSettings().setJavaScriptEnabled(true);
        ngo_list.loadUrl("http://www.antiterror.pe.hu/donate/");

        return v;
    }

}
