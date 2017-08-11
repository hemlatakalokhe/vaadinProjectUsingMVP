package de.bonprix.showcase.cases.wizard.mvp;

import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.bonprix.vaadin.fluentui.FluentUI;
import de.bonprix.vaadin.mvp.wizard.AbstractWizardStep;
import de.bonprix.vaadin.mvp.wizard.OnStepEnter;
import de.bonprix.vaadin.mvp.wizard.OnStepLeave;
import de.bonprix.vaadin.theme.DSuiteTheme;

public class WizardStepOne extends AbstractWizardStep {

	private TextField textFieldName;
	private TextField textFieldStreet;
	private TextField textFieldCity;

	public WizardStepOne(OnStepEnter onStepEnter, OnStepLeave onStepLeave) {
		super("Auswahl (Seite 1)", "Eine Beschreibung", onStepEnter, onStepLeave);
	}

	@Override
	public Component layout() {

		this.textFieldName = new TextField("Name");
		this.textFieldStreet = new TextField("Street");
		this.textFieldCity = new TextField("City");

		// The Layout you want to show in the first Dialog-Step
		FormLayout formLayout = new FormLayout(new Label("Bitte die Felder Füllen!"), this.textFieldName,
				this.textFieldStreet, this.textFieldCity);

		formLayout.setWidth(100, Unit.PERCENTAGE);
		formLayout.setMargin(false);

		VerticalLayout mainLayout = FluentUI.vertical()
											.add(getHeader())
											.add(formLayout)
											.get();

		Panel wizardStep1Panel = new Panel(mainLayout);
		wizardStep1Panel.setSizeFull();
		wizardStep1Panel.setStyleName(DSuiteTheme.DIALOG_PANEL_WHITE);

		return wizardStep1Panel;
	}

	public ShowCasePojo getPojo() {
		ShowCasePojo pojo = new ShowCasePojo();
		pojo.setName(this.textFieldName.getValue());
		pojo.setStreet(this.textFieldStreet.getValue());
		pojo.setCity(this.textFieldCity.getValue());
		return pojo;
	}
}
