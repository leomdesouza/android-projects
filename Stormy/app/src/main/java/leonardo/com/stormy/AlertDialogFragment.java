package leonardo.com.stormy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by leosouza on 11/24/16.
 */

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Context context = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle(context.getString(R.string.error_title));
        builder.setMessage(context.getString(R.string.error_message));
        builder.setPositiveButton(context.getString(R.string.error_ok_button_text), null);

        AlertDialog dialog = builder.create();

        return dialog;
    }

}
