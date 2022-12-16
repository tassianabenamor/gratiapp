// Generated by view binder compiler. Do not edit!
package br.edu.infnet.gratiapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import br.edu.infnet.gratiapp.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEditGratiappBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnUpdateGratiapp;

  @NonNull
  public final EditText inputAgradecer;

  @NonNull
  public final TextInputEditText inputData;

  @NonNull
  public final EditText inputHumor;

  @NonNull
  public final TextInputEditText inputNome;

  private FragmentEditGratiappBinding(@NonNull FrameLayout rootView,
      @NonNull Button btnUpdateGratiapp, @NonNull EditText inputAgradecer,
      @NonNull TextInputEditText inputData, @NonNull EditText inputHumor,
      @NonNull TextInputEditText inputNome) {
    this.rootView = rootView;
    this.btnUpdateGratiapp = btnUpdateGratiapp;
    this.inputAgradecer = inputAgradecer;
    this.inputData = inputData;
    this.inputHumor = inputHumor;
    this.inputNome = inputNome;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEditGratiappBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEditGratiappBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_edit_gratiapp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEditGratiappBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_update_gratiapp;
      Button btnUpdateGratiapp = ViewBindings.findChildViewById(rootView, id);
      if (btnUpdateGratiapp == null) {
        break missingId;
      }

      id = R.id.input_agradecer;
      EditText inputAgradecer = ViewBindings.findChildViewById(rootView, id);
      if (inputAgradecer == null) {
        break missingId;
      }

      id = R.id.input_data;
      TextInputEditText inputData = ViewBindings.findChildViewById(rootView, id);
      if (inputData == null) {
        break missingId;
      }

      id = R.id.input_humor;
      EditText inputHumor = ViewBindings.findChildViewById(rootView, id);
      if (inputHumor == null) {
        break missingId;
      }

      id = R.id.input_nome;
      TextInputEditText inputNome = ViewBindings.findChildViewById(rootView, id);
      if (inputNome == null) {
        break missingId;
      }

      return new FragmentEditGratiappBinding((FrameLayout) rootView, btnUpdateGratiapp,
          inputAgradecer, inputData, inputHumor, inputNome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
