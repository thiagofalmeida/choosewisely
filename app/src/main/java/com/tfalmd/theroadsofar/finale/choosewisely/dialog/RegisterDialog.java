package com.tfalmd.theroadsofar.finale.choosewisely.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tfalmd.theroadsofar.finale.choosewisely.R;

/**
 * Created by tfalmd on 24/06/15.
 */
public class RegisterDialog extends DialogFragment {

    public interface RegisterListiner {
        public void onDialogPositiveClick(String name);
    }

    private RegisterListiner rListener;
    private View v;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            rListener = (RegisterListiner)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement RegisterListiner");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        v = inflater.inflate(R.layout.register_dialog, null);
        builder.setView(v);

        builder.setTitle(R.string.dialog_title);

        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText name = (EditText) v.findViewById(R.id.etName);

                rListener.onDialogPositiveClick(name.getText().toString());
            }
        });

        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });

        return builder.create();
    }
}
