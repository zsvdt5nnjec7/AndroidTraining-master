
package jp.mixi.assignment.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_assignmentdialog).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showAssignmentDialog();
            }
        });
    }

    private void showAssignmentDialog() {
        // TODO:ダイアログを表示する処理を実装してください
        DialogFragment adf = new AssignmentDialogFragment();
        adf.show(getSupportFragmentManager(), "my_dialog_fragment");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // TODO:独自DialogFragmentを実装してください
    // TODO:コンテンツ領域にはEditTextを配置した独自レイアウトを使用してください。また、そのためのレイアウトxmlを作成してください。
    public static class AssignmentDialogFragment extends DialogFragment {
        //final EditText editText = (EditText)findViewByid();
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("名前を入力してください");
            //builder.setView(editText);
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }

            });
            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            return super.onCreateDialog(savedInstanceState);

        }
    }
}
