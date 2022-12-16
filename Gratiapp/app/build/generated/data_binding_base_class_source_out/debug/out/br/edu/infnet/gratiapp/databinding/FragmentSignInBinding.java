// Generated by view binder compiler. Do not edit!
package br.edu.infnet.gratiapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import br.edu.infnet.gratiapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSignInBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnSignIn;

  @NonNull
  public final Button btnSignOn;

  @NonNull
  public final TextInputEditText inputEmail;

  @NonNull
  public final TextInputEditText inputPassword;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final TextInputLayout tilEmail;

  @NonNull
  public final TextInputLayout tilPassword;

  private FragmentSignInBinding(@NonNull FrameLayout rootView, @NonNull Button btnSignIn,
      @NonNull Button btnSignOn, @NonNull TextInputEditText inputEmail,
      @NonNull TextInputEditText inputPassword, @NonNull ImageView ivLogo,
      @NonNull TextInputLayout tilEmail, @NonNull TextInputLayout tilPassword) {
    this.rootView = rootView;
    this.btnSignIn = btnSignIn;
    this.btnSignOn = btnSignOn;
    this.inputEmail = inputEmail;
    this.inputPassword = inputPassword;
    this.ivLogo = ivLogo;
    this.tilEmail = tilEmail;
    this.tilPassword = tilPassword;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSignInBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSignInBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_sign_in, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSignInBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_sign_in;
      Button btnSignIn = ViewBindings.findChildViewById(rootView, id);
      if (btnSignIn == null) {
        break missingId;
      }

      id = R.id.btn_sign_on;
      Button btnSignOn = ViewBindings.findChildViewById(rootView, id);
      if (btnSignOn == null) {
        break missingId;
      }

      id = R.id.input_email;
      TextInputEditText inputEmail = ViewBindings.findChildViewById(rootView, id);
      if (inputEmail == null) {
        break missingId;
      }

      id = R.id.input_password;
      TextInputEditText inputPassword = ViewBindings.findChildViewById(rootView, id);
      if (inputPassword == null) {
        break missingId;
      }

      id = R.id.iv_logo;
      ImageView ivLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.til_email;
      TextInputLayout tilEmail = ViewBindings.findChildViewById(rootView, id);
      if (tilEmail == null) {
        break missingId;
      }

      id = R.id.til_password;
      TextInputLayout tilPassword = ViewBindings.findChildViewById(rootView, id);
      if (tilPassword == null) {
        break missingId;
      }

      return new FragmentSignInBinding((FrameLayout) rootView, btnSignIn, btnSignOn, inputEmail,
          inputPassword, ivLogo, tilEmail, tilPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}