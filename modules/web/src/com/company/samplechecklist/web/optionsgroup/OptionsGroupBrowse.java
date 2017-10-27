package com.company.samplechecklist.web.optionsgroup;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Named;
import java.util.Map;

public class OptionsGroupBrowse extends AbstractLookup {

    @Named("optionsGroupsTable.edit")
    private EditAction optionsGroupsTableEdit;

    @Named("optionsGroupsTable.create")
    private CreateAction optionsGroupsTableCreate;

    @WindowParam(name = OptionsGroupEdit.COMMAND_SHOW_OPTIONS_EDITOR)
    private Boolean allowEditOptions;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        optionsGroupsTableEdit.setWindowParams(ParamsMap.of("allowEditOptions", allowEditOptions));
        optionsGroupsTableCreate.setWindowParams(ParamsMap.of("allowEditOptions", allowEditOptions));
    }
}