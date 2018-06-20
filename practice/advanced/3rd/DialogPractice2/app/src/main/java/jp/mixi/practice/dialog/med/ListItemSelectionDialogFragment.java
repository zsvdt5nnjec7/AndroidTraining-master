package jp.mixi.practice.dialog.med;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * TODO: ダイアログで、はい・いいえ の選択肢を表示する
 * TODO: はい、を選択したら、リストの項目を削除する
 * @author keishin.yokomaku
 *
 */
public class ListItemSelectionDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // AlertDialogはBuilderパターンで生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("本当に削除しますか？")
                // OKボタン
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                // Cancelボタン
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Dialogを作成して返却
        return builder.create();
    }
}
