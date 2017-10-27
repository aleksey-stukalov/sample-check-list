package com.company.samplechecklist.web.optionsgroup;

import com.company.samplechecklist.entity.Option;
import com.company.samplechecklist.entity.OptionsGroup;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class OptionsGroupEdit extends AbstractEditor<OptionsGroup> {

    public static final String COMMAND_SHOW_OPTIONS_EDITOR = "allowEditOptions";

    @Inject
    private CollectionDatasource<Option, UUID> optionsDs;

    @Inject
    private Metadata metadata;

    @Inject
    private Button removeButton;

    @Inject
    private Table<Option> optionsTable;

    @Inject
    private GroupBoxLayout optionsGroupBox;

    @WindowParam(name = COMMAND_SHOW_OPTIONS_EDITOR)
    private Boolean allowEditOptions;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        optionsTable.setVisible(allowEditOptions == null ? true : allowEditOptions);
        optionsGroupBox.setVisible(optionsTable.isVisible());

        removeButton.setEnabled(false);
        optionsDs.addItemChangeListener(e -> removeButton.setEnabled(e.getItem() != null));
    }

    public void onCreateButtonClick() {
        Option option = metadata.create(Option.class);
        option.setGroup(getItem());
        optionsDs.addItem(option);
    }

    public void onRemoveButtonClick() {
        optionsDs.removeItem(optionsDs.getItem());
    }

}