package com.company.samplechecklist.web.loanapplication;

import com.company.samplechecklist.entity.Check;
import com.company.samplechecklist.entity.CheckItem;
import com.company.samplechecklist.entity.LoanApplication;
import com.company.samplechecklist.entity.Option;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class LoanApplicationEdit extends AbstractEditor<LoanApplication> {

    @Inject
    private DataManager dataManager;

    @Inject
    private Metadata metadata;

    @Inject
    private GroupTable<CheckItem> checksTable;

    @Inject
    private ComponentsFactory componentsFactory;


    @Override
    protected void initNewItem(LoanApplication item) {
        super.initNewItem(item);

        item.setChecks(new ArrayList<>());
        List<Check> checks = dataManager.loadList(LoadContext.create(Check.class)
                .setQuery(LoadContext.createQuery("select e from samplechecklist$Check e"))
                .setView("check-edit-view"));

        checks.forEach(i -> {
            CheckItem ci = metadata.create(CheckItem.class);
            ci.setLoanApplication(item);
            ci.setCheck(i);
            item.getChecks().add(ci);
        });

    }

    @Override
    public void ready() {
        super.ready();
        checksTable.expandAll();
    }

    public Component generateOptionCell(CheckItem entity) {
        LookupField lookupField = componentsFactory.createComponent(LookupField.class);
        List options = dataManager.loadList(LoadContext.create(Option.class)
                .setQuery(LoadContext.createQuery("select e from samplechecklist$Option e where e.group.id = :groupId")
                    .setParameter("groupId", entity.getCheck().getOptionsGroup().getId())
                )
        );
        lookupField.setOptionsList(options);
        lookupField.setWidth("100%");
        lookupField.setValue(entity.getOption());
        lookupField.addValueChangeListener(e -> entity.setOption((Option) e.getValue()));
		return lookupField;
    }
}