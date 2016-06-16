package fgecctv.com.appdemo.business.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.libpresenter.FragmentView;
import fgecctv.com.appdemo.model.DataManager;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.business.login
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/6/15 09
 */
public class MainFragment extends FragmentView<IMainView, MainPresenter> implements IMainView {

    @BindView(R.id.app_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.et_login)
    EditText login;

    @BindView(R.id.et_password)
    EditText password;

    @BindView(R.id.btn_sign_in)
    Button signIn;

    @BindView(android.R.id.progress)
    ContentLoadingProgressBar progressBar;

    private static final String TAG = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        super.onViewCreated(view, savedInstanceState);
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected MainPresenter createPresenter(IMainView view) {
        return new MainPresenter(DataManager.getInstance(getContext()));
    }

    @Override
    public void setTitle(CharSequence title) {
        if (mToolbar == null) {
            Log.d(TAG, "setTitle: ");
        } else {
            mToolbar.setTitle(title);
        }
    }

    @Override
    public String getAccount() {
        return login.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.show();
    }

    @Override
    public void hideLoading() {
        progressBar.hide();
    }

    @Override
    public void enableSignIn() {
        signIn.setEnabled(true);
    }

    @Override
    public void disableSignIn() {
        signIn.setEnabled(false);
    }

    @Override
    public void handleSignInException(Throwable e) {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleSignInSuccess() {
        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_sign_in)
    void onSignInClicked() {
        getPresenter().onSignInClicked();
    }

    @OnClick(R.id.btn_sign_up)
    void onSignUpClicked() {
        getPresenter().onSignUpClicked();
    }

}
