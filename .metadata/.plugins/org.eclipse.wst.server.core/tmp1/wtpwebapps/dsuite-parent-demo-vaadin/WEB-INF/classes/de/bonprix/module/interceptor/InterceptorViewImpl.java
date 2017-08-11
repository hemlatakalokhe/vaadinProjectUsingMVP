package de.bonprix.module.interceptor;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CheckBox;
import de.bonprix.VaadinUI;
import de.bonprix.vaadin.mvp.view.regular.AbstractMvpView;
import de.bonprix.vaadin.navigator.NavigationRequest;

@SpringView(name = InterceptorViewImpl.VIEW_NAME, ui = { VaadinUI.class }, isDefault = false, order = 30)
public class InterceptorViewImpl extends AbstractMvpView<InterceptorPresenter> implements InterceptorView {

	private static final long serialVersionUID = 2688782241672861374L;

	public static final String VIEW_NAME = "INTERCEPTOR";

	private CheckBox checkBox;

	@Override
	protected void initializeUI() {
		this.checkBox = new CheckBox("SHOW_INTERCEPTOR_DIALOG");
		setSizeFull();
	}

	@Override
	public void checkCheckBox(NavigationRequest request) {
		getPresenter().proceedCheckBox(this.checkBox.getValue(), request);
	}

}
