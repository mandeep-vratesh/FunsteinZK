package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Mandeep on 29/1/2017.
 */
public class AlertFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alert, container,
                false);
        WebView ngo_list = (WebView) v.findViewById(R.id.webViewAlerts);
        ngo_list.getSettings().setJavaScriptEnabled(true);
        ngo_list.loadUrl("http://antiterror.pe.hu/police/listAlert.php");
        return v;
    }
}
