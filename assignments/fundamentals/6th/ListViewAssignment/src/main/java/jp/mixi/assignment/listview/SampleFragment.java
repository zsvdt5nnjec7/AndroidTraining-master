
package jp.mixi.assignment.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleFragment extends Fragment {

    @SuppressWarnings("unused")
    private static final String TAG = SampleFragment.class.getSimpleName();
    private static final String ARG_POSITION_NAME = "position";

    public static SampleFragment newInstance(int position) {

        SampleFragment sampleFragment = new SampleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_POSITION_NAME, position);
        sampleFragment.setArguments(bundle);

        return sampleFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int position = 0;
        if (bundle != null) {
            position = bundle.getInt(ARG_POSITION_NAME);
        }

        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        TextView text = (TextView) view.findViewById(R.id.TextView1);
        text.setText(String.valueOf(position));

        return view;
    }
}
