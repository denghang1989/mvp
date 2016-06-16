package fgecctv.com.appdemo.base.libpresenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Base Fragment working with {@link Presenter}
 * <p>
 * Created by liuyedong on 14-12-24.
 */
public abstract class FragmentView<V extends IView, P extends Presenter<V>> extends Fragment implements IView {

    private P presenter;
    private V viewDelegate;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (viewDelegate == null) {
            viewDelegate = createViewDelegate();
        }
        if (presenter == null) {
            presenter = createPresenter(viewDelegate);
        }
        if (getPresenter() != null) {
            //noinspection unchecked
            getPresenter().takeView(viewDelegate);
            getPresenter().load(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getPresenter() != null) {
            getPresenter().resume();
        }
    }

    @Override
    public void onPause() {
        if (getPresenter() != null) {
            getPresenter().pause();
        }

        super.onPause();
    }

    @Override
    public void onDestroyView() {
        if (getPresenter() != null) {
            //noinspection unchecked
            getPresenter().dropView(viewDelegate);
        }

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().close();
        }

        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    protected V createViewDelegate() {
        return (V) this;
    }

    @SuppressWarnings("UnusedDeclaration")
    public final V getViewDelegate() {
        return viewDelegate;
    }

    @SuppressWarnings("unchecked")
    protected P createPresenter(V view) {
        return (P) view.getPresenter();
    }

    @Override
    public final P getPresenter() {
        return presenter;
    }

    @Override
    public void onPresenterTaken(Presenter presenter) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (getPresenter() != null) {
            getPresenter().save(outState);
        }

        super.onSaveInstanceState(outState);
    }

}
