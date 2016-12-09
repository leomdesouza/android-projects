package leonardo.com.treehouseblog.states;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import leonardo.com.treehouseblog.R;

/**
 * Created by leosouza on 11/28/16.
 */

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){

        Context context = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(context.getString(R.string.error_title));
        builder.setMessage(context.getString(R.string.error_message));
        builder.setPositiveButton(context.getString(R.string.error_ok_button_text), null);

        AlertDialog dialog = builder.create();

        return dialog;

    }

}
